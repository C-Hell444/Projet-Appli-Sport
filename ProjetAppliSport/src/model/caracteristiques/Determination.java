package model.caracteristiques;

public class Determination extends Mental {

	
	
	public Determination() {
		
	}

	public Determination(int valeur, int avgMental) {
		super(valeur, avgMental);

	}

	@Override
	public String toString() {
		return "Determination [avgMental=" + avgMental + ", valeur=" + valeur + "]";
	}
	
	

}
