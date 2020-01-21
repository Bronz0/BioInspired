package com.bronzo.bioinsp.core;

/**
 * @author M. BOUDISSA, github.com/bronz0
 *
 */
public class Litteral {
	
	// attrbuts
	private int index;
	private int valeur;
	
	// constructeurs
	public Litteral() {}
	
	public Litteral(int index) {
		this.index = index;
		this.valeur = -1;
	}
	
	public Litteral(Litteral l) {
		this.index = l.index;
		this.valeur = l.valeur;
	}

	
	// getters setters
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	
	// TODO: randomSelection(), getContraire(), removeChoisi();
	

}
