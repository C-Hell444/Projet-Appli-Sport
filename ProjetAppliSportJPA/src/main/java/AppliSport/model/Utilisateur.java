package AppliSport.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "utilisateur")
public class Utilisateur extends Compte {
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "client_numero", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "client_rue", length = 200)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "client_code_postal", length = 20)),
			@AttributeOverride(name = "ville", column = @Column(name = "client_ville", length = 100)) })
	private Adresse adresse;
	@Column(name = "utilisateur_tel", length = 30)
	private String numTel;
	@Transient
	private List<Sport> sportsUtilisateur = new ArrayList();
	@Transient
	private Profil profilUtilisateur;
	@Transient
	private List<Historique> historiqueUtilisateur = new ArrayList();
	

	public Utilisateur() {
		
	}


	public Utilisateur(String identifiant, String mdp, String mail, Adresse adresse, String numTel,
			List<Sport> sportsUtilisateur, Profil profilUtilisateur, List<Historique> historiqueUtilisateur) {
		super(identifiant, mdp, mail);
		this.adresse = adresse;
		this.numTel = numTel;
		this.sportsUtilisateur = sportsUtilisateur;
		this.profilUtilisateur = profilUtilisateur;
		this.historiqueUtilisateur = historiqueUtilisateur;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public String getNumTel() {
		return numTel;
	}


	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}


	public List<Sport> getSportsUtilisateur() {
		return sportsUtilisateur;
	}


	public void setSportsUtilisateur(List<Sport> sportsUtilisateur) {
		this.sportsUtilisateur = sportsUtilisateur;
	}


	public Profil getProfilUtilisateur() {
		return profilUtilisateur;
	}


	public void setProfilUtilisateur(Profil profilUtilisateur) {
		this.profilUtilisateur = profilUtilisateur;
	}


	public List<Historique> getHistoriqueUtilisateur() {
		return historiqueUtilisateur;
	}


	public void setHistoriqueUtilisateur(List<Historique> historiqueUtilisateur) {
		this.historiqueUtilisateur = historiqueUtilisateur;
	}
	
	
	

}