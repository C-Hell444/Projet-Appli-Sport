package AppliSport.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "utilisateur", uniqueConstraints = { @UniqueConstraint(columnNames = "compte_identifiant", name = "utilisateur_identifiant_uk"), @UniqueConstraint(columnNames = "compte_mail", name = "utilisateur_mail_uk") })
public class Utilisateur extends Compte {
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "client_numero", length = 50)),
			@AttributeOverride(name = "rue", column = @Column(name = "client_rue", length = 200)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "client_code_postal", length = 20)),
			@AttributeOverride(name = "ville", column = @Column(name = "client_ville", length = 100)) })
	private Adresse adresse;
	@Column(name = "utilisateur_tel", length = 30)
	private String numTel;
	@OneToMany(mappedBy = "utilisateur")
	private Set<Interet> interets;
	@OneToOne
	@JoinColumn(name = "utilisateur_profil", foreignKey = @ForeignKey(name = "utilisateur_profil_fk"))
	private Profil profilUtilisateur;
	@OneToMany(mappedBy = "id.utilisateur")
	private List<Equipe> equipes;
	@OneToMany(mappedBy = "id.utilisateur")
	private List<Evenement> evenements;
	@OneToMany(mappedBy = "id.utilisateur")
	private List<Club> clubs;
	

	public Utilisateur() {
		
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


	

	public Set<Interet> getInterets() {
		return interets;
	}




	public void setInterets(Set<Interet> interets) {
		this.interets = interets;
	}




	public List<Equipe> getEquipes() {
		return equipes;
	}




	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}




	public List<Evenement> getEvenements() {
		return evenements;
	}




	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
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