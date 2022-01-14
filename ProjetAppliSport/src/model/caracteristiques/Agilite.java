package model.caracteristiques;

public class Agilite extends Physique {

	
	
	public Agilite() {
		
	}

	public Agilite(int valeur, int avgPhysique) {
		super(valeur, avgPhysique);

	}

	@Override
	public String toString() {
		return "Agilite [avgPhysique=" + avgPhysique + ", valeur=" + valeur + "]";
	}
	
	

}
