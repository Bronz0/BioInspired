package com.bronzo.bioinsp.genitique;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bronzo.bioinsp.core.Data;
import com.bronzo.bioinsp.core.Sat;

public class Ga {

	public static void main(String[] args) {
		try {

			long startTime, endTime, time;
			int maxIter = 10000;
			String sat20 = ".\\resources\\uf20-91\\uf20-01.cnf";
//            String sat75 = ".\\resources\\uf75-325\\uf75-02.cnf";
//            String sat100 = ".\\resources\\uf100-430\\uf100-01.cnf";

			Data data = new Data(sat20);

			Sat sat = new Sat(data.getLitteraux(), data.getClauses());

			int i = 0;
			startTime = System.currentTimeMillis();
			
			// Initialize the entire population
			OperationsGenetique op = new OperationsGenetique(100, data.getNbLitteraux(), (float) 0.45, (float) 0.45,
					data.getNbClauses());

			do { // repeat

				op.selection(); // promising individuals from current population

				op.reproduction(); // Reproduce selected individuals (crossover)

				op.mutation(); // Mutate reproduced individuals

				op.evaluation(sat); // Evaluate created individuals

			} while (!op.isFinished() && i++ < maxIter); // stopping criteria
			
			
			endTime = System.currentTimeMillis();
			time = (endTime - startTime);

			// if we did find the bestSolution <=> find a solution that satisfait all the
			// clauses
			if (op.isFinished()) {
				System.out.println(op.meilleurIndividu().toString());
				System.out.println("iterations:" + i);
				System.out.println("time:" + time + "ms");

			} else {
				System.out.println("no solution funded");

			}

		} catch (IOException ex) {
			Logger.getLogger(Ga.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
