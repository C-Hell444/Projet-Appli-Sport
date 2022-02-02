package AppliSport.model.caracteristiques;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("mental")
public  class Mental extends Caracteristique {

	@Column(name="carac_mentale_avg")
	private int avgMental;
	@Column(name="carac_mentale_collectif")
	private int collectif;
	@Column(name="carac_mentale_creativite")
	private int creativite;
	@Column(name="carac_mentale_determination")
	private int determination;
	@Column(name="carac_mentale_patience")
	private int patience;
	

	public Mental() {
	}


	public Mental(int avgMental, int collectif, int creativite, int determination, int patience) {
		super();
		this.avgMental = avgMental;
		this.collectif = collectif;
		this.creativite = creativite;
		this.determination = determination;
		this.patience = patience;
	}


	public int getAvgMental() {
		return avgMental;
	}

	public void setAvgMental(int avgMental) {
		this.avgMental = avgMental;
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

	

	
	
	

	
	
}
