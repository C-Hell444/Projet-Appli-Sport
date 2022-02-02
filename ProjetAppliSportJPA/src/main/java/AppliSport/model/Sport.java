package model;

public class Sport {

	private String nom;
	private Profil profilSport;

	
	
	public Sport() {
	}
	
	public Sport(String nom, Profil profilSport) {
		this.nom = nom;
		this.profilSport=profilSport;
	}

	public String getNom() {
		return nom;
	}

	public Profil getProfilSport() {
		return profilSport;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setProfilSport(Profil profilSport) {
		this.profilSport = profilSport;
	}

	@Override
	public String toString() {
		return "Sport [nom=" + nom + ", profilSport=" + profilSport + "]";
	}

	
	
}
