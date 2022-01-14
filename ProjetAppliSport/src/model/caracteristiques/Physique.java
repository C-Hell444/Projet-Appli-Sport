package model.caracteristiques;

public abstract class Physique extends Caracteristique {

	protected int avgPhysique;

	

	public Physique() {
	}

	public Physique(int valeur,int avgMental) {
		super(valeur);
		this.avgPhysique=avgMental;
		
	}

	public int getAvgMental() {
		return avgPhysique;
	}

	public void setAvgMental(int avgMental) {
		this.avgPhysique = avgMental;
	}

	@Override
	public String toString() {
		return "Physique [avgPhysique=" + avgPhysique + ", valeur=" + valeur + "]";
	}
	
	
	

	
	
}
