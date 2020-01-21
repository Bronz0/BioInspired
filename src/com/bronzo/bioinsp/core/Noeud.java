package com.bronzo.bioinsp.core;

import java.util.ArrayList;
import java.util.Objects;

public class Noeud {

	// attributs
	private ArrayList<Litteral> litteraux;
	private int profondeur;
	private Noeud pere;

	// constructeurs
	public Noeud(ArrayList<Litteral> litteraux, int profondeur, Noeud pere) {
		super();
		this.litteraux = litteraux;
		this.profondeur = profondeur;
		this.pere = pere;
	}

	public Noeud(ArrayList<Litteral> litteraux, int profondeur) {
		super();
		this.litteraux = litteraux;
		this.profondeur = profondeur;
	}

	// getters settters
	public ArrayList<Litteral> getLitteraux() {
		return litteraux;
	}

	public void setLitteraux(ArrayList<Litteral> litteraux) {
		this.litteraux = litteraux;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}

	public Noeud getPere() {
		return pere;
	}

	public void setPere(Noeud pere) {
		this.pere = pere;
	}

	
	// redefinition de la methode d'egalitee et la methode de hashage.
	@Override
	public boolean equals(Object o) {
		if (o instanceof Noeud) {
			Noeud tmp = (Noeud) o;
			ArrayList<Litteral> solution = tmp.getLitteraux();

			for (int i = 0; i < solution.size(); i++) {
				if (solution.get(i).getValeur() != this.litteraux.get(i).getValeur()) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 79 * hash + Objects.hashCode(this.litteraux);
		return hash;
	}

}
