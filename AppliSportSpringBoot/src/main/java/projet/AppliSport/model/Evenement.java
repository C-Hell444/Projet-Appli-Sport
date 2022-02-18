package projet.AppliSport.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="evenement")
@SequenceGenerator(name = "seqEvenement", sequenceName = "seq_evenement", initialValue = 100, allocationSize = 1)
public class Evenement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEvenement")
	@Column(name="id_evenement")
	private Long id;
	
	@NotEmpty
	@Column(name="nom_evenement")
	private String nom;
	
	@OneToMany(mappedBy = "id.utilisateur")
	private List<EvenementUtilisateur> participants;
	
	@PastOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="dateDebut_evenement")
	private LocalDate dateDebut;
	
	@FutureOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="dateFin_evenement")
	private LocalDate dateFin;
	
	@ManyToOne
	@JoinColumn(name = "evenement_club", foreignKey = @ForeignKey(name = "evenement_club_fk"))
	private Club club;
	
	@Version
	private int version;


	public Evenement() {
		
	}





	public Evenement(Long id, List<EvenementUtilisateur> participants, LocalDate dateDebut, LocalDate dateFin) {
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





	public List<EvenementUtilisateur> getParticipants() {
		return participants;
	}


	public void setParticipants(List<EvenementUtilisateur> participants) {
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


	



	public Club getClub() {
		return club;
	}





	public void setClub(Club club) {
		this.club = club;
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
