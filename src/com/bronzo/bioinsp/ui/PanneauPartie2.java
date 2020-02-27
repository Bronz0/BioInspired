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
public class PanneauPartie2 extends JPanel{
	public void paintComponent(Graphics g){
		Image img=null;
		try {
			// Background
			img = ImageIO.read(new File(("./resources/BackgroundPartie2.jpg")));
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			// Text 1 : Algorithmes
			g.setColor(Color.white);
			Font font = new Font("Georgia", Font.PLAIN, 48);
			AttributedString methodText= new AttributedString("Algorithme Génétiques :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 250,50);
			// Box1
			g.setColor(Color.white);
			g.fillRect(250, 80, 500, 205);
			g.setColor(Color.black);
			g.fillRect(254,84, 492, 197 );
			// Text 
			g.setColor(new Color(36,165,233));
			font = new Font("Georgia", Font.PLAIN, 16);
			methodText= new AttributedString("Alogorithme : Algorithme Génétiques .");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 259,110);
			/**************************Text******************************/
			g.setColor(new Color(36,165,233));
			font = new Font("Georgia", Font.BOLD, 18);
			methodText= new AttributedString("Détails :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 265,135);
			/**************************Text******************************/
			g.setColor(new Color(36,165,233));
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Timer :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 275,155);		
			/**************************Text******************************/
			g.setColor(new Color(36,165,233));
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Nombre de clause satisfaisable(Max) :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 275,175);
			/**************************Text******************************/
			g.setColor(new Color(36,165,233));
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Nombre de générations :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(), 275,195);
			/**************************Text******************************/
			g.setColor(new Color(36,165,233));
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Complexité temporelle :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(),275,215);
			/**************************Text******************************/
			g.setColor(new Color(36,165,233));
			font = new Font("Georgia", Font.PLAIN, 12);
			methodText= new AttributedString("- Complexité spatiale :");
			methodText.addAttribute(TextAttribute.FONT, font);
			g.drawString(methodText.getIterator(),275,235);
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

