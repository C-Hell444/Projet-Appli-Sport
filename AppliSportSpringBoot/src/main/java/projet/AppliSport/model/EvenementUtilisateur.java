package projet.AppliSport.model;

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

import com.fasterxml.jackson.annotation.JsonView;

import projet.AppliSport.views.Views;

@Entity
@Table(name = "evenementutilisateur")
public class EvenementUtilisateur {

	@EmbeddedId
	@JsonView(Views.Common.class)
	private EvenementUtilisateurKey id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "evenementutilisateur_date_debut")
	@JsonView(Views.Common.class)
	private LocalDate dateDebut;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "evenementutilisateur_date_fin")
	@JsonView(Views.Common.class)
	private LocalDate dateFin;
	@Version
	private int version;

	public EvenementUtilisateur() {

	}

	public EvenementUtilisateur(EvenementUtilisateurKey id) {
		this.id = id;
	}

	public EvenementUtilisateurKey getId() {
		return id;
	}

	public void setId(EvenementUtilisateurKey id) {
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
		EvenementUtilisateur other = (EvenementUtilisateur) obj;
		return Objects.equals(id, other.id);
	}

}
