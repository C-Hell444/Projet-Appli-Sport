package AppliSport.model.caracteristiques;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("physique")
public class Physique extends Caracteristique {

	@Column(name = "carac_physique_avg")
	private int avgPhysique;
	@Column(name = "carac_physique_detente")
	private int detente;
	@Column(name = "carac_physique_puissance")
	private int puissance;
	@Column(name = "carac_physique_vitesse")
	private int vitesse;
	@Column(name = "carac_physique_endurance")
	private int endurance;

	public Physique() {
	}

	public Physique(int avgPhysique, int detente, int puissance, int vitesse, int endurance) {
		super();
		this.avgPhysique = avgPhysique;
		this.detente = detente;
		this.puissance = puissance;
		this.vitesse = vitesse;
		this.endurance = endurance;
	}

	public int getAvgPhysique() {
		return avgPhysique;
	}

	public void setAvgPhysique(int avgPhysique) {
		this.avgPhysique = avgPhysique;
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

}
