package com.bronzo.bioinsp.acs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.bronzo.bioinsp.core.Data;
import com.bronzo.bioinsp.core.Litteral;
import com.bronzo.bioinsp.core.Noeud;
import com.bronzo.bioinsp.core.Sat;
import com.bronzo.bioinsp.heuristique.A_;
import com.bronzo.bioinsp.heuristique.Heuristique;
import com.bronzo.bioinsp.heuristique.HeuristiqueNbClauseSatisfaites;

public class Fourmi {

	Sat sat;
	int prof;
	Noeud racine;
	Heuristique heuristique = new HeuristiqueNbClauseSatisfaites(sat);
	private Solution solution_actuel;
	private ArrayList<Solution> visitedSolution = new ArrayList<>();
	private List<String> tabuList = new ArrayList<>();	
	ArrayList<Litteral> solution;
	
	public void setSolution(ArrayList<Litteral> solution) {
		this.solution =  solution;
	}
	
	public ArrayList<Litteral> getSolution(){
		return this.solution;
	}
	
	public void setProf(int p) {
		this.prof = p;
	}
	public int getProf() {
		return this.getProf();
	}
	public Fourmi(Sat sat) {
		solution_actuel = new Solution();
		this.sat = sat;
		racine = new Noeud(sat.getLitteraux(), (short) 0);
	}

	
	public void buildeSolutoin(){
		new A_(racine, sat, heuristique, this);
		if(solution_actuel.getNbClSat() < ( 0.98 * Acs.sat.getClauses().size()  ) )
		solution_actuel.generSol();
		search();
	}
	
	public Solution getSolution_actuel() {
		return solution_actuel;
	}

	
	public void maj_local() {
		double pheromone = solution_actuel.getPheromone();
		pheromone = ((1 - Acs.p) * pheromone) + (Acs.p * Acs.pheromone0);
		solution_actuel.setPheromone(pheromone);
	}

	public ArrayList<Solution> getVisitedSolution() {
		return visitedSolution;
	}

	public void selection_solution() {
		Random rand = new Random();
		float q = rand.nextFloat();
		if (q <= Acs.q0) {
			select_par_Intensification();
		} else {
			select_par_diversification();
		}
	}

	private boolean select_par_Intensification() {
		Solution temp = null;
		double prob = 0;
		for (Solution s : solution_actuel.getVoisins()) {
			double deltPher = solution_actuel.getPheromone() - s.getPheromone();
			double nij = 1 / (solution_actuel.getNbClSat() - s.getNbClSat());
			double probTemp = Math.pow(nij, Acs.beta) * deltPher;
			if (probTemp >= prob && !(s.isExplored())) {
				prob = probTemp;
				temp = s;
			}
		}
		if (temp == null) {
			solution_actuel = solution_actuel.getVoisin();

		} else {
			this.solution_actuel = temp;
		}

		Acs.solution_explore.add(this.solution_actuel);
		return true;
	}

	
	private void select_par_diversification(){
		double pherVisib = 0;
		for (Solution s : visitedSolution) {
			double deltPher = solution_actuel.getPheromone() - s.getPheromone();
			double nij = 1 / (solution_actuel.getNbClSat() - s.getNbClSat());
			pherVisib += Math.pow(nij, Acs.beta) * Math.pow(deltPher, Acs.alpha);
		}
		Solution temp = null;
		double prob = 0;
		for (Solution s : Acs.solution_explore) {
			double deltPher = solution_actuel.getPheromone() - s.getPheromone();
			double nij = 1 / (solution_actuel.getNbClSat() - s.getNbClSat());
			double probTemp = (Math.pow(nij, Acs.beta) * Math.pow(deltPher, Acs.alpha)) / pherVisib;
			if (probTemp >= prob && !(s.isExplored())) {
				temp = s;
				prob = probTemp;
			}
		}

		if (temp != null) {
			this.solution_actuel = temp;
			Acs.solution_explore.add(this.solution_actuel);
		}

	}

	
    public void search(){
    	
    	//if(assignedSolution.getFitness() > (CNF.NbClauseTotal * 0.98)-1 ){  serarchLocalPresise(); return; }
    		
        tabuList.add(solution_actuel.toString());
        
        Solution neighborsSol;
        int cpt = 1 ;
        while(cpt<Acs.nbIterRLocla){       		
   
        	neighborsSol = new Solution(solution_actuel,ThreadLocalRandom.current().nextInt(0,Acs.sat.getLitteraux().size()));
        	if(tabuList.contains(neighborsSol.toString())) continue;
        	
        	if(neighborsSol.getNbClSat()>solution_actuel.getNbClSat()){
        		solution_actuel = neighborsSol;
        		solution_actuel.maj_global();
        	}
        	
        	if(solution_actuel.sat()) { Acs.bestSolution = solution_actuel; break;}
        	cpt++;
        }
        
        if(solution_actuel.getNbClSat() > Acs.bestSolution.getNbClSat()){
        	Acs.bestSolution = solution_actuel;
        	Acs.bestSolution.maj_global();
        }
        
    }


}
