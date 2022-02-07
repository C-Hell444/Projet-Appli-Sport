package AppliSport.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "equipeutilisateur")
public class EquipeUtilisateur {

	@EmbeddedId
	private EquipeUtilisateurKey equipeUtilisateurKey;
	@Column(name = "equipeutilisateur_date_debut")
	private LocalDate dateDebut;
	@Column(name = "equipeutilisateur_date_fin")
	private LocalDate dateFin;
	
	public EquipeUtilisateur() {
		
	}

	public EquipeUtilisateurKey getEquipeUtilisateurKey() {
		return equipeUtilisateurKey;
	}

	public void setEquipeUtilisateurKey(EquipeUtilisateurKey equipeUtilisateurKey) {
		this.equipeUtilisateurKey = equipeUtilisateurKey;
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
		return Objects.hash(equipeUtilisateurKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipeUtilisateur other = (EquipeUtilisateur) obj;
		return Objects.equals(equipeUtilisateurKey, other.equipeUtilisateurKey);
	}
	
	
	
}
