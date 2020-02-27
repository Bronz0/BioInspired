package com.bronzo.bioinsp.acs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bronzo.bioinsp.core.Data;
import com.bronzo.bioinsp.core.Sat;
import com.bronzo.bioinsp.genitique.Ga;
import com.bronzo.bioinsp.genitique.OperationsGenetique;

public class MainAcs {
	public static final int tempsMax = 30;
	public static double temps_debut = 0;

	public static void main(String[] args) {

		try {

			String sat20 = ".\\resources\\uf20-91\\uf20-01.cnf";
			String sat75 = ".\\resources\\uf75-325\\uf75-01.cnf";
//	        String sat100 = ".\\resources\\uf100-430\\uf100-01.cnf";

			Data data = new Data(sat20);

			Sat sat = new Sat(data.getLitteraux(), data.getClauses());
			System.out.println("Acs.Acs_Algorithme(sat); begin");
			Acs.Acs_Algorithme(sat);
			System.out.println("Acs.Acs_Algorithme(sat); end");

		} catch (IOException ex) {
			Logger.getLogger(Ga.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
