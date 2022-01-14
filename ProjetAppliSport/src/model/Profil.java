package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.caracteristiques.Caracteristique;

public class Profil {

	protected double poids;
	protected double taille;
	protected LocalDate dateNaissance;
	protected Sexe sexe;
	protected List<Caracteristique> listeCaracteristiques = new ArrayList();
	
	
	
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
	public String toString() {
		return "Profil [poids=" + poids + ", taille=" + taille + ", dateNaissance=" + dateNaissance + "]";
	}
	
	
	
}
