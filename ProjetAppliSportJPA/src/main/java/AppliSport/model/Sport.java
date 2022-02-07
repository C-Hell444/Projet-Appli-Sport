package AppliSport.model;

import java.util.Objects;
import java.util.Set;

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
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name = "seqSport", sequenceName = "seq_sport", initialValue = 10, allocationSize = 1)
public class Sport {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSport")
	private Long id;
	@Column(name = "nom", length = 150)
	private String nom;
	//@ManyToOne
	//@JoinColumn(name = "sport_profil", foreignKey = @ForeignKey(name = "spt_profil_fk"))
	//private Profil profilSport;
	@OneToMany(mappedBy = "sportClub")
	private Set<Club> clubs;
	@OneToMany(mappedBy = "sport")
	private Set<Interet> interets;

	
	
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

	public void setId_sport(Long id) {
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
