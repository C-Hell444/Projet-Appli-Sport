package AppliSport.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "evenementutilisateur")
public class EvenementUtilisateur {

	@EmbeddedId
	private EvenementUtilisateurKey id;
	@Column(name = "evenementutilisateur_date_debut")
	private LocalDate dateDebut;
	@Column(name = "evenementutilisateur_date_fin")
	private LocalDate dateFin;
	
	public EvenementUtilisateur() {
		
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
