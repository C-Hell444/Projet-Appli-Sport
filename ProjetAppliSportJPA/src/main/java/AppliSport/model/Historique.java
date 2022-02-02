package AppliSport.model;

import java.time.LocalDate;

public class Historique {

	protected Utilisateur user;
	protected Club club;
	protected Evenement evenement;
	protected Equipe equipe;
	protected LocalDate dateDebut;
	protected LocalDate dateFin;
	
	
	public Historique() {
		
	}

	public Historique(Utilisateur utilisateur, Club club, Evenement evenement, Equipe equipe, LocalDate dateDebut,
			LocalDate dateFin) {
		this.user = utilisateur;
		this.club = club;
		this.evenement = evenement;
		this.equipe = equipe;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}





	public Utilisateur getUtilisateur() {
		return user;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.user = utilisateur;
	}


	public Club getClub() {
		return club;
	}


	public Evenement getEvenement() {
		return evenement;
	}


	public Equipe getEquipe() {
		return equipe;
	}


	public LocalDate getDateDebut() {
		return dateDebut;
	}


	public LocalDate getDateFin() {
		return dateFin;
	}


	public void setClub(Club club) {
		this.club = club;
	}


	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}


	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}


	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}


	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}


	@Override
	public String toString() {
		return "Historique [user=" + user + ", club=" + club + ", evenement=" + evenement + ", equipe="
				+ equipe + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	
	

}
