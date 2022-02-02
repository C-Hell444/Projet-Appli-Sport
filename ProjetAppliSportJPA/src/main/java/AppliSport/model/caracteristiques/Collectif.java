package AppliSport.model.caracteristiques;

public class Collectif extends Mental {

	
	
	public Collectif() {
		
	}

	public Collectif(int valeur, int avgMental) {
		super(valeur, avgMental);

	}

	@Override
	public String toString() {
		return "Collectif [avgMental=" + avgMental + ", valeur=" + valeur + "]";
	}
	
	

}
