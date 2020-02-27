package com.bronzo.bioinsp.core;

import java.util.ArrayList;

public class Sat {
	
	// attributs
	private ArrayList<Litteral> litteraux = new ArrayList<Litteral>();
    private ArrayList<Clause> clauses = new ArrayList<Clause>();
    
    // constructeur
    public Sat(ArrayList<Litteral> litteraux, ArrayList<Clause> clauses) {
        this.litteraux = litteraux;
        this.clauses = clauses;
    }
    
    // getters setters
	public ArrayList<Litteral> getLitteraux() {
		return litteraux;
	}

	public void setLitteraux(ArrayList<Litteral> litteraux) {
		this.litteraux = litteraux;
	}

	public ArrayList<Clause> getClauses() {
		return clauses;
	}

	public void setClauses(ArrayList<Clause> clauses) {
		this.clauses = clauses;
	}
    
    // methodes
	
	/**
	 * @param solution (ensemble de litteraux)
	 * @return booleen
	 */
	public boolean test(ArrayList<Litteral> solution) {
		// verifie que la taille de la solution est egale au nombre de litteraux.
        if (solution.size() != litteraux.size()) {
            System.out.println("Erreur: la taille de la solution n'egale pas le nombre de litteraux");
            return false;
        }
        // tester la satisfesabilite des clauses par la solution donnee
        for (Clause clause : clauses) {
            if (clause.clauseSatisfaite(solution) == 0) {
                return false;
            }
        }
        return true;
    }
	
	
	/**
	 * Calculer le nombre de clause satisfaite par la solution donnee
	 * @param solution
	 * @return entier
	 */
	public int nbClauseSatisfaite(ArrayList<Litteral> solution) {
        if (solution.size() != litteraux.size()) {
            System.out.println("error in the size of the solution");
            return 0;
        }
        short i = 0;
        for (Clause clause : clauses) {
            if (clause.clauseSatisfaite(solution) == 1) {
                i++;
            }
        }

        return i;

    }
	
	public int nbClauseSatisfaite(int[] solution) {
        if (solution.length != litteraux.size()) {
            System.out.println("error in the size of the solution");
            return 0;
        }
        int i = 0;
        for (Clause clause : clauses) {
            if (clause.clauseSatisfaite(solution) == 1) {
                i++;
            }
        }

        return i;

    }

	public int frequence(Litteral literalP) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
