package com.bronzo.bioinsp.heuristique;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import com.bronzo.bioinsp.acs.Fourmi;
import com.bronzo.bioinsp.core.Litteral;
import com.bronzo.bioinsp.core.Noeud;
import com.bronzo.bioinsp.core.Sat;
import com.bronzo.bioinsp.ui.Partie1;

/**
 * @author M. BOUDISSA, github.com/bronz0
 *
 */
public class A_ extends Algorithme{
	// attributs
	private Noeud racine;
	private Sat sat;
	
	// contructeur
	public A_(Noeud racine, Sat sat, Comparator heuristique, Partie1 p1) {
		this.racine = racine;
		this.sat = sat;
		
		int max = 0;
		PriorityQueue<Noeud> ouverte = new PriorityQueue<>(heuristique);
        ouverte.add(racine);
        ArrayList<Noeud> fermet = new ArrayList<Noeud>();

        while (!ouverte.isEmpty()) {

            Noeud actuel = ouverte.poll();
            //si l'instance existe dans l'ensemble fermet on ignore le traitment 
            if (fermet.contains(actuel)) {

                continue;
            }
            if(this.sat.nbClauseSatisfaite(actuel.getLitteraux())>max) {
            	max = this.sat.nbClauseSatisfaite(actuel.getLitteraux());
            	System.out.println("max of sat clauses is : "+max);
            	p1.maxSat3.setText(""+max);
            }
            System.out.println(actuel.getProfondeur());
            p1.profActuelle3.setText(""+actuel.getProfondeur());
            boolean satisfaible = this.sat.test(actuel.getLitteraux());

            if (satisfaible) {
            	p1.solution.setVisible(true);
            	int k=0;
                System.out.println("solution trouver");
                ArrayList<Litteral> solution = actuel.getLitteraux();
                for (Litteral litteral : solution) {
                    System.out.println(litteral.getIndex() + "=" + litteral.getValeur());
                    p1.table3.getModel().setValueAt("X"+litteral.getIndex()+"", k, 0);
                    p1.table3.getModel().setValueAt(litteral.getValeur()+"", k, 1);
                    k++;
                }
                p1.scrol3.setVisible(true);
                
                break;
            } else {

                // recuperer la solution actuel est la mettre dans un tableau    
                int[] solution = new int[actuel.getLitteraux().size()];
                for (int i = 0; i < solution.length; i++) {

                    solution[i] = actuel.getLitteraux().get(i).getValeur();
                }
                
                // pour chque element dans la solution on genere un fils qui port l'inverse de cet element dans sa position voire EXEMPLE
                for (int i = 0; i < actuel.getLitteraux().size(); i++) {
                    //inverser l'element de la position actuel
                    int tmp = solution[i] == 1 ? 0 : 1;
                    //cree un fils        
                    ArrayList<Litteral> solutionFils = new ArrayList<Litteral>();

                    //clone le pere dans le fils sauf l'element de la position actuel
                    for (int j = 0; j < actuel.getLitteraux().size(); j++) {
                        solutionFils.add(new Litteral(actuel.getLitteraux().get(j)));

                        // mettre l'inverse de l'element dans le fils 
                        if (j == i) {

                            solutionFils.get(j).setValeur(tmp);
                        } else {
                            //sinon on copy just l'element du pere
                            solutionFils.get(j).setValeur(actuel.getLitteraux().get(j).getValeur());
                        }

                    }
                    //crée un Noeud dans l'arbre de recherche
                    Noeud fils = new Noeud(solutionFils, (short) (actuel.getProfondeur() + 1));
                    //mettre la liaison entre le père est le fils
                    fils.setPere(actuel);
                    //ajouter le fils a l'ensemble ouverte
                    ouverte.add(fils);

                }
                //ajouter le père a l'ensemble fermet
                fermet.add(actuel);

            }

        }

	}

	public A_(Noeud racine, Sat sat, Comparator heuristique, Fourmi f) {
		this.racine = racine;
		this.sat = sat;
		
		int max = 0;
		PriorityQueue<Noeud> ouverte = new PriorityQueue<>(heuristique);
        ouverte.add(racine);
        ArrayList<Noeud> fermet = new ArrayList<Noeud>();

        while (!ouverte.isEmpty()) {

            Noeud actuel = ouverte.poll();
            //si l'instance existe dans l'ensemble fermet on ignore le traitment 
            if (fermet.contains(actuel)) {

                continue;
            }
            if(this.sat.nbClauseSatisfaite(actuel.getLitteraux())>max) {
            	max = this.sat.nbClauseSatisfaite(actuel.getLitteraux());
            	System.out.println("max of sat clauses is : "+max);
            }
            System.out.println(actuel.getProfondeur());
            boolean satisfaible = this.sat.test(actuel.getLitteraux());

            if (satisfaible) {
            	int k=0;
                System.out.println("solution trouver");
                ArrayList<Litteral> solution = actuel.getLitteraux();
                for (Litteral litteral : solution) {
                    System.out.println(litteral.getIndex() + "=" + litteral.getValeur());
                    k++;
                }
                f.setProf(actuel.getProfondeur());
                f.setSolution(solution);
                
                break;
            } else {

                // recuperer la solution actuel est la mettre dans un tableau    
                int[] solution = new int[actuel.getLitteraux().size()];
                for (int i = 0; i < solution.length; i++) {

                    solution[i] = actuel.getLitteraux().get(i).getValeur();
                }
                
                // pour chque element dans la solution on genere un fils qui port l'inverse de cet element dans sa position voire EXEMPLE
                for (int i = 0; i < actuel.getLitteraux().size(); i++) {
                    //inverser l'element de la position actuel
                    int tmp = solution[i] == 1 ? 0 : 1;
                    //crée un fils        
                    ArrayList<Litteral> solutionFils = new ArrayList<Litteral>();

                    //cloné le père dans le fils sauf l'element de la position actuel
                    for (int j = 0; j < actuel.getLitteraux().size(); j++) {
                        solutionFils.add(new Litteral(actuel.getLitteraux().get(j)));

                        // mettre l'inverse de l'element dans le fils 
                        if (j == i) {

                            solutionFils.get(j).setValeur(tmp);
                        } else {
                            //sinon on copy just l'element du père
                            solutionFils.get(j).setValeur(actuel.getLitteraux().get(j).getValeur());
                        }

                    }
                    //crée un Noeud dans l'arbre de recherche
                    Noeud fils = new Noeud(solutionFils, (short) (actuel.getProfondeur() + 1));
                    //mettre la liaison entre le père est le fils
                    fils.setPere(actuel);
                    //ajouter le fils a l'ensemble ouverte
                    ouverte.add(fils);

                }
                //ajouter le père a l'ensemble fermet
                fermet.add(actuel);

            }

        }

	}

}
