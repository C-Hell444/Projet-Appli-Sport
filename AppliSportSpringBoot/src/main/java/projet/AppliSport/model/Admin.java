package projet.AppliSport.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "admin", uniqueConstraints = { @UniqueConstraint(columnNames = "compte_identifiant", name = "admin_identifiant_uk"), @UniqueConstraint(columnNames = "compte_mail", name = "admin_mail_uk") })
public class Admin extends Compte {

	
	public Admin() {
		
	}

	public Admin(String identifiant, String mdp, String mail) {
		super(identifiant, mdp, mail);
	}

	

	
	
	
}
