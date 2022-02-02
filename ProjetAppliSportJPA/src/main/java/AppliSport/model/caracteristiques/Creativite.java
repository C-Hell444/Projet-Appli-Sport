package model.caracteristiques;

public class Creativite extends Mental {

	
	
	public Creativite() {
		
	}

	public Creativite(int valeur, int avgMental) {
		super(valeur, avgMental);

	}

	@Override
	public String toString() {
		return "Creativite [avgMental=" + avgMental + ", valeur=" + valeur + "]";
	}
	
	

}
