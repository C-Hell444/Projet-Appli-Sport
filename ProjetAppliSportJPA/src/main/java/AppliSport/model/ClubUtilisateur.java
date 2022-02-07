package AppliSport.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clubutilisateur")
public class ClubUtilisateur {

	@EmbeddedId
	private ClubUtilisateurKey clubUtilisateurKey;
	@Column(name = "clubutilisateur_date_debut")
	private LocalDate dateDebut;
	@Column(name = "clubutilisateur_date_fin")
	private LocalDate dateFin;
	
	public ClubUtilisateur() {
		
	}

	public ClubUtilisateurKey getClubUtilisateurKey() {
		return clubUtilisateurKey;
	}

	public void setClubUtilisateurKey(ClubUtilisateurKey clubUtilisateurKey) {
		this.clubUtilisateurKey = clubUtilisateurKey;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clubUtilisateurKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClubUtilisateur other = (ClubUtilisateur) obj;
		return Objects.equals(clubUtilisateurKey, other.clubUtilisateurKey);
	}
	
	
	
}
