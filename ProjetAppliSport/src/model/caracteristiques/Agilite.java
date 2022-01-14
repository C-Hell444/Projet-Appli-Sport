package model.caracteristiques;

public class Agilite extends Physique {

	
	
	public Agilite() {
		
	}

	public Agilite(int valeur, int avgMental) {
		super(valeur, avgMental);

	}

	@Override
	public String toString() {
		return "Agilite [avgPhysique=" + avgPhysique + ", valeur=" + valeur + "]";
	}
	
	

}
