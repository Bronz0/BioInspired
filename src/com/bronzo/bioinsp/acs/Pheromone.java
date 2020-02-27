package com.bronzo.bioinsp.acs;

import java.util.Random;

import com.bronzo.bioinsp.core.Litteral;

public class Pheromone {
private float pheromonTrue = (float) 0.1 , pheromonFalse = (float) 0.1 ;
	
	public Pheromone(){ }

	public float getPheromonTrue() {
		return pheromonTrue;
	}

	public void setPheromonTrue(float pheromonTrue) {
		this.pheromonTrue = pheromonTrue;
	}

	public float getPheromonFalse() {
		return pheromonFalse;
	}

	public void setPheromonFalse(float pheromonFalse) {
		this.pheromonFalse = pheromonFalse;
	}
	
	
	public Byte getValLit(int lit){
		
		if (pheromonFalse != pheromonTrue) {
			Litteral literalP = Acs.sat.getLitteraux().get(Acs.sat.getLitteraux().indexOf(new Litteral(lit)));
			Litteral literalN = Acs.sat.getLitteraux().get(Acs.sat.getLitteraux().indexOf(new Litteral(-lit)));

			int niP = Acs.sat.frequence(literalP) / Acs.sat.getClauses().size() ; // frequence de niP / nombre total de clause
			int niN = Acs.sat.frequence(literalN) / Acs.sat.getClauses().size();
			
			float niP_Beta = (float) Math.pow(niP,Acs.beta);
			float niN_Beta = (float) Math.pow(niN,Acs.beta);
			
			if( ( Math.pow(pheromonTrue,Acs.alpha) * niP_Beta ) > ( Math.pow(pheromonFalse,Acs.alpha) * niN_Beta ) ){
				maj_Local(true);
				return 1;
			}else{
				maj_Local(false);
				return 0;			
			}
		} else {
			Random rnd = new Random();
			boolean random = rnd.nextBoolean();
			if(random) {maj_Local(true); return 1 ; } else { maj_Local(false); return 0; }
		}

		
	}
	
	
	public void maj_Local(boolean pherTrue){
		if(pherTrue)
			pheromonTrue = (float) (((1 - Acs.p) * pheromonTrue ) + (Acs.p * Acs.pheromone0));
		else
			pheromonFalse = (float) (((1 - Acs.p) * pheromonFalse) + (Acs.p * Acs.pheromone0));
	}
	
	
	public void maj(Byte val){
		float delta = 0;
		if(val == 1){
			delta = ( (1 - Acs.p) * pheromonTrue ) - pheromonTrue ;
			pheromonTrue = ((1 - Acs.p) * pheromonTrue ) + (Acs.p*delta);
		}else{
			delta = ( (1 - Acs.p) * pheromonFalse ) - pheromonFalse ;
			pheromonFalse = ((1 - Acs.p) * pheromonFalse ) + (Acs.p*delta);			
		}
		
	}
	
	
}
