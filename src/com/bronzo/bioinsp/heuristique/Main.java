package com.bronzo.bioinsp.heuristique;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import com.bronzo.bioinsp.core.Clause;
import com.bronzo.bioinsp.core.Data;
import com.bronzo.bioinsp.core.Litteral;
import com.bronzo.bioinsp.core.Noeud;
import com.bronzo.bioinsp.core.Sat;

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

	public static void main(String[] args) {
		ArrayList<Litteral> litteraux = new ArrayList<Litteral>();
        ArrayList<Clause> clauses = new ArrayList<Clause>();
        try {
             String sat20=".\\resources\\uf20-91\\uf20-01.cnf";
             // String sat75=".\\resource\\uf75-325\\uf75-01.cnf";
            Data satFileManager = new Data(sat20);
            
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

          

           //Profondeur profondeur = new Profondeur(racine, sat);
           //Largeur largeur = new Largeur(racine, sat);



//            // cree une huristique FrequenceHuristique
            startTime = System.currentTimeMillis();
            Heuristique heuristique = new HeuristiqueNbClauseSatisfaites(sat);
             A_ a = new A_(racine, sat, heuristique);
            endTime = System.currentTimeMillis();
            time = endTime - startTime;
            System.out.println("time :"+time+"ms");
        } catch (IOException iOException) {
            
            iOException.printStackTrace();

        }
	}

}
