package projet.AppliSport.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="profil")
@SequenceGenerator(name="seqProfil", sequenceName = "seq_profil",initialValue = 100, allocationSize = 1)
public class Profil {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "seqProfil")
	@Column(name="profil_id")
	private Long id;
	
	@DecimalMin(value = "0")
	@Column(name="profil_poids")
	private double poids;
	
	@DecimalMin(value = "0.5")
	@DecimalMax(value = "3.0")
	@Column(name="profil_taille")
	private double taille;
	
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="profil_naissance")
	private LocalDate dateNaissance;
	
	@NotEmpty
	@Column(name="profil_sexe")
	@Enumerated (EnumType.STRING)
	private Sexe sexe;
	
	@OneToOne
	@JoinColumn(name = "profil_caracteristique", foreignKey = @ForeignKey(name = "profil_caracteristique_fk"))
	private Caracteristique caracteristique;
	//@OneToMany(mappedBy = "profilSport")
	//private Set<Sport> sports;
	@OneToOne(mappedBy = "profilUtilisateur")
	private Utilisateur utilisateur;
	
	@Version
	private int version;
	
	public Profil() {
		
	}
	
	

	
	
	public Profil(Long id, double poids, double taille, LocalDate dateNaissance, Sexe sexe,
			Caracteristique caracteristique) {
		this.id = id;
		this.poids = poids;
		this.taille = taille;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.caracteristique = caracteristique;

	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPoids() {
		return poids;
	}

	public double getTaille() {
		return taille;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public Sexe getSexe() {
		return sexe;
	}

	

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	



	public Caracteristique getCaracteristique() {
		return caracteristique;
	}





	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
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
		Profil other = (Profil) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
