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



public class Partie2 extends JFrame implements ActionListener{
	private PanneauPartie2 pane;
	private JButton back,btnGenetic,stopGenetic;
	public JLabel solution ,timer1,maxSat1,genActuelle1,ComplexiteT1,ComplexiteS1;
	public JTable table;
	public JScrollPane scrol; 
	private int nbrVar=75;// A changer vers 75
	public Thread tGentic=null,timerThread1=null;
	public Partie2() {
		pane = new PanneauPartie2();
		back = new JButton();
		btnGenetic = new JButton();
		stopGenetic = new JButton();
		solution = new JLabel();
		timer1 = new JLabel("0");		
		maxSat1 = new JLabel("0");
		genActuelle1 =new JLabel("0");
		ComplexiteT1 = new JLabel("0");
		ComplexiteS1 = new JLabel("0");

		
		
		// initialize Frame
		this.setTitle("Projet Bio-inspired Computing : Partie 2");
		this.setSize(1010, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Button back
        back.setText("<- Back");
        back.setFont(new Font("Georgia", Font.PLAIN, 16));
        back.setForeground(new Color(36,165,233));
        back.setBackground(Color.black);
        Border border = BorderFactory.createLineBorder(Color.WHITE, 3,true);
        
        back.setBorder(border);
        back.setFocusPainted(false);
        back.setBounds(30,10,100,50);
        back.addActionListener(this);
        
        // Button genetic 
        btnGenetic.setText("Excuter");
        btnGenetic.setFont(new Font("Georgia", Font.PLAIN, 12));
        btnGenetic.setForeground(Color.black);
        btnGenetic.setBackground(new Color(36,165,233));
        border = BorderFactory.createLineBorder(Color.white, 3,true);
        
        btnGenetic.setBorder(border);
        btnGenetic.setFocusPainted(false);
        btnGenetic.setBounds(450,245,80,30);
        btnGenetic.addActionListener(this);
        
        // Button Stop
        stopGenetic.setText("Stop");
        stopGenetic.setFont(new Font("Georgia", Font.PLAIN, 12));
        stopGenetic.setForeground(Color.black);
        stopGenetic.setBackground(new Color(36,165,233));
        border = BorderFactory.createLineBorder(Color.white, 3,true);
        
        stopGenetic.setBorder(border);
        stopGenetic.setFocusPainted(false);
        stopGenetic.setBounds(550,245,80,30);
        stopGenetic.addActionListener(this);
        
        
        // Jlabel Solution
        solution.setText("Solution :");
        // solution.setVisible(false);
        solution.setForeground(Color.white);
        solution.setFont(new Font("Georgia", Font.PLAIN, 48));
        solution.setBounds(410,220,230,200);
        solution.setVisible(false);
        // Jlabels
        
        timer1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        timer1.setForeground(new Color(36,165,233));
        timer1.setBounds(330,145,200,12);
        
        maxSat1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        maxSat1.setForeground(new Color(36,165,233));
        maxSat1.setBounds(505,165,60,12);
        
        genActuelle1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        genActuelle1.setForeground(new Color(36,165,233));
        genActuelle1.setBounds(430,185,130,12);

        ComplexiteT1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        ComplexiteT1.setForeground(new Color(36,165,233));
        ComplexiteT1.setBounds(425,205,130,12);

        
        ComplexiteS1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        ComplexiteS1.setForeground(new Color(36,165,233));
        ComplexiteS1.setBounds(410,225,130,12);
        // table
        String[] enTetes = {"Variable","Valeur"};
		Object[][] donnees = new Object[nbrVar][enTetes.length];

 		table =new JTable(donnees,enTetes);
        table.setBackground(new Color(255, 255, 255));
        table.setForeground(Color.black);
        table.getTableHeader().setBackground(new Color(36,165,233));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
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
        scrol.setBounds(0, 350, 995,310);
        scrol.setVisible(false);
 		
        // add component 
        pane.setLayout(null);
        pane.add(back);
        pane.add(btnGenetic);
        pane.add(stopGenetic);
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
		if(e.getSource() == back) {
			if(timerThread1!=null) {
				timerThread1.stop();
			}
			if(tGentic != null) {
				tGentic.stop();
			}
			this.setVisible(false);
			new Accueil();
		}else if(e.getSource() == btnGenetic) {
			System.out.println("Gentic Algo");
			// initialize Label 
			timer1.setText("0");	
			maxSat1.setText("0");
			genActuelle1.setText("0");
			ComplexiteT1.setText("0");
			ComplexiteS1.setText("0");
			solution.setVisible(false);
			scrol.setVisible(false);
			
			
			if(timerThread1 == null) {
				timerThread1 = new Thread(new TimerImpl2(this));
				timerThread1.start();
			}else {
				timerThread1.stop();
				timerThread1 = new Thread(new TimerImpl2(this));
				timerThread1.start();
			}
			
			if(tGentic == null) {
				tGentic = new Thread(new RunImpl2(this));
				tGentic.start();
				
			}else {
				tGentic.stop();
				tGentic = new Thread(new RunImpl2(this));
				tGentic.start();
			}
			
			
			
		}else if( e.getSource() == stopGenetic) {// stop execution 
			if(tGentic !=null) {
				tGentic.stop();
			}
			if(timerThread1 !=null) {
				timerThread1.stop();
			}
		}
		
	}
}
class RunImpl2 implements Runnable {
	Partie2 p2;

	public RunImpl2(Partie2 p2){
	this.p2=p2;
	}
	public void run() {
		//new com.bronzo.bioinsp.heuristique.Main(p2,method);
		new Ga(p2);
	}

}
class TimerImpl2 implements Runnable {
	Partie2 p2;
public TimerImpl2(Partie2 p2){
	this.p2=p2;
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
				p2.timer1.setText(h+":h, "+m+":m, "+s+":s, "+ms+":ms.");	

				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}



