package AppliSport.model.caracteristiques;

public class Patience extends Mental {

	
	
	public Patience() {
		
	}

	public Patience(int valeur, int avgMental) {
		super(valeur, avgMental);

	}

	@Override
	public String toString() {
		return "Patience [avgMental=" + avgMental + ", valeur=" + valeur + "]";
	}
	
	

}
