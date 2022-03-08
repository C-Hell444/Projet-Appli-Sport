package projet.AppliSport.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

import projet.AppliSport.views.Views;
import projet.AppliSport.views.Views.SportWithClub;

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
	
	@OneToMany(mappedBy = "sportClub")
	@JsonView(Views.SportWithClub.class)
	private Set<Club> clubs;
	@OneToMany(mappedBy = "sport")
	@JsonView(Views.SportWithInteret.class)
	private Set<Interet> interets;
	
	@OneToOne
	@JoinColumn(name = "sport_caracteristique", foreignKey = @ForeignKey(name = "sport_caracteristique_fk"))
	@JsonView(Views.SportWithCaracteristique.class)
	private Caracteristique caracteristique;

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


	




	public Caracteristique getCaracteristique() {
		return caracteristique;
	}






	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}






	public int getVersion() {
		return version;
	}






	public void setVersion(int version) {
		this.version = version;
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
