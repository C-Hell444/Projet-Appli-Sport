package AppliSport.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "club", uniqueConstraints = { @UniqueConstraint(columnNames = "identifiant", name = "club_identifiant_uk"), @UniqueConstraint(columnNames = "mail", name = "club_mail_uk") })
public class Club extends Compte {

	@Transient
	private String adresse;
	@Column(name = "club_tel", length = 30)
	private String numTel;
	@Transient
	private Sport sportClub;
	@Transient
	private List<Utilisateur> listeMembresActif = new ArrayList<Utilisateur>();
	@Transient
	private List<Utilisateur> listeMembresInactif = new ArrayList<Utilisateur>();
	
	
	public Club() {
		
	}
	
	public Club(String identifiant, String mdp, String mail,String adresse,String numTel,Sport sportClub) {
		super(identifiant, mdp, mail);
		this.adresse=adresse;
		this.numTel=numTel;
		this.sportClub=sportClub;
		
	}

	public String getAdresse() {
		return adresse;
	}

	public String getNumTel() {
		return numTel;
	}

	public Sport getSportClub() {
		return sportClub;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public void setSportClub(Sport sportClub) {
		this.sportClub = sportClub;
	}
	

	public List<Utilisateur> getListeMembresActif() {
		return listeMembresActif;
	}

	public List<Utilisateur> getListeMembresInactif() {
		return listeMembresInactif;
	}

	public void setListeMembresActif(List<Utilisateur> listeMembresActif) {
		this.listeMembresActif = listeMembresActif;
	}

	public void setListeMembresInactif(List<Utilisateur> listeMembresInactif) {
		this.listeMembresInactif = listeMembresInactif;
	}

	
	
	
	
}
