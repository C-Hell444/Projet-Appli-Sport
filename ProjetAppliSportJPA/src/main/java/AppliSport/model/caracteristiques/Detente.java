package AppliSport.model.caracteristiques;

public class Detente extends Physique {

	
	
	public Detente() {
		
	}

	public Detente(int valeur, int avgPhysique) {
		super(valeur, avgPhysique);

	}

	@Override
	public String toString() {
		return "Detente [avgPhysique=" + avgPhysique + ", valeur=" + valeur + "]";
	}
	
	

}
