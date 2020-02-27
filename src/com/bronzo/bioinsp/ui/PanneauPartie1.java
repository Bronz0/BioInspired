package com.bronzo.bioinsp.ui;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.text.AttributedString;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author N. GHALMI, github.com/p1po
 *
 */
public class PanneauPartie1 extends JPanel {
	
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

