package com.bronzo.bioinsp.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

import com.bronzo.bioinsp.genitique.Ga;

public class Partie3 extends JFrame implements ActionListener {
	private PanneauPartie3 pane;
	private JButton back,btnAnt,stopAnt;
	public JLabel solution ,timer1,maxSat1,genActuelle1,ComplexiteT1,ComplexiteS1;
	public JTable table;
	public JScrollPane scrol; 
	private int nbrVar=75;// A changer vers 75
	public Thread tAnt=null,timerThread1=null;
	public Partie3() {
		pane = new PanneauPartie3();
		back = new JButton();
		btnAnt = new JButton();
		stopAnt = new JButton();
		solution = new JLabel();
		timer1 = new JLabel("0");		
		maxSat1 = new JLabel("0");
		genActuelle1 =new JLabel("0");
		ComplexiteT1 = new JLabel("0");
		ComplexiteS1 = new JLabel("0");

		
		
		// initialize Frame
		this.setTitle("Projet Bio-inspired Computing : Partie 3");
		this.setSize(1010, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Button back
        back.setText("<- Back");
        back.setFont(new Font("Georgia", Font.PLAIN, 16));
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        Border border = BorderFactory.createLineBorder(Color.WHITE, 3,true);
        
        back.setBorder(border);
        back.setFocusPainted(false);
        back.setBounds(30,10,100,50);
        back.addActionListener(this);
        
        // Button genetic 
        btnAnt.setText("Excuter");
        btnAnt.setFont(new Font("Georgia", Font.PLAIN, 12));
        btnAnt.setForeground(Color.white);
        btnAnt.setBackground(Color.black);
        border = BorderFactory.createLineBorder(Color.white, 3,true);
        
        btnAnt.setBorder(border);
        btnAnt.setFocusPainted(false);
        btnAnt.setBounds(450,245,80,30);
        btnAnt.addActionListener(this);
        
        // Button Stop
        stopAnt.setText("Stop");
        stopAnt.setFont(new Font("Georgia", Font.PLAIN, 12));
        stopAnt.setForeground(Color.white);
        stopAnt.setBackground(Color.black);
        border = BorderFactory.createLineBorder(Color.white, 3,true);
        
        stopAnt.setBorder(border);
        stopAnt.setFocusPainted(false);
        stopAnt.setBounds(550,245,80,30);
        stopAnt.addActionListener(this);
        
        
        // Jlabel Solution
        solution.setText("Solution :");
        // solution.setVisible(false);
        solution.setForeground(Color.white);
        solution.setFont(new Font("Georgia", Font.PLAIN, 48));
        solution.setBounds(410,220,230,200);
        solution.setVisible(false);
        // Jlabels
        
        timer1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        timer1.setForeground(Color.white);
        timer1.setBounds(330,145,200,12);
        
        maxSat1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        maxSat1.setForeground(Color.white);
        maxSat1.setBounds(505,165,60,12);
        
        genActuelle1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        genActuelle1.setForeground(Color.white);
        genActuelle1.setBounds(430,185,130,12);

        ComplexiteT1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        ComplexiteT1.setForeground(Color.white);
        ComplexiteT1.setBounds(425,205,130,12);

        
        ComplexiteS1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        ComplexiteS1.setForeground(Color.white);
        ComplexiteS1.setBounds(410,225,130,12);
        // table
        String[] enTetes = {"Variable","Valeur"};
		Object[][] donnees = new Object[nbrVar][enTetes.length];

 		table =new JTable(donnees,enTetes);
        table.setBackground(new Color(255, 255, 255));
        table.setForeground(Color.black);
        table.getTableHeader().setBackground(Color.BLACK);
        table.getTableHeader().setForeground(Color.white);
        // to remove vertical grid
       // table.setShowVerticalLines(false);
        // to centre data 
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<table.getColumnCount();i++) {
        	table.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }
        // set Font
        Font font = new Font("Arial",5,16);
        table.setFont(font);
        font = new Font("Georgia",1,16);
        table.getTableHeader().setFont(font);
        table.setRowHeight(35);
        scrol = new JScrollPane(table);
        scrol.setBounds(100, 350, 795,250);
        //scrol.setVisible(false);
 		
        // add component 
        pane.setLayout(null);
        pane.add(back);
        pane.add(btnAnt);
        pane.add(stopAnt);
        pane.add(solution);
        pane.add(timer1);
        pane.add(maxSat1);
        pane.add(genActuelle1);
        pane.add(ComplexiteT1);
        pane.add(ComplexiteS1);
        pane.add(scrol);
        
        this.getContentPane().add(pane);
        this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() ==  back) {
			/*if(timerThread1!=null) {
				timerThread1.stop();
			}
			if(tGentic != null) {
				tGentic.stop();
			}*/
			this.setVisible(false);
			new Accueil();
		}
		
	}
}
class RunImpl3 implements Runnable {
	Partie3 p3;

	public RunImpl3(Partie3 p3){
	this.p3=p3;
	}
	public void run() {
		//new com.bronzo.bioinsp.heuristique.Main(p2,method);
		//new Ga(p2);
	}

}
class TimerImpl3 implements Runnable {
	Partie3 p3;
public TimerImpl3(Partie3 p3){
	this.p3=p3;
}
	public void run() {
		int ms=0,s=0,m=0,h=0;
		while(true) {
			try {
				Thread.sleep(1);
				if(ms>1000) {
					ms=0;
					s++;
				}
				if(s>60) {
					ms=0;
					s=0;
					m++;
				}
				if(m>60) {
					ms=0;
					s=0;
					m=0;
					h++;
				}
				ms++;
				p3.timer1.setText(h+":h, "+m+":m, "+s+":s, "+ms+":ms.");	

				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}




