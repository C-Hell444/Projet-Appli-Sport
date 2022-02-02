package model.caracteristiques;

public abstract class Mental extends Caracteristique {

	protected int avgMental;

	

	public Mental() {
	}

	public Mental(int valeur,int avgMental) {
		super(valeur);
		this.avgMental=avgMental;
		
	}

	public int getAvgMental() {
		return avgMental;
	}

	public void setAvgMental(int avgMental) {
		this.avgMental = avgMental;
	}

	@Override
	public String toString() {
		return "Mental [avgMental=" + avgMental + ", valeur=" + valeur + "]";
	}
	
	
	

	
	
}
