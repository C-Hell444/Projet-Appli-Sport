package model.caracteristiques;

public class Endurance extends Physique {

	
	
	public Endurance() {
		
	}

	public Endurance(int valeur, int avgPhysique) {
		super(valeur, avgPhysique);

	}

	@Override
	public String toString() {
		return "Endurance [avgPhysique=" + avgPhysique + ", valeur=" + valeur + "]";
	}
	
	

}
