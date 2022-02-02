package AppliSport.model.caracteristiques;

public class Puissance extends Physique {

	
	
	public Puissance() {
		
	}

	public Puissance(int valeur, int avgPhysique) {
		super(valeur, avgPhysique);

	}

	@Override
	public String toString() {
		return "Force [avgPhysique=" + avgPhysique + ", valeur=" + valeur + "]";
	}
	
	

}
