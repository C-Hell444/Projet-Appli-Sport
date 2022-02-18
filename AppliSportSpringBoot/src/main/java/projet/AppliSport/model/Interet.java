package projet.AppliSport.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name = "seqInteret", sequenceName = "seq_interet", initialValue = 10, allocationSize = 1)
public class Interet {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqInteret")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "interet_utilisateur", foreignKey = @ForeignKey(name = "interet_utilisateur_fk"))
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name = "interet_sport", foreignKey = @ForeignKey(name = "interet_sport_fk"))
	private Sport sport;
	@Version
	private int version;
	
	public Interet() {
	}
	
	
	
	
//	public Long getid() {
//		return id;
//	}
//
//
//
//	public void setid(Long id_interet) {
//		id = id_interet;
//	}



	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Utilisateur getUtilisateur() {
		return utilisateur;
	}



	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	public Sport getSport() {
		return sport;
	}



	public void setSport(Sport sport) {
		this.sport = sport;
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
		Interet other = (Interet) obj;
		return Objects.equals(id, other.id);
	}


	
	
	
}
