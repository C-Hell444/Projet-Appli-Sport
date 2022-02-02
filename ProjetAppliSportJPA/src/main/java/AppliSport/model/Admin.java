package model;

public class Admin extends Compte {

	
	public Admin() {
		super();
	}

	public Admin(String identifiant, String mdp, String mail) {
		super(identifiant, mdp, mail);
	}

	@Override
	public String toString() {
		return "Admin [identifiant=" + identifiant + ", mdp=" + mdp + ", mail=" + mail + "]";
	}

	
}
