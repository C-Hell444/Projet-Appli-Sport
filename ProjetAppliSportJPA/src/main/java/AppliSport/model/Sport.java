package AppliSport.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	//@ManyToOne
	//@JoinColumn(name = "profil", foreignKey = @ForeignKey(name = "spt_profil_fk"))
	@Transient
	private Profil profilSport;

	
	
	public Sport() {
		
	}
	
	public Sport(String nom, Profil profilSport) {
		this.nom = nom;
		this.profilSport=profilSport;
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
