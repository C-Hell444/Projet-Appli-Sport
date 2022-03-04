package projet.AppliSport.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

import projet.AppliSport.views.Views;

@Entity
@SequenceGenerator(name = "seqSport", sequenceName = "seq_sport", initialValue = 10, allocationSize = 1)
public class Sport {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSport")
	@JsonView(Views.Common.class)
	private Long id;
	
	@NotEmpty
	@Column(name = "nom", length = 150)
	@JsonView(Views.Common.class)
	private String nom;
	//@ManyToOne
	//@JoinColumn(name = "sport_profil", foreignKey = @ForeignKey(name = "spt_profil_fk"))
	//private Profil profilSport;
	@OneToMany(mappedBy = "sportClub")
	@JsonView(Views.SportClub.class)
	private Set<Club> clubs;
	@OneToMany(mappedBy = "sport")
	@JsonView(Views.SportInteret.class)
	private Set<Interet> interets;

	@Version
	private int version;
	
	public Sport() {
		
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

	public Set<Club> getClubs() {
		return clubs;
	}

	public void setClubs(Set<Club> clubs) {
		this.clubs = clubs;
	}

	public Set<Interet> getInterets() {
		return interets;
	}






	public void setInterets(Set<Interet> interets) {
		this.interets = interets;
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
		Sport other = (Sport) obj;
		return Objects.equals(id, other.id);
	}


	
	
}
