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
import javax.swing.JPanel;
import javax.swing.border.Border;


/**
 * @author N. GHALMI, github.com/p1po
 *
 */
public class Accueil extends JFrame implements ActionListener { //Done 
	PanneauAccueil pane ;
	JButton btnPartie1,btnPartie2,btnPartie3;

	public Accueil() {
		pane =new PanneauAccueil();
		btnPartie1 = new JButton();
		btnPartie2 = new JButton();
		btnPartie3 = new JButton();
		
		this.setTitle("Projet Bio-inspired Computing : Accueil");
		this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Button 1
        btnPartie1.setText("Part One");
        btnPartie1.setFont(new Font("Georgia", Font.PLAIN, 24));
        btnPartie1.setForeground(new Color(36,165,233));
        btnPartie1.setBackground(Color.black);
        Border border = BorderFactory.createLineBorder(Color.WHITE, 3,true);
        
        btnPartie1.setBorder(border);
        btnPartie1.setFocusPainted(false);
        btnPartie1.setBounds(100,450, 130, 60);
        btnPartie1.addActionListener(this);
      
        
        // Button 2
        btnPartie2.setText("Part Two");
        btnPartie2.setFont(new Font("Georgia", Font.PLAIN, 24));
        btnPartie2.setForeground(new Color(36,165,233));
        btnPartie2.setBackground(Color.black);
        
        
        btnPartie2.setBorder(border);
        btnPartie2.setFocusPainted(false);
        btnPartie2.setBounds(400,450, 130, 60);
        btnPartie2.addActionListener(this);
        
        // Button 3
        btnPartie3.setText("Part Three");
        btnPartie3.setFont(new Font("Georgia", Font.PLAIN, 24));
        btnPartie3.setForeground(new Color(36,165,233));
        btnPartie3.setBackground(Color.black);
        
        btnPartie3.setBorder(border);
        btnPartie3.setFocusPainted(false);
        btnPartie3.setBounds(700,450, 130, 60);
        btnPartie3.addActionListener(this);

        
        
        // Container
        pane.add(btnPartie1);
        pane.add(btnPartie2);
        pane.add(btnPartie3);
        pane.setLayout(null);
        this.getContentPane().add(pane);
        this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = ((JButton)e.getSource()).getText();
		if(str.equals("Part One")) {
			//System.out.println("Partie 1");
			this.setVisible(false);
			new Partie1();
		}
		else if(str.equals("Part Two")) {
			//System.out.println("Partie 2");
			this.setVisible(false);
			new Partie2();
			
			this.setVisible(false);
		}else {
			//System.out.println("Partie 3");	
			this.setVisible(false);
			new Partie3();
			
		}
		
	}
}
class PanneauAccueil extends JPanel{
	
	public void paintComponent(Graphics g){
		Image img=null;
		try {
			// Background
			img = ImageIO.read(new File(("./resources/background.jpg")));
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			// Text 1
			g.setColor(Color.white);
			Font font = new Font("Georgia", Font.PLAIN, 72);
			AttributedString methodText= new AttributedString("Project");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 350,150);
			// Text 2
			methodText= new AttributedString("Bio-Inspired Computing");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 100,250);
			// Text 3
			methodText= new AttributedString("Heuristics & Meta-heuristics");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 40,350);

		
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}


