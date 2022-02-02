package AppliSport.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "utilisateur")
public class Utilisateur extends Compte {
	
	@Transient
	private String adresse;
	@Column(name = "utilisateur_tel", length = 30)
	private String numTel;
	@Transient
	private List<Sport> sportsUtilisateur = new ArrayList();
	@Transient
	private Profil profilUtilisateur;
	@Transient
	private List<Historique> historiqueUtilisateur = new ArrayList();
	

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

	

	
	
}
