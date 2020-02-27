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






/**
 * @author N. GHALMI, github.com/p1po
 *
 */
public class Partie1 extends JFrame  implements ActionListener {
	private PanneauPartie1 container ;
	public JLabel solution ,timer1,timer2,timer3,maxSat1,maxSat2,maxSat3,profActuelle1,profActuelle2,profActuelle3,ComplexiteT1,ComplexiteT2,ComplexiteT3,ComplexiteS1,ComplexiteS2,ComplexiteS3;
	private JButton back,btnProfondeur,btnLargeur,btnAetoil,stopProfondeur,stopLargeur,stopAetoil;
	public JTable table1,table2,table3 ;
	public JScrollPane scrol1,scrol2,scrol3;
	private Thread tProf = null,tLarg=null,tA_=null;
	private int nbrVar=75;// A changer vers 75
	public Thread timerThread1=null,timerThread2=null,timerThread3=null;
	public Partie1() {
		// initialize container
		container = new PanneauPartie1();
		
		// initialize label information
		timer1 = new JLabel("0");
		timer2 = new JLabel("0");
		timer3 = new JLabel("0");
		
		maxSat1 = new JLabel("0");
		maxSat2 = new JLabel("0");
		maxSat3 = new JLabel("0");
		
		profActuelle1 =new JLabel("0");
		profActuelle2 =new JLabel("0");
		profActuelle3 =new JLabel("0");
		
		ComplexiteT1 = new JLabel("0");
		ComplexiteT2 = new JLabel("0");
		ComplexiteT3 = new JLabel("0");
		
		ComplexiteS1 = new JLabel("0");
		ComplexiteS2 = new JLabel("0");
		ComplexiteS3 = new JLabel("0");
		
		// initialize Buttons
		back = new JButton();
		btnProfondeur = new JButton();
		btnLargeur = new JButton();
		btnAetoil = new JButton();
		
		stopProfondeur= new JButton();
		stopLargeur= new JButton();
		stopAetoil= new JButton();
		
		
		// initialize solution label
		solution = new JLabel();
		
		// tables headers
		String[] enTetes = {"Variable","Valeur"};
		
		// initialize data for tables
		Object[][] donnees = new Object[nbrVar][enTetes.length];
		Object[][] donnees2 = new Object[nbrVar][enTetes.length];
		Object[][] donnees3 = new Object[nbrVar][enTetes.length];
		
		// initialize tables
		table1 =new JTable(donnees,enTetes);
		table2 =new JTable(donnees2,enTetes);
		table3 =new JTable(donnees3,enTetes);
		
		// initialize Frame
		this.setTitle("Projet Bio-inspired Computing : Partie 1");
		this.setSize(1010, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // JLabel soltuion 
        solution.setText("Solution :");
        solution.setVisible(false);
        solution.setFont(new Font("Georgia", Font.PLAIN, 48));
        solution.setBounds(410,220,230,200);
        
        // JLabel Information
        timer1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        timer1.setBounds(100,145,200,15);
        
        timer2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        timer2.setBounds(435,145,200,15);
        
        timer3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        timer3.setBounds(755,145,200,15);
        
        maxSat1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        maxSat1.setBounds(275,165,60,15);
        
        maxSat2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        maxSat2.setBounds(610,165,60,15);
        
        maxSat3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        maxSat3.setBounds(930,165,60,15);
        
        profActuelle1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        profActuelle1.setBounds(175,185,130,15);
        
        profActuelle2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        profActuelle2.setBounds(510,185,130,15);
        
        profActuelle3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        profActuelle3.setBounds(830,185,130,15);
        
        ComplexiteT1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        ComplexiteT1.setBounds(195,205,130,15);
        
        ComplexiteT2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        ComplexiteT2.setBounds(530,205,130,15);
        
        ComplexiteT3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        ComplexiteT3.setBounds(850,205,130,15);
        
        ComplexiteS1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        ComplexiteS1.setBounds(175,225,60,15);
        
        ComplexiteS2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        ComplexiteS2.setBounds(515,225,60,15);
        
        ComplexiteS3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        ComplexiteS3.setBounds(830,225,60,15);
        // JButton Back
        back.setText("<- Back");
        back.setFont(new Font("Georgia", Font.PLAIN, 16));
        back.setForeground(Color.black);
        back.setBackground(new Color(214, 214, 194));
        Border border = BorderFactory.createLineBorder(Color.black, 3,true);
        
        back.setBorder(border);
        back.setFocusPainted(false);
        back.setBounds(30,10,100,50);
        back.addActionListener(this);
        // Profondeur button
        btnProfondeur.setText("Excuter");
        btnProfondeur.setFont(new Font("Georgia", Font.PLAIN, 12));
        btnProfondeur.setForeground(Color.black);
        btnProfondeur.setBackground(new Color(36,165,233));
        border = BorderFactory.createLineBorder(Color.black, 3,true);
        
        btnProfondeur.setBorder(border);
        btnProfondeur.setFocusPainted(false);
        btnProfondeur.setBounds(130,245,80,30);
        btnProfondeur.addActionListener(this);
        
     // stop Profondeur button
        stopProfondeur.setText("Stop");
        stopProfondeur.setFont(new Font("Georgia", Font.PLAIN, 12));
        stopProfondeur.setForeground(Color.black);
        stopProfondeur.setBackground(new Color(36,165,233));
        border = BorderFactory.createLineBorder(Color.black, 3,true);
        
        stopProfondeur.setBorder(border);
        stopProfondeur.setFocusPainted(false);
        stopProfondeur.setBounds(230,245,80,30);
        stopProfondeur.addActionListener(this);
        
        
        
        // Largeur button
        btnLargeur.setText("Excuter");
        btnLargeur.setFont(new Font("Georgia", Font.PLAIN, 12));
        btnLargeur.setForeground(Color.black);
        btnLargeur.setBackground(new Color(36,165,233));
        border = BorderFactory.createLineBorder(Color.black, 3,true);
        
        btnLargeur.setBorder(border);
        btnLargeur.setFocusPainted(false);
        btnLargeur.setBounds(450,245,80,30);
        btnLargeur.addActionListener(this);
        
     // stop Largeur button
        stopLargeur.setText("Stop");
        stopLargeur.setFont(new Font("Georgia", Font.PLAIN, 12));
        stopLargeur.setForeground(Color.black);
        stopLargeur.setBackground(new Color(36,165,233));
        border = BorderFactory.createLineBorder(Color.black, 3,true);
        
        stopLargeur.setBorder(border);
        stopLargeur.setFocusPainted(false);
        stopLargeur.setBounds(550,245,80,30);
        stopLargeur.addActionListener(this);
        
        
        
        // Aetoil button
        btnAetoil.setText("Excuter");
        btnAetoil.setFont(new Font("Georgia", Font.PLAIN, 12));
        btnAetoil.setForeground(Color.black);
        btnAetoil.setBackground(new Color(36,165,233));
        border = BorderFactory.createLineBorder(Color.black, 3,true);
        
        btnAetoil.setBorder(border);
        btnAetoil.setFocusPainted(false);
        btnAetoil.setBounds(780,245,80,30);
        btnAetoil.addActionListener(this);
        
        // stop Aetoil button
        stopAetoil.setText("Stop");
        stopAetoil.setFont(new Font("Georgia", Font.PLAIN, 12));
        stopAetoil.setForeground(Color.black);
        stopAetoil.setBackground(new Color(36,165,233));
        border = BorderFactory.createLineBorder(Color.black, 3,true);
        
        stopAetoil.setBorder(border);
        stopAetoil.setFocusPainted(false);
        stopAetoil.setBounds(880,245,80,30);
        stopAetoil.addActionListener(this);
        
        // tables 
        table1.setBackground(new Color(255, 255, 255));
        table1.setForeground(Color.black);
        table1.getTableHeader().setBackground(new Color(36,165,233));
        table1.getTableHeader().setForeground(new Color(255, 255, 255));
        
        // to centre data 
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<table1.getColumnCount();i++) {
        	table1.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }
        // set Font
        Font font = new Font("Arial",5,16);
        table1.setFont(font);
        font = new Font("Georgia",1,16);
        table1.getTableHeader().setFont(font);
        table1.setRowHeight(35);
        scrol1 = new JScrollPane(table1);
        scrol1.setBounds(29,350, 292, 300);// changer positon
        scrol1.setVisible(false);
        
        // table 2
        table2.setBackground(new Color(255, 255, 255));
        table2.setForeground(Color.black);
        table2.getTableHeader().setBackground(new Color(36,165,233));
        table2.getTableHeader().setForeground(new Color(255, 255, 255));
        // to centre data 
        rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<table2.getColumnCount();i++) {
        	table2.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }
        // set Font
        font = new Font("Arial",5,16);
        table2.setFont(font);
        font = new Font("Georgia",1,16);
        table2.getTableHeader().setFont(font);
        table2.setRowHeight(35);
        scrol2 = new JScrollPane(table2);
        scrol2.setBounds(354,350, 292, 300);// set position
        scrol2.setVisible(false);
        
        //table 3
        table3.setBackground(new Color(255, 255, 255));
        table3.setForeground(Color.black);
        table3.getTableHeader().setBackground(new Color(36,165,233));
        table3.getTableHeader().setForeground(new Color(255, 255, 255));
        // to centre data 
        rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<table3.getColumnCount();i++) {
        	table3.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }
        // set Font
        font = new Font("Arial",5,16);
        table3.setFont(font);
        font = new Font("Georgia",1,16);
        table3.getTableHeader().setFont(font);
        table3.setRowHeight(35);
        scrol3 = new JScrollPane(table3);
        scrol3.setBounds(679,350, 292, 300);
        scrol3.setVisible(false);
        
        // Add Component 
        container.setLayout(null);
        container.add(solution);
        
        container.add(timer1);
        container.add(timer2);
        container.add(timer3);
        
        container.add(maxSat1);
        container.add(maxSat2);
        container.add(maxSat3);
        
        container.add(profActuelle1);
        container.add(profActuelle2);
        container.add(profActuelle3);
        
        container.add(ComplexiteT1);
        container.add(ComplexiteT2);
        container.add(ComplexiteT3);
        
        container.add(ComplexiteS1);
        container.add(ComplexiteS2);
        container.add(ComplexiteS3);
        
        container.add(back);
        container.add(btnProfondeur);
        container.add(stopProfondeur);
        container.add(btnLargeur);
        container.add(stopLargeur);
        container.add(btnAetoil);
        container.add(stopAetoil);
        
        container.add(scrol1);
        container.add(scrol2);
        container.add(scrol3);
        
        // Add Container to frame
        this.getContentPane().add(container);
        this.setVisible(true);
       
	}
	
	// Event Listener 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == back) {
			if(tProf != null) {
				tProf.stop();
			}
			if(tLarg != null) {
				tLarg.stop();
			}
			if(tA_ != null) {
				tA_.stop();
			}
			if(timerThread1!=null) {
				timerThread1.stop();
			}
			if(timerThread2!=null) {
				timerThread2.stop();
			}
			if(timerThread3!=null) {
				timerThread3.stop();
			}
			this.setVisible(false);
			new Accueil();
		}else if (e.getSource() == btnProfondeur) {
			// initialize details
			timer1.setText("0");	
			maxSat1.setText("0");
			profActuelle1.setText("0");
			ComplexiteT1.setText("0");
			ComplexiteS1.setText("0");
			//solution.setVisible(false);
			scrol1.setVisible(false);
			
			
			if(timerThread1 == null) {
				timerThread1 = new Thread(new TimerImpl(this,"profondeur"));
				timerThread1.start();
			}else {
				timerThread1.stop();
				timerThread1 = new Thread(new TimerImpl(this,"profondeur"));
				timerThread1.start();
			}
			
			
			if(tProf == null) {
				tProf = new Thread(new RunImpl(this,"profondeur"));
				tProf.start();
				
			}else {
				tProf.stop();
				tProf = new Thread(new RunImpl(this,"profondeur"));
				tProf.start();
			}
			
		}else if (e.getSource() == btnLargeur) {
			// initialize details
			timer2.setText("0");	
			maxSat2.setText("0");
			profActuelle2.setText("0");
			ComplexiteT2.setText("0");
			ComplexiteS2.setText("0");
			//solution.setVisible(false);
			scrol2.setVisible(false);
			
			if(timerThread2 == null) {
				timerThread2 = new Thread(new TimerImpl(this,"largeur"));
				timerThread2.start();
			}else {
				timerThread2.stop();
				timerThread2 = new Thread(new TimerImpl(this,"largeur"));
				timerThread2.start();
			}
			
			
			if(tLarg == null) {
				tLarg = new Thread(new RunImpl(this,"largeur"));
				tLarg.start();
				
			}else {
				tLarg.stop();
				tLarg = new Thread(new RunImpl(this,"largeur"));
				tLarg.start();
			}
		}else if(e.getSource() == btnAetoil){
			// initialize details
			timer3.setText("0");	
			maxSat3.setText("0");
			profActuelle3.setText("0");
			ComplexiteT3.setText("0");
			ComplexiteS3.setText("0");
			//solution.setVisible(false);
			scrol3.setVisible(false);
			
			if(timerThread3 == null) {
				timerThread3 = new Thread(new TimerImpl(this,"a"));
				timerThread3.start();
			}else {
				timerThread3.stop();
				timerThread3 = new Thread(new TimerImpl(this,"a"));
				timerThread3.start();
			}
			
			if(tA_ == null) {
				tA_ = new Thread(new RunImpl(this,"a"));
				tA_.start();
				
			}else {
				tA_.stop();
				tA_ = new Thread(new RunImpl(this,"a"));
				tA_.start();
			}
		}else if(e.getSource() == stopProfondeur){
			if(timerThread1 !=null) {
				timerThread1.stop();
			}
			if(tProf !=null) {
				tProf.stop();
			}
			
		}else if(e.getSource() == stopLargeur){
			if(timerThread2 !=null) {
				timerThread2.stop();
			}
			if(tProf !=null) {
				tLarg.stop();
			}
			
		}else if(e.getSource() == stopAetoil){
			if(timerThread3 !=null) {
				timerThread3.stop();
			}
			if(tA_ !=null) {
				tA_.stop();
			}
		}
	}
}
class RunImpl implements Runnable {
	Partie1 p1;
	String method;
	public RunImpl(Partie1 p1,String Method){
	this.p1=p1;
	this.method=Method;
	}
	public void run() {
		new com.bronzo.bioinsp.heuristique.Main(p1,method);
	}

}
class TimerImpl implements Runnable {
	Partie1 p1;
	String method;
public TimerImpl(Partie1 p1,String method){
	this.p1=p1;
	this.method=method;
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
				if(method.equals("profondeur")) {
					p1.timer1.setText(h+":h, "+m+":m, "+s+":s, "+ms+":ms.");					
				}else if(method.equals("largeur")) {
					p1.timer2.setText(h+":h, "+m+":m, "+s+":s, "+ms+":ms.");					
				}else {
					p1.timer3.setText(h+":h, "+m+":m, "+s+":s, "+ms+":ms.");	
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}

