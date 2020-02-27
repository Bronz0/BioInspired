package com.bronzo.bioinsp.acs;

import java.util.ArrayList;
import java.util.LinkedList;

import com.bronzo.bioinsp.core.Sat;



public class Acs {
	
	public static int nbIter=100;
	public static int nbIterRLocla=100;
	public static int nbAnts=10;
	public static double pheromone0 = 0.1;
	public static float alpha=(float) 0.1;
    public static float beta=(float) 2;
    public static float q0=(float) 0.9;
	public static float p=(float) 0.1;

	public static Solution bestSolution;
	
	protected static LinkedList<Solution> solution_explore = new LinkedList<>();
	private static ArrayList<Fourmi> fourmis = new ArrayList<>();
	
	public static Sat sat;
	
	
	public static void Acs_Algorithme(Sat sat) {

		 // Initialisation
	     Acs.sat = sat;
	     bestSolution = new Solution();
	     init_Ants(sat);
	     Solution.initialPheromonLits();
	    //--------
	     
	    for(int i = 0; i < nbIter; i++) {
			for (Fourmi a : fourmis) {
				// builde une solution et Maj Local
				a.buildeSolutoin();
				
				System.out.println("bestSolution ---> "+bestSolution.getNbClSat());
				if( (System.currentTimeMillis() / 1000) - MainAcs.temps_debut  > MainAcs.tempsMax ){return;}
				
			}

			Fourmi bestFourmiFiKhaterNasro = fourmis.get(0);
			for (Fourmi a : fourmis) {
				if(bestFourmiFiKhaterNasro.getProf() > a.getProf()) {
					bestFourmiFiKhaterNasro = a;
				}
				
			}
			maj_global();
	    }
		
	}
	

	private static void init_Ants(Sat sat){
		Fourmi ant;
		for(int i=0;i<nbAnts;i++){
			ant = new Fourmi(sat);
			fourmis.add(ant);
		}
	}
	
	private static void maj_global() {
		bestSolution.maj_global();
	}
	
}