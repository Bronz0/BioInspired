package com.bronzo.bioinsp.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author M. BOUDISSA, github.com/bronz0
 *
 */
public class Data {

	// attributs
	private ArrayList<Litteral> litteraux = new ArrayList<Litteral>();
	private ArrayList<Clause> clauses = new ArrayList<Clause>();
	private int nbLitteraux;
	private int nbClauses;
	private String path;

	// constructeur
	public Data(String path) throws FileNotFoundException, IOException {
		this.path = path;

		BufferedReader br = new BufferedReader(new FileReader(this.path));
		String line;
		String[] vars;
		while ((line = br.readLine()) != null) {

			if (line.matches(".*cnf.*([0-9]).*")) {
				vars = line.split(" ");

				System.out.print("vars:" + vars[2] + ",");

				this.setNbLitteraux(Integer.parseInt(vars[2]));
				System.out.println("clauses:" + Integer.parseInt(vars[4]));
				this.setNbClauses(Integer.parseInt(vars[4]));

				break;

			}
//        Pattern pattern = Pattern.compile("([0-9]+)-.*\\.cnf");
//        Matcher matcher = pattern.matcher(this.filePath);
//        if (matcher.find()) {
//            this.litterauxNumber = Integer.parseInt(matcher.group(1));
//
//        }
//
		}
		br.close();
		for (int i = 1; i <= nbLitteraux; i++) {

			litteraux.add(new Litteral(i));

//
		}

	}

	// getters setters
	public ArrayList<Litteral> getLitteraux() {
		return litteraux;
	}

	public void setLitteraux(ArrayList<Litteral> litteraux) {
		this.litteraux = litteraux;
	}

	public ArrayList<Clause> getClauses() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(this.path));
		String line;
		while ((line = br.readLine()) != null) {

			ArrayList<Litteral> litteraux_tmp = new ArrayList<Litteral>();

			if (line.length() > 0 && line.charAt(0) != 'c' && line.charAt(0) != 'p' && line.charAt(0) != '%'
					&& line.charAt(0) != '0') {

				StringTokenizer tokens = new StringTokenizer(line);
				while (tokens.hasMoreTokens()) {
					int litteral = Integer.parseInt(tokens.nextToken());
					if (litteral != 0)
						litteraux_tmp.add(new Litteral(litteral));

				}
				this.clauses.add(new Clause(litteraux_tmp));
			}
		}
		br.close();
		return this.clauses;
	}

	public void setClauses(ArrayList<Clause> clauses) {
		this.clauses = clauses;
	}

	public int getNbLitteraux() {
		return nbLitteraux;
	}

	public void setNbLitteraux(int nbLitteraux) {
		this.nbLitteraux = nbLitteraux;
	}

	public int getNbClauses() {
		return nbClauses;
	}

	public void setNbClauses(int nbClauses) {
		this.nbClauses = nbClauses;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
