package com.bronzo.bioinsp.heuristique;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;

import com.bronzo.bioinsp.core.Clause;
import com.bronzo.bioinsp.core.Data;
import com.bronzo.bioinsp.core.Litteral;
import com.bronzo.bioinsp.core.Noeud;
import com.bronzo.bioinsp.core.Sat;
import com.bronzo.bioinsp.ui.Partie1;

/**
 * @author M. BOUDISSA, github.com/bronz0
 *
 */
public class Main {
	
	public static ArrayList<Litteral> solutionAleatoire(ArrayList<Litteral> litteraux) {

        ArrayList<Litteral> rand = (ArrayList<Litteral>) litteraux.clone();
        Collections.shuffle(rand);
       
        for (Litteral litteral : rand) {
            litteral.setValeur(ThreadLocalRandom.current().nextInt(0, 2));
            
            
            
        }
        return rand;

    }
	public static String timeConvert(long time) {
		if (time<1000) {
			return time+"ms";
		}else if(time >=1000 && time <60000) {
			double second = time /1000;
			return second+"s";
		}else {
			double s =time/1000;
			double min = Math.round(s / 60);
			s =  Math.round(s - min*60);
			return min+" min"+s+"s";
		}
	}

	public Main(Partie1 p1, String algo) {
		ArrayList<Litteral> litteraux = new ArrayList<Litteral>();
        ArrayList<Clause> clauses = new ArrayList<Clause>();
        try {
             //String sat20=".\\resources\\uf20-91\\uf20-01.cnf";
              String sat75=".\\resources\\uf75-325\\uf75-01.cnf";
            Data satFileManager = new Data(sat75);
            
            // recuperation les litteraux
            litteraux = satFileManager.getLitteraux();
            
            // recuperation les clause
            clauses = satFileManager.getClauses();
            
            // generé une solution aléatoire
            ArrayList<Litteral> rand = solutionAleatoire(litteraux);
            
            long startTime, endTime, time;
            

                  
            // creation d'une instace Sat
            Sat sat = new Sat(litteraux, clauses);
            // crée la racine de l'arbre de recherche
            Noeud racine = new Noeud(rand, (short) 0);

            Heuristique heuristique = new HeuristiqueNbClauseSatisfaites(sat);
          
            startTime = System.currentTimeMillis();
            if(algo.equals("profondeur")) {
            	new Profondeur(racine, sat, p1);
            }else if(algo.equals("largeur")) {
            	new Largeur(racine, sat, p1);
            }else if(algo.equals("a")){
            	new A_(racine, sat, heuristique, p1);
            }else {
            	System.out.println("tyaaaaaaaaaaaaaaaaret");
            }
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            String timeConvert = timeConvert(time);
            System.out.println("time :"+time+"ms");
            if(algo.equals("profondeur")) {
            	p1.timerThread1.stop();
            	p1.timer1.setText("Fini");
            	p1.ComplexiteT1.setText(timeConvert);
            }else if(algo.equals("largeur")) {
            	p1.timerThread2.stop();
            	p1.timer2.setText("Fini");
            	p1.ComplexiteT2.setText(timeConvert);
            }else if(algo.equals("a")){
            	p1.timerThread3.stop();
            	p1.timer3.setText("Fini");
            	p1.ComplexiteT3.setText(timeConvert);
            }else {
            	System.out.println("tnaaaaaaaaawet");
            }




        } catch (IOException iOException) {
            
            iOException.printStackTrace();

        }
		
		
	}
}
