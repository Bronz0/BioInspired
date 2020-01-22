package com.bronzo.bioinsp.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.text.AttributedString;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

public class Partie2 extends JFrame implements ActionListener{
	PanneauPartie2 pane;
	JButton back,btnGenetic;
	JLabel solution ,timer1,maxSat1,profActuelle1,ComplexiteT1,ComplexiteS1;
	JTable table;
	public Partie2() {
		pane = new PanneauPartie2();
		back = new JButton();
		btnGenetic = new JButton();
		solution = new JLabel();
		timer1 = new JLabel("0");		
		maxSat1 = new JLabel("0");
		profActuelle1 =new JLabel("0");
		ComplexiteT1 = new JLabel("0");
		ComplexiteS1 = new JLabel("0");

		
		
		// initialize Frame
		this.setTitle("Projet Bio-inspired Computing : Partie 1");
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
        
        // Jlabel Solution
        solution.setText("Solution :");
        // solution.setVisible(false);
        solution.setForeground(Color.white);
        solution.setFont(new Font("Georgia", Font.PLAIN, 48));
        solution.setBounds(410,220,230,200);
        // Jlabels
        
        timer1.setFont(new Font("Georgia", Font.PLAIN, 12));
        timer1.setForeground(new Color(36,165,233));
        timer1.setBounds(330,145,12,12);
        
        maxSat1.setFont(new Font("Georgia", Font.PLAIN, 12));
        maxSat1.setForeground(new Color(36,165,233));
        maxSat1.setBounds(505,165,12,12);
        
        profActuelle1.setFont(new Font("Georgia", Font.PLAIN, 12));
        profActuelle1.setForeground(new Color(36,165,233));
        profActuelle1.setBounds(410,185,12,12);

        ComplexiteT1.setFont(new Font("Georgia", Font.PLAIN, 12));
        ComplexiteT1.setForeground(new Color(36,165,233));
        ComplexiteT1.setBounds(425,205,12,12);

        
        ComplexiteS1.setFont(new Font("Georgia", Font.PLAIN, 12));
        ComplexiteS1.setForeground(new Color(36,165,233));
        ComplexiteS1.setBounds(410,225,12,12);
        // table
     	String[] enTetes = {"Indice","Variable","Valeur","Evaluation"};
 		Object[][] donnees =  {{"1","-X1","0","1"},
 							   {"2","-X2","1","0"},
 							   {"3","-X3","1","0"},
 							   {"4","-X4","1","0"},
 							   {"5","X5","1","1"},
 							   {"6","X5","1","1"},
 							   {"7","X5","1","1"},
 							   {"8","X5","1","1"},
 							   {"9","X5","1","1"},
 							   {"10","X5","1","1"},
 							   {"11","X5","1","1"},
 							   {"12","X5","1","1"},
 		};
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
        JScrollPane scrol = new JScrollPane(table);
        scrol.setBounds(0, 350, 995,310);
 		
        // add component 
        pane.setLayout(null);
        pane.add(back);
        pane.add(btnGenetic);
        pane.add(solution);
        pane.add(timer1);
        pane.add(maxSat1);
        pane.add(profActuelle1);
        pane.add(ComplexiteT1);
        pane.add(ComplexiteS1);
        pane.add(scrol);
        
        this.getContentPane().add(pane);
        this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			this.setVisible(false);
			new Accueil();
		}else if(e.getSource() == btnGenetic) {
			System.out.println("Gentic Algo");
		}
		
	}
}

