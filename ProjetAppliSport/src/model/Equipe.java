package model;

import java.util.ArrayList;
import java.util.List;

public class Equipe extends Club {


	
	protected List<Utilisateur> equipe = new ArrayList();
	
	public Equipe() {
		super();	
	}

	public Equipe(String identifiant, String mdp, String mail, String adresse, String numTel, Sport sportClub) {
		super(identifiant, mdp, mail, adresse, numTel, sportClub);	
	}


	public List<Utilisateur> getEquipe() {
		return equipe;
	}


	public void setEquipe(List<Utilisateur> equipe) {
		this.equipe = equipe;
	}

	@Override
	public String toString() {
		return "Equipe [equipe=" + equipe + ", adresse=" + adresse + ", numTel=" + numTel + ", sportClub=" + sportClub
				+ ", identifiant=" + identifiant + ", mdp=" + mdp + ", mail=" + mail + "]";
	}

	

	
	
}
