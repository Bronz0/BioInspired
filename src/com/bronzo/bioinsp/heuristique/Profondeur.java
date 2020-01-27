package com.bronzo.bioinsp.heuristique;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;

import com.bronzo.bioinsp.core.Litteral;
import com.bronzo.bioinsp.core.Noeud;
import com.bronzo.bioinsp.core.Sat;
import com.bronzo.bioinsp.ui.Partie1;

/**
 * @author M. BOUDISSA, github.com/bronz0
 *
 */
public class Profondeur extends Algorithme{
	// attributs
	private Noeud racine;
	private Sat sat;

	// constructeur
	public Profondeur(Noeud racine, Sat sat, Partie1 p1) {
		this.racine = racine;
		this.sat = sat;

		int max = 0;
		// creation d'une pile ouverte
		Stack<Noeud> ouverte = new Stack<Noeud>();

		// creation d'une liste fermee
		ArrayList<Noeud> fermee = new ArrayList<Noeud>();
		
		// ajout de la racine dans ouverte
		ouverte.add(racine);

		// tantque la pile ouverte n'est pas vide
		while (!ouverte.isEmpty()) {
			// retirer un noeud.
			Noeud actuel = ouverte.pop();
			// si l'instance existe dans l'ensemble fermee on ignore le traitment
			if (fermee.contains(actuel)) {

				continue;
			}
			// actualiser le nombre max des clauses satisfaites
			if (this.sat.nbClauseSatisfaite(actuel.getLitteraux()) > max) {
				max = this.sat.nbClauseSatisfaite(actuel.getLitteraux());
				System.out.println("max of sat clauses is : " + max);
				p1.maxSat1.setText(""+max);
			}

			// afficher la profondeur
			// System.out.println(actuel.getProfondeur());
			p1.profActuelle1.setText(""+actuel.getProfondeur());
			// tester la satisfiabilite de la solution
			boolean satisfiable = this.sat.test(actuel.getLitteraux());
			// si la solution est satisfaible
			if (satisfiable) {
				// afficher la solution.
				System.out.println("solution trouvee");
				ArrayList<Litteral> solution = actuel.getLitteraux();
				for (Litteral litteral : solution) {
					System.out.println(litteral.getIndex() + "=" + litteral.getValeur());

				}
				break;

			} else { // sinon on generer N autres fils

				// recuperer la solution actuelle et la mettre dans un tableau
				int[] solution = new int[actuel.getLitteraux().size()];
				for (int i = 0; i < solution.length; i++) {

					solution[i] = actuel.getLitteraux().get(i).getValeur();
				}

				for (int i = 0; i < actuel.getLitteraux().size(); i++) {
					// inverser l'element de la position actuel
					int tmp = solution[i] == 1 ? 0 : 1;
					// creation d'un fils
					ArrayList<Litteral> solutionFils = new ArrayList<Litteral>();

					// clone le pere dans le fils sauf l'element de la position actuel
					for (int j = 0; j < actuel.getLitteraux().size(); j++) {
						solutionFils.add(new Litteral(actuel.getLitteraux().get(j)));

						// mettre l'inverse de l'element dans le fils
						if (j == i) {

							solutionFils.get(j).setValeur(tmp);
						} else {
							// sinon on copy just l'element du pere
							solutionFils.get(j).setValeur(actuel.getLitteraux().get(j).getValeur());
						}

					}
			
					// creer le fils et incrementer la profondeur
					Noeud fils = new Noeud(solutionFils, (short) (actuel.getProfondeur() + 1));
					// creer un chainage avec la solution precedente
					fils.setPere(actuel);
					// ajouter le neuveau fils a ouverte
					ouverte.add(fils);

				}
				// ajouter le noeud actuel a fermee
				fermee.add(actuel);

			}

		}
	}
}
