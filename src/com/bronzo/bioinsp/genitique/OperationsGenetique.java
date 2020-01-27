package com.bronzo.bioinsp.genitique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import com.bronzo.bioinsp.core.Sat;

/**
 * @author M. BOUDISSA, github.com/bronz0
 *
 */
public class OperationsGenetique {
	// attributs
	private Population population;
	private float probaCroisement;
	private float probaMutation;
	private int nbClause;
	private int generation;

	// constructeurs
	public OperationsGenetique(int taillePopulation, int tailleSolution, float probaCroisement, float probaMutation,
			int nbClause) {

		ArrayList<Chromosome> p = new ArrayList<>();
		for (int i = 0; i < taillePopulation; i++) {
			p.add(new Chromosome(tailleSolution));
		}

		this.population = new Population(p);
		this.probaCroisement = probaCroisement;
		this.probaMutation = probaMutation;
		this.nbClause = nbClause;
		this.generation = 0;
	}

	// getters setters
	public Population getPopulation() {
		return population;
	}

	public void setPopulation(Population population) {
		this.population = population;
	}

	public float getProbaCroisement() {
		return probaCroisement;
	}

	public void setProbaCroisement(float probaCroisement) {
		this.probaCroisement = probaCroisement;
	}

	public float getProbaMutation() {
		return probaMutation;
	}

	public void setProbaMutation(float probaMutation) {
		this.probaMutation = probaMutation;
	}

	public int getNbClause() {
		return nbClause;
	}

	public void setNbClause(int nbClause) {
		this.nbClause = nbClause;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	// operations genetique

	public void evaluation(Sat sat) {
		for (Chromosome chromo : population.getChromosomes()) {
			chromo.calculerFitness(sat);
		}
	}

	public void selection() {
		this.population.getChromosomes().sort((o1, o2) -> {

			return o2.getFitness() - o1.getFitness();
		});
	}

	public Chromosome croisement(Chromosome pere1, Chromosome pere2) {
		int pivot = ThreadLocalRandom.current().nextInt(3, pere1.getGenes().length - 3);
		int[] child = new int[pere1.getGenes().length];

		for (int i = 0; i < pere1.getGenes().length; i++) {
			if (i < pivot) {
				child[i] = pere1.getGenes()[i];
			} else {
				child[i] = pere1.getGenes()[i];
			}

		}
		Chromosome chromoFils = new Chromosome(child);
		// childDna.toString();
		return chromoFils;
	}

	public void reproduction() { // insertion
		int subpopSize = (int) (probaCroisement * this.population.getChromosomes().size());

		int lastIndex = this.population.getChromosomes().size() - 1;

		for (int i = 0; i < subpopSize; i++) {
			int categorie = ThreadLocalRandom.current().nextInt(0, 3);
			int firstParent = 0;
			int secondParent = 0;
			if (categorie > 0) {
				firstParent = ThreadLocalRandom.current().nextInt(0, subpopSize);
				secondParent = ThreadLocalRandom.current().nextInt(0, subpopSize);
			} else if (categorie == 0) {

				firstParent = ThreadLocalRandom.current().nextInt(subpopSize, population.getChromosomes().size());
				secondParent = ThreadLocalRandom.current().nextInt(subpopSize, population.getChromosomes().size());
			}

			Chromosome child = croisement(this.population.getChromosomes().get(firstParent),
					this.population.getChromosomes().get(secondParent));
			this.population.getChromosomes().remove(lastIndex);
			this.population.getChromosomes().add(lastIndex, child);
			lastIndex--;
		}
		this.generation++;
	}

	public void mutation() {
        int tailleNvPop = (int) (this.probaMutation * this.population.getChromosomes().size());
        int chromos[] = new int[this.population.getChromosomes().size()];
        Arrays.fill(chromos, 0);

        for (int i = 0; i < tailleNvPop; i++) {

            int pivot = ThreadLocalRandom.current().nextInt(0, this.population.getChromosomes().size());
            while (chromos[pivot] == 1) {
                pivot = ThreadLocalRandom.current().nextInt(0, this.population.getChromosomes().size());

            }
            chromos[pivot] = 1;
            this.population.getChromosomes().get(pivot).mutate();

        }

    }
	
	public Chromosome meilleurIndividu() {
        return this.population.getChromosomes().get(0);
    }

    public boolean isFinished() {
        return this.meilleurIndividu().getFitness() == this.nbClause;

    }

}
