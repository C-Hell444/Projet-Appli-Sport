package model.caracteristiques;

public class Vitesse extends Physique {

	
	
	public Vitesse() {
		
	}

	public Vitesse(int valeur, int avgPhysique) {
		super(valeur, avgPhysique);

	}

	@Override
	public String toString() {
		return "Vitesse [avgPhysique=" + avgPhysique + ", valeur=" + valeur + "]";
	}
	
	

}
