package model.caracteristiques;

public class Detente extends Physique {

	
	
	public Detente() {
		
	}

	public Detente(int valeur, int avgMental) {
		super(valeur, avgMental);

	}

	@Override
	public String toString() {
		return "Detente [avgPhysique=" + avgPhysique + ", valeur=" + valeur + "]";
	}
	
	

}
