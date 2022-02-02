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
	private Long Id_sport;
	@Column(name = "nom", length = 150)
	private String nom;
	@ManyToOne
	@JoinColumn(name = "sport_profil", foreignKey = @ForeignKey(name = "spt_profil_fk"))
	private Profil profilSport;
	@OneToMany(mappedBy = "sportClub")
	private Set<Club> clubs;
	@OneToMany(mappedBy = "sport")
	private Set<Interet> interets;

	
	
	public Sport() {
		
	}
	
	




	public String getNom() {
		return nom;
	}

	public Profil getProfilSport() {
		return profilSport;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setProfilSport(Profil profilSport) {
		this.profilSport = profilSport;
	}

	
	
	
	public Long getId_sport() {
		return Id_sport;
	}

	public void setId_sport(Long id_sport) {
		Id_sport = id_sport;
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
		return Objects.hash(Id_sport);
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
		return Objects.equals(Id_sport, other.Id_sport);
	}


	
	
}
