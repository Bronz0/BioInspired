package com.bronzo.bioinsp.genitique;

import java.util.ArrayList;

/**
 * @author M. BOUDISSA, github.com/bronz0
 *
 */
public class Population {
	private ArrayList<Chromosome> chromosomes;
	
	// contructeurs
	public Population(ArrayList<Chromosome> chromosomes) {
		this.chromosomes = chromosomes;
	}

	public ArrayList<Chromosome> getChromosomes() {
		return chromosomes;
	}

	public void setChromosomes(ArrayList<Chromosome> chromosomes) {
		this.chromosomes = chromosomes;
	}
	
}
