package model.caracteristiques;

public class Puissance extends Physique {

	
	
	public Puissance() {
		
	}

	public Puissance(int valeur, int avgMental) {
		super(valeur, avgMental);

	}

	@Override
	public String toString() {
		return "Force [avgPhysique=" + avgPhysique + ", valeur=" + valeur + "]";
	}
	
	

}
