package com.bronzo.bioinsp.genitique;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bronzo.bioinsp.core.Data;
import com.bronzo.bioinsp.core.Sat;
import com.bronzo.bioinsp.ui.Partie2;

public class Ga {

	public Ga(Partie2 p2) {
		try {

			long startTime, endTime, time;
			int maxIter = 50000;
			int max = 0;
			float pc = (float) 0.6;
			float pm = (float) 0.6;
			int taillePopulation = 28;

//			String sat20 = ".\\resources\\uf20-91\\uf20-01.cnf";
			String sat75 = ".\\resources\\uf75-325\\uf75-01.cnf";
//            String sat100 = ".\\resources\\uf100-430\\uf100-01.cnf";
			
			
//			Random rand = new Random();
//			int r = rand.nextInt(100)+1;
//			System.out.println("r = "+r);
//			String unsat75 = ".\\resources\\UUF75.325.100\\uuf75-0"+r+".cnf";
//			String sat75 = ".\\resources\\uf75-325\\uf75-0"+r+".cnf";
			Data data = new Data(sat75);

			Sat sat = new Sat(data.getLitteraux(), data.getClauses());

			int i = 0;
			startTime = System.currentTimeMillis();

			// Initialize the entire population
			OperationsGenetique op = new OperationsGenetique(taillePopulation, data.getNbLitteraux(), pc, pm, data.getNbClauses());

			do { // repeat

				op.selection(); // promising individuals from current population

				op.reproduction(); // Reproduce selected individuals (crossover)

				op.mutation(); // Mutate reproduced individuals

				op.evaluation(sat); // Evaluate created individuals
				if (op.meilleurIndividu().getFitness() > max) {
					max = op.meilleurIndividu().getFitness();
					p2.maxSat1.setText("" + max);
				}
				p2.genActuelle1.setText("" + i);
			} while (!op.isFinished() && i++ < maxIter); // stopping criteria

			endTime = System.currentTimeMillis();
			time = (endTime - startTime);

			// if we did find the bestSolution <=> find a solution that satisfait all the
			// clauses
			if (op.isFinished()) {
				System.out.println(op.meilleurIndividu().toString());

				System.out.println("iterations:" + i);
				System.out.println("time:" + time + "ms");

				String s = op.meilleurIndividu().toString();
				String[] arraySolution = s.split(",");
				for (int j = 1; j < arraySolution.length; j++) {
					p2.table.getModel().setValueAt("X" + j, j - 1, 0);
					p2.table.getModel().setValueAt(arraySolution[j], j - 1, 1);
				}
				// make them visible
				p2.solution.setVisible(true);
				p2.scrol.setVisible(true);

				p2.timerThread1.stop();
				p2.timer1.setText("Fini");
				p2.maxSat1.setText("" + op.getNbClause());
				p2.genActuelle1.setText("" + i);
				p2.ComplexiteT1.setText(time + "ms");

			} else {
				System.out.println("no solution funded");
				p2.timerThread1.stop();
				p2.timer1.setText("no solution funded");
				p2.ComplexiteT1.setText(time + "ms");
				/*
				 * p2.maxSat1.setText(""+op.getNbClause()); p2.genActuelle1.setText(""+i);
				 */

			}

		} catch (IOException ex) {
			Logger.getLogger(Ga.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
