package com.bronzo.bioinsp.genitique;

import java.util.concurrent.ThreadLocalRandom;

import com.bronzo.bioinsp.core.Sat;

/**
 * @author M. BOUDISSA, github.com/bronz0
 *
 */
public class Chromosome {
	// attributs
	private int[] genes;
	private int fitness;

	// constructeurs
	public Chromosome(int[] genes) {
		this.setGenes(genes);
	}

	public Chromosome(int taille) { // initialiser un chromosome avec des genes aleatoires
		genes = new int[taille];
		for (int i = 0; i < taille; i++) {
			genes[i] = ThreadLocalRandom.current().nextInt(0, 2);
		}
	}

	// getters setters
	public int[] getGenes() {
		return genes;
	}

	public void setGenes(int[] gene) {
		this.genes = gene;
	}

	public int getFitness() {
		return fitness;
	}
	
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	
	// methodes
	public void calculerFitness(Sat sat){    
        this.setFitness(sat.nbClauseSatisfaite(this.genes));       
    }
	
	public void mutate() {
        int pivot = ThreadLocalRandom.current().nextInt(0, this.genes.length);
        this.genes[pivot] = this.genes[pivot] == 0 ? 1 : 0;
    }

	@Override
    public String toString(){
        String output="";
        for (int i = 0; i < this.genes.length; i++) {
            output+=","+this.genes[i];
           
            
        }
        return output;
    }
}
