package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evenement extends Club {

	protected List<Utilisateur> participants = new ArrayList();
	protected LocalDate dateDebut;
	protected LocalDate dateFin;
	


	public Evenement() {
		super();	
	}


	public Evenement(String identifiant, String mdp, String mail, String adresse, String numTel, Sport sportClub, LocalDate dateDebut, LocalDate dateFin) {
		super(identifiant, mdp, mail, adresse, numTel, sportClub);	
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}


	public List<Utilisateur> getParticipants() {
		return participants;
	}


	public void setParticipants(List<Utilisateur> participants) {
		this.participants = participants;
	}


	@Override
	public String toString() {
		return "Evenement [participants=" + participants + ", adresse=" + adresse + ", numTel=" + numTel
				+ ", sportClub=" + sportClub + ", identifiant=" + identifiant + ", mdp=" + mdp + ", mail=" + mail + "]";
	}


	
	

	
	
}
