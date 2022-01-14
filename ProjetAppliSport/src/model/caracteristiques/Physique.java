package model.caracteristiques;

public abstract class Physique extends Caracteristique {

	protected int avgPhysique;

	

	public Physique() {
	}

	public Physique(int valeur,int avgPhysique) {
		super(valeur);
		this.avgPhysique=avgPhysique;
		
	}

	public int getAvgPhysique() {
		return avgPhysique;
	}

	public void setAvgPhysique(int avgPhysique) {
		this.avgPhysique = avgPhysique;
	}

	@Override
	public String toString() {
		return "Physique [avgPhysique=" + avgPhysique + ", valeur=" + valeur + "]";
	}
	
	
	

	
	
}
