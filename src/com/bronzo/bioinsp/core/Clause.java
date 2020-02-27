package com.bronzo.bioinsp.core;

import java.util.ArrayList;

/**
 * @author M. BOUDISSA, github.com/bronz0
 *
 */

// une clause c'est conjonction des litteraux
public class Clause {
	// attributs
	private ArrayList<Litteral> litteraux;
	

	// constructeurs
	public Clause(ArrayList<Litteral> litteraux) {
		this.litteraux = litteraux;
	}

	public Clause(Clause c) {
		this.litteraux = c.litteraux;
	}
	
	// getters setters
	public ArrayList<Litteral> getLitteraux() {
		return litteraux;
	}
	
	public void setLitteraux(ArrayList<Litteral> litteraux) {
		this.litteraux = litteraux;
	}
	
	/**
	 * verifie si la clause est satisfaite par la solution
	 * 
	 * @param solution (une liste des litteraux)
	 * @return entier O ou 1
	 */
	public int clauseSatisfaite(ArrayList<Litteral> solution) {
		for (Litteral s : solution) {
			for (Litteral l : this.litteraux) {
				if (Math.abs(l.getIndex()) == s.getIndex()) {
					// litteral = -X avec X = 0
					if (l.getIndex() < 0 && s.getValeur() == 0) {
						return 1;
					}
					// litteral = X avec X = 1
					if (l.getIndex() > 0 && s.getValeur() == 1) {
						return 1;
					}

				}
			}
		}
		// si litteral = -X avec X = 1 ou litteral = X avec X = 0
		return 0;
	}

	/**
	 * verifie si la clause est satisfaite par la solution
	 * 
	 * @param solution (tableu d'entier)
	 * @return entier O ou 1
	 */
	public int clauseSatisfaite(int[] solution) {
		for (Litteral l : this.litteraux) {
			// litteral = -X avec X = 0
			if (solution[Math.abs(l.getIndex()) - 1] == 0 && l.getIndex() < 0) {
				return 1;
			}
			// litteral = X avec X = 1
			if (solution[Math.abs(l.getIndex()) - 1] == 1 && l.getIndex() > 0) {
				return 1;
			}

		}
		// si litteral = -X avec X = 1 ou litteral = X avec X = 0
		return 0;
	}

	/**
	 * pour afficher une clause
	 * 
	 * @param
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("");

		for (int i = 0; i < this.litteraux.size(); i++) {
			s.append(this.litteraux.get(i).getIndex()).append(" ");
		}
		return s.toString();
	}
}
