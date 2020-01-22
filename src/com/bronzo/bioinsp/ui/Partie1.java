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

public class Partie1 extends JFrame  implements ActionListener {
	public PanneauPartie1 container ;
	public JLabel solution ,timer1,timer2,timer3,maxSat1,maxSat2,maxSat3,profActuelle1,profActuelle2,profActuelle3,ComplexiteT1,ComplexiteT2,ComplexiteT3,ComplexiteS1,ComplexiteS2,ComplexiteS3;
	public JButton back,btnProfondeur,btnLargeur,btnAetoil;
	public JTable table ;
	public Partie1() {
		// initialize attribute
		container = new PanneauPartie1();
		
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
		
		back = new JButton();
		btnProfondeur = new JButton();
		btnLargeur = new JButton();
		btnAetoil = new JButton();
		
		solution = new JLabel();
		// Table 
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
		
		// initialize Frame
		this.setTitle("Projet Bio-inspired Computing : Partie 1");
		this.setSize(1010, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // JLabel 
        solution.setText("Solution :");
       // solution.setVisible(false);
        solution.setFont(new Font("Georgia", Font.PLAIN, 48));
        solution.setBounds(410,220,230,200);
        
        
        timer1.setFont(new Font("Georgia", Font.PLAIN, 12));
        timer1.setBounds(100,145,60,15);
        
        timer2.setFont(new Font("Georgia", Font.PLAIN, 12));
        timer2.setBounds(435,145,60,15);
        
        timer3.setFont(new Font("Georgia", Font.PLAIN, 12));
        timer3.setBounds(755,145,60,15);
        
        maxSat1.setFont(new Font("Georgia", Font.PLAIN, 12));
        maxSat1.setBounds(275,165,60,15);
        
        maxSat2.setFont(new Font("Georgia", Font.PLAIN, 12));
        maxSat2.setBounds(610,165,60,15);
        
        maxSat3.setFont(new Font("Georgia", Font.PLAIN, 12));
        maxSat3.setBounds(930,165,60,15);
        
        profActuelle1.setFont(new Font("Georgia", Font.PLAIN, 12));
        profActuelle1.setBounds(175,185,60,15);
        
        profActuelle2.setFont(new Font("Georgia", Font.PLAIN, 12));
        profActuelle2.setBounds(510,185,60,15);
        
        profActuelle3.setFont(new Font("Georgia", Font.PLAIN, 12));
        profActuelle3.setBounds(830,185,60,15);
        
        ComplexiteT1.setFont(new Font("Georgia", Font.PLAIN, 12));
        ComplexiteT1.setBounds(195,205,60,15);
        
        ComplexiteT2.setFont(new Font("Georgia", Font.PLAIN, 12));
        ComplexiteT2.setBounds(530,205,60,15);
        
        ComplexiteT3.setFont(new Font("Georgia", Font.PLAIN, 12));
        ComplexiteT3.setBounds(850,205,60,15);
        
        ComplexiteS1.setFont(new Font("Georgia", Font.PLAIN, 12));
        ComplexiteS1.setBounds(175,225,60,15);
        
        ComplexiteS2.setFont(new Font("Georgia", Font.PLAIN, 12));
        ComplexiteS2.setBounds(515,225,60,15);
        
        ComplexiteS3.setFont(new Font("Georgia", Font.PLAIN, 12));
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
        // table
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
        container.add(btnLargeur);
        container.add(btnAetoil);
        
        container.add(scrol);
        
        // Add Container to frame
        this.getContentPane().add(container);
        this.setVisible(true);
       
	}
	
	// Event Listener 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == back) {
			System.out.println("Back");
			this.setVisible(false);
			new Accueil();
		}else if (e.getSource() == btnProfondeur) {
			System.out.println("profondeur");
			new com.bronzo.bioinsp.heuristique.Main(this, "profondeur");
		}else if (e.getSource() == btnLargeur) {
			new com.bronzo.bioinsp.heuristique.Main(this, "largeur");
		}else {
			new com.bronzo.bioinsp.heuristique.Main(this, "a");
		}
	}
}

class PanneauPartie1 extends JPanel{
	public void paintComponent(Graphics g){
		Image img=null;
		try {
			// Background
			img = ImageIO.read(new File(("./resources/BackgroundPartie1.jpg")));
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			// Text 1 : Algorithmes
			g.setColor(Color.white);
			Font font = new Font("Georgia", Font.PLAIN, 48);
			AttributedString methodText= new AttributedString("Alogorithmes :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 350,50);
			// Box1
			g.setColor(Color.black);
			g.fillRect(25, 80, 300, 205);
			g.setColor(new Color(214, 214, 194));
			g.fillRect(29,84, 292, 197 );
			// Text 
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 16);
			methodText= new AttributedString("Alogorithme : Par profondeur .");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 40,110);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.BOLD, 18);
			methodText= new AttributedString("Détails :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 40,135);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Timer :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 45,155);		
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Nombre de clause satisfaisable(Max) :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 45,175);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Profondeur actuelle :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 45,195);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Complexité temporelle :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(),45,215);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Complexité spatiale :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(),45,235);
			
			
			// Box2
			g.setColor(Color.black);
			g.fillRect(350, 80, 300, 205);
			g.setColor(new Color(214, 214, 194));
			g.fillRect(354,84, 292, 197);
			// Text 
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 16);
			methodText= new AttributedString("Alogorithme : Par largeur .");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 370,110);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.BOLD, 18);
			methodText= new AttributedString("Détails :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 370,135);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Timer :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 380,155);	
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Nombre de clause satisfaisable(Max) :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 380,175);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Profondeur actuelle :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 380,195);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Complexité temporelle :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 380,215);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Complexité spatiale :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(),380,235);
			
			// Box3
			g.setColor(Color.black);
			g.fillRect(675, 80, 300, 205);
			g.setColor(new Color(214, 214, 194));
			g.fillRect(679,84, 292, 197);
			// Text 
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 16);
			methodText= new AttributedString("Alogorithme : A* .");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 690,110);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.BOLD, 18);
			methodText= new AttributedString("Détails :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 690,135);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Timer :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 700,155);	
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Nombre de clause satisfaisable(Max) :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 700,175);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Profondeur actuelle :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 700,195);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Complexité temporelle :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 700,215);
			/**************************Text******************************/
			g.setColor(Color.black);
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Complexité spatiale :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 700,235);
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

