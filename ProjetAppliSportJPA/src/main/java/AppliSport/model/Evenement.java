package AppliSport.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="evenement")
@SequenceGenerator(name = "seqEvenement", sequenceName = "seq_evenement", initialValue = 100, allocationSize = 1)
public class Evenement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEvenement")
	@Column(name="id_evenement")
	private Long id;
	
	
	@Transient
//	@Column(name="liste_participants")
//	@OneToMany(mappedBy = "?")
	private List<Utilisateur> participants = new ArrayList();
	
	@Column(name="dateDebut_evenement")
	private LocalDate dateDebut;
	
	@Column(name="dateFin_evenement")
	private LocalDate dateFin;
	


	public Evenement() {
		
	}





	public Evenement(Long id, List<Utilisateur> participants, LocalDate dateDebut, LocalDate dateFin) {
		this.id = id;
		this.participants = participants;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}


	
	


	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public List<Utilisateur> getParticipants() {
		return participants;
	}


	public void setParticipants(List<Utilisateur> participants) {
		this.participants = participants;
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
		Evenement other = (Evenement) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
	
	

	
	
}
