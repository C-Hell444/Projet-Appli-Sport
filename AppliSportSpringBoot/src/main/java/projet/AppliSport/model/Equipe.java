package projet.AppliSport.model;

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
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "equipe")
@SequenceGenerator(name = "seqEquipe", sequenceName = "seq_equipe", initialValue = 100, allocationSize = 1)
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEquipe")
	@Column(name = "id_equipe")
	private Long id;

	@NotEmpty
	@Column(name = "nom_equipe")
	private String nom;

	@OneToMany(mappedBy = "id.utilisateur")
	private List<EquipeUtilisateur> equipe;

	@ManyToOne
	@JoinColumn(name = "equipe_club", foreignKey = @ForeignKey(name = "equipe_club_fk"))
	private Club club;

	public Equipe() {

	}

	public Equipe(Long id, List<EquipeUtilisateur> equipe) {
		this.id = id;
		this.equipe = equipe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<EquipeUtilisateur> getEquipe() {
		return equipe;
	}

	public void setEquipe(List<EquipeUtilisateur> equipe) {
		this.equipe = equipe;
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
		Equipe other = (Equipe) obj;
		return Objects.equals(id, other.id);
	}

}
