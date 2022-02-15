package AppliSport.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clubutilisateur")
public class ClubUtilisateur {

	@EmbeddedId
	private ClubUtilisateurKey id;
	@PastOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "clubutilisateur_date_debut")
	private LocalDate dateDebut;
	@FutureOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "clubutilisateur_date_fin")
	private LocalDate dateFin;
	@Version
	private int version;
	
	public ClubUtilisateur() {
		
	}

	public ClubUtilisateurKey getClubUtilisateurKey() {
		return id;
	}

	public void setClubUtilisateurKey(ClubUtilisateurKey id) {
		this.id = id;
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
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
	
	
	
}
