package model;

public class Interet {

	private String utilisateur;
	private String sport;
	
	
	public Interet() {
	}
	
	public Interet(String utilisateur, String sport) {
		this.utilisateur = utilisateur;
		this.sport = sport;
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	public String getSport() {
		return sport;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	@Override
	public String toString() {
		return "Interet [utilisateur=" + utilisateur + ", sport=" + sport + "]";
	}
	
	
	
	
}
