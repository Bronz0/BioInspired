package com.bronzo.bioinsp.heuristique;

import java.util.ArrayList;

import javax.swing.JFrame;

import com.bronzo.bioinsp.core.Litteral;
import com.bronzo.bioinsp.core.Noeud;
import com.bronzo.bioinsp.core.Sat;
import com.bronzo.bioinsp.ui.Partie1;

/**
 * @author M. BOUDISSA, github.com/bronz0
 *
 */
public class Largeur extends Algorithme{
	// attributs
	private Noeud racine;
	private Sat sat;

	// constructeur
	public Largeur(Noeud racine, Sat sat, Partie1 p1) {
		this.racine = racine;
		this.sat = sat;

		int max = 0;
		// creation d'une file ouverte
		File ouverte = new File();

		// creation d'une liste fermee
		ArrayList<Noeud> fermee = new ArrayList<Noeud>();

		// ajouter le Noeud initial a ouvertee
		ouverte.add(racine);

		// tantque ouverte n'est pas vide
		while (!ouverte.isEmpty()) {
			// retirer le premier element de ouverte
			Noeud actuel = ouverte.remove();

			// si l'instance existe dans la liste fermee on ignore le traitment
			if (fermee.contains(actuel)) {

				continue;
			}

			// actualiser le nombre maximal des clauses satisfaites
			if (this.sat.nbClauseSatisfaite(actuel.getLitteraux()) > max) {
				max = this.sat.nbClauseSatisfaite(actuel.getLitteraux());
				System.out.println("nombre de clauses satisfaites : " + max);
			}

			// tester la satisfiabilite de la solution
			boolean satisfiable = this.sat.test(actuel.getLitteraux());
			// afficher la profondeur
			//System.out.println(actuel.getProfondeur());
			// si la solution est satisfiable
			if (satisfiable) {
				// afficher la solution
				System.out.println("solution trouver");
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
					// changer la valeur de litteral a la position i
					int tmp = solution[i] == 1 ? 0 : 1;
					ArrayList<Litteral> solutionFils = new ArrayList<Litteral>();
					for (int j = 0; j < actuel.getLitteraux().size(); j++) {
						solutionFils.add(new Litteral(actuel.getLitteraux().get(j)));
						if (j == i) {
							solutionFils.get(j).setValeur(tmp);
						} else {
							solutionFils.get(j).setValeur(actuel.getLitteraux().get(j).getValeur());
						}

					}

					// une autre facone a faire
					// solutionFils = (ArrayList<Litteral>) actuel.getLitteraux().clone();
					// solutionFils.get(i).setValeur(solution[i] == 1 ? 0 : 1);

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
