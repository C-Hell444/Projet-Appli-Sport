package AppliSport.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seqInteret", sequenceName = "seq_interet", initialValue = 10, allocationSize = 1)
public class Interet {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqInteret")
	private Long Id_interet;
	@Column(name = "utilisateur", length = 150)
	//@OneToOne
	private String utilisateur;
	//@OneToMany(mappedBy = "Interet")
	private String sport;
	
	
	public Interet() {
	}
	
	public Interet(String utilisateur, String sport) {
		this.utilisateur = utilisateur;
		this.sport = sport;
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	public String getSport() {
		return sport;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id_interet);
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
		return Objects.equals(Id_interet, other.Id_interet);
	}


	
	
	
}
