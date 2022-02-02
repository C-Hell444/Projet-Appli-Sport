package AppliSport.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import AppliSport.model.caracteristiques.Caracteristique;


@Entity
@Table(name="profil")
@SequenceGenerator(name="seqProfil", sequenceName = "seq_profil",initialValue = 1, allocationSize = 1)
public class Profil {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE,generator = "seqProfil")
	@Column(name="profil_id")
	private Long id;
	@Column(name="profil_poids")
	private double poids;
	@Column(name="profil_taille")
	private double taille;
	@Column(name="profil_naissance")
	private LocalDate dateNaissance;
	@Column(name="profil_sexe")
	@Enumerated (EnumType.STRING)
	private Sexe sexe;
	@Transient
	private List<Caracteristique> listeCaracteristiques = new ArrayList();
	
	
	
	public Profil() {
	}
	
	public Profil(double poids, double taille, LocalDate dateNaissance, Sexe sexe,
			List<Caracteristique> listeCaracteristiques) {
		this.poids = poids;
		this.taille = taille;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.listeCaracteristiques = listeCaracteristiques;
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

	public List<Caracteristique> getListeCaracteristiques() {
		return listeCaracteristiques;
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

	public void setListeCaracteristiques(List<Caracteristique> listeCaracteristiques) {
		this.listeCaracteristiques = listeCaracteristiques;
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
