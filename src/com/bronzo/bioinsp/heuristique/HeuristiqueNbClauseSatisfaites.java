package com.bronzo.bioinsp.heuristique;

import java.util.ArrayList;
import java.util.Comparator;

import com.bronzo.bioinsp.core.Litteral;
import com.bronzo.bioinsp.core.Noeud;
import com.bronzo.bioinsp.core.Sat;

/**
 * @author M. BOUDISSA, github.com/bronz0
 *
 */
public class HeuristiqueNbClauseSatisfaites extends Heuristique {
	
	private Sat sat;

    public HeuristiqueNbClauseSatisfaites(Sat sat) {
        this.sat = sat;
    }

	@Override
	public int compare(Noeud o1, Noeud o2) {
		ArrayList<Litteral> solution1 = o1.getLitteraux();
        ArrayList<Litteral> solution2 = o2.getLitteraux();
        int satisfaitClauseNumberS1 = sat.nbClauseSatisfaite(solution1);
        int satisfaitClauseNumberS2 = sat.nbClauseSatisfaite(solution2);
        return satisfaitClauseNumberS2 - satisfaitClauseNumberS1;
	}

}
