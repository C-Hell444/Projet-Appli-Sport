package model;

import java.util.ArrayList;
import java.util.List;

public class Club extends Compte {

	protected String adresse;
	protected String numTel;
	protected Sport sportClub;
	private List<Utilisateur> listeMembresActif = new ArrayList();
	private List<Utilisateur> listeMembresInactif = new ArrayList();
	
	
	public Club() {
		super();
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

	@Override
	public String toString() {
		return "Club [adresse=" + adresse + ", numTel=" + numTel + ", sportClub=" + sportClub + ", listeMembresActif="
				+ listeMembresActif + ", listeMembresInactif=" + listeMembresInactif + ", identifiant=" + identifiant
				+ ", mdp=" + mdp + ", mail=" + mail + "]";
	}
	
	
	
}
