package projet.AppliSport.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;




@Entity
@Table(name = "caracteristique")
@SequenceGenerator(name = "seqCaracteristique", sequenceName = "seq_caracteristique", initialValue = 1, allocationSize = 1)
public class Caracteristique {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCaracteristique")
	@Column(name = "carac_id")
	private Long id;
	
	@Min(value=0)
	@Max(value=10)
	@Column(name = "carac_mentale_collectif")
	private int collectif;
	
	@Min(value=0)
	@Max(value=10)
	@Column(name = "carac_mentale_creativite")
	private int creativite;
	
	@Min(value=0)
	@Max(value=10)
	@Column(name = "carac_mentale_determination")
	private int determination;
	
	@Min(value=0)
	@Max(value=10)
	@Column(name = "carac_mentale_patience")
	private int patience;
	
	@Min(value=0)
	@Max(value=10)
	@Column(name = "carac_physique_agilite")
	private int detente;
	
	@Min(value=0)
	@Max(value=10)
	@Column(name = "carac_physique_detente")
	private int agilite;
	
	@Min(value=0)
	@Max(value=10)
	@Column(name = "carac_physique_puissance")
	private int puissance;
	
	@Min(value=0)
	@Max(value=10)
	@Column(name = "carac_physique_vitesse")
	private int vitesse;
	
	@Min(value=0)
	@Max(value=10)
	@Column(name = "carac_physique_endurance")
	private int endurance;

	
	@OneToOne(mappedBy ="caracteristique")
	private Profil profil;


	public Caracteristique() {
	}

	public Caracteristique(int collectif, int creativite, int determination, int patience, int detente, int agilite,
			int puissance, int vitesse, int endurance) {
		super();
		this.collectif = collectif;
		this.creativite = creativite;
		this.determination = determination;
		this.patience = patience;
		this.detente = detente;
		this.agilite = agilite;
		this.puissance = puissance;
		this.vitesse = vitesse;
		this.endurance = endurance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCollectif() {
		return collectif;
	}

	public int getCreativite() {
		return creativite;
	}

	public int getDetermination() {
		return determination;
	}

	public int getPatience() {
		return patience;
	}

	public int getDetente() {
		return detente;
	}

	public int getPuissance() {
		return puissance;
	}

	public int getVitesse() {
		return vitesse;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setCollectif(int collectif) {
		this.collectif = collectif;
	}

	public void setCreativite(int creativite) {
		this.creativite = creativite;
	}

	public void setDetermination(int determination) {
		this.determination = determination;
	}

	public void setPatience(int patience) {
		this.patience = patience;
	}

	public void setDetente(int detente) {
		this.detente = detente;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getAgilite() {
		return agilite;
	}

	public void setAgilite(int agilite) {
		this.agilite = agilite;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
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
		Caracteristique other = (Caracteristique) obj;
		return Objects.equals(id, other.id);
	}

}
