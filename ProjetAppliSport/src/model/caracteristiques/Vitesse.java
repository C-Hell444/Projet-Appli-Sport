package model.caracteristiques;

public class Vitesse extends Physique {

	
	
	public Vitesse() {
		
	}

	public Vitesse(int valeur, int avgMental) {
		super(valeur, avgMental);

	}

	@Override
	public String toString() {
		return "Vitesse [avgPhysique=" + avgPhysique + ", valeur=" + valeur + "]";
	}
	
	

}
