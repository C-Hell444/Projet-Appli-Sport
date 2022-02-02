package AppliSport.model;

public abstract class Compte {

	protected String identifiant;
	protected String mdp;
	protected String mail;
	
	
	public Compte() {
	}
	
	public Compte(String identifiant, String mdp, String mail) {
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.mail = mail;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public String getMail() {
		return mail;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Compte [identifiant=" + identifiant + ", mdp=" + mdp + ", mail=" + mail + "]";
	}
	
	
	
}
