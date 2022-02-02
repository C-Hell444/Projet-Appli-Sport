package AppliSport.model;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur extends Compte {
	
	
	protected String adresse;
	protected String numTel;
	protected List<Sport> sportsUtilisateur = new ArrayList();
	protected Profil profilUtilisateur;
	protected List<Historique> historiqueUtilisateur = new ArrayList();
	

	public Utilisateur() {
		super();
	}

	public Utilisateur(String identifiant, String mdp, String mail,String adresse, String numTel,Profil profilUtilisateur) {
		super(identifiant, mdp, mail);
		this.adresse=adresse;
		this.numTel=numTel;
		this.profilUtilisateur=profilUtilisateur;
	}

	public String getAdresse() {
		return adresse;
	}

	
	public String getNumTel() {
		return numTel;
	}

	public List<Sport> getSportsUtilisateur() {
		return sportsUtilisateur;
	}

	public Profil getProfilUtilisateur() {
		return profilUtilisateur;
	}

	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public void setSportsUtilisateur(List<Sport> sportsUtilisateur) {
		this.sportsUtilisateur = sportsUtilisateur;
	}
	
	public void setProfilUtilisateur(Profil profilUtilisateur) {
		this.profilUtilisateur = profilUtilisateur;
	}

	@Override
	public String toString() {
		return "Utilisateur [adresse=" + adresse + ", numTel=" + numTel + ", sportsUtilisateur=" + sportsUtilisateur
				+ ", profilUtilisateur=" + profilUtilisateur + ", identifiant=" + identifiant + ", mdp=" + mdp
				+ ", mail=" + mail + "]";
	}

	
	
}
