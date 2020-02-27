package com.bronzo.bioinsp.acs;

import java.util.ArrayList;
import java.util.LinkedList;

import com.bronzo.bioinsp.core.Clause;
import com.bronzo.bioinsp.core.Litteral;
import com.bronzo.bioinsp.core.Sat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class Solution implements Comparable<Solution> {

	
	private Byte[] sol = new Byte[Acs.sat.getLitteraux().size()];
	private ArrayList<Solution> voisins = new ArrayList<>();
	private Vector<Clause> clausesNonSat = new Vector<>();

	private int NbClSat;
	private double pheromone;

	
	private static ArrayList<Pheromone> pheromoneLits = new ArrayList<>();
	public static void initialPheromonLits(){
		for(int i=0;i<Acs.sat.getLitteraux().size();i++)
			pheromoneLits.add(new Pheromone());
	}
	
	public Solution() {
		Random rnd = new Random();
		boolean rand;
		for(int i=0;i<Acs.sat.getLitteraux().size();i++){
			rand = rnd.nextBoolean();
			if(rand){sol[i] = 1;}else{sol[i] = 0;}
		}
		evaluate();
	}

	Solution(Solution s,int flip) {
		this.sol = s.sol.clone();
		sol[flip] = (byte) ( (s.sol[flip]+1) % 2 );
		evaluate();
	}

	
	public void generSol(){
		for(int i=0;i<Acs.sat.getLitteraux().size();i++)
			sol[i] = pheromoneLits.get(i).getValLit(i+1);
		evaluate();	
	}
	

	public void maj_global(){
		for(int i=0;i<sol.length;i++)
			pheromoneLits.get(i).maj(sol[i]);	
	}
	
	public boolean isExplored() {
		return Acs.solution_explore.contains(this);
	}


	public ArrayList<Solution> getVoisins() {
		return voisins;
	}

	public void setVoisins(ArrayList<Solution> voisins) {
		this.voisins = voisins;
	}

	public double getPheromone() {
		return pheromone;
	}

	public void setPheromone(double pheromone) {
		this.pheromone = pheromone;
	}
	
	public int getNbClSat() {
		return NbClSat;
	}

	
	public boolean sat(){return NbClSat==Acs.sat.getClauses().size();}
	
    private void evaluate(){        
        NbClSat=0;
        int lit;
        ArrayList<Integer> clausevisted = new ArrayList<>();
        for (int i = 1; i <= sol.length ; i++) {     
        	lit= i; if(sol[i-1]==0) lit = -i ;
            for (int j = 0; j < Acs.sat.getClauses().size() ; j++) {
                if ( !clausevisted.contains(j) && Acs.sat.getClauses().get(j).getLitteraux().contains(new Litteral(lit))){
                	NbClSat++;
                    clausevisted.add(j);
                }
            }
        }
    }

    	
	public Solution getVoisin(){
		return null;
	}

	public Vector<Clause> getClauseNonSat() {

		if (clausesNonSat.size() > 0)
			return clausesNonSat;

		int lit;
		ArrayList<Integer> clausesat = new ArrayList<>();

		for (int i = 1; i <= sol.length; i++) {
			lit = i;
			if (sol[i - 1] == 0)
				lit = -i;
			for (int j = 0; j < Acs.sat.getClauses().size(); j++) {
				if (!clausesat.contains(j) && Acs.sat.getClauses().get(j).getLitteraux().contains(new Litteral(lit))) {
					clausesat.add(j);
				}
			}
		}

		for (int j = 0; j < Acs.sat.getClauses().size(); j++)
			if (!clausesat.contains(j))
				clausesNonSat.add(Acs.sat.getClauses().get(j));

		return clausesNonSat;
	}

	
	@Override
	public boolean equals(Object obj) {
		Solution other = (Solution) obj;
		return this.toString().equals(other.toString());
	}
	
	
	@Override
	public String toString() {
		return Arrays.toString(sol);
	}

	@Override
	public int compareTo(Solution s){
		return NbClSat - s.NbClSat;
	}

}
