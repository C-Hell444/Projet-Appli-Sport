package model.caracteristiques;

public class Endurance extends Physique {

	
	
	public Endurance() {
		
	}

	public Endurance(int valeur, int avgMental) {
		super(valeur, avgMental);

	}

	@Override
	public String toString() {
		return "Endurance [avgPhysique=" + avgPhysique + ", valeur=" + valeur + "]";
	}
	
	

}
