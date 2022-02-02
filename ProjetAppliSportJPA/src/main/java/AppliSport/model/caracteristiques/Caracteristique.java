package AppliSport.model.caracteristiques;

public abstract class Caracteristique {

	
	protected int valeur;

	
	public Caracteristique() {
	}
	
	public Caracteristique(int valeur) {
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		return "Caracteristique [valeur=" + valeur + "]";
	}
	
	
}
