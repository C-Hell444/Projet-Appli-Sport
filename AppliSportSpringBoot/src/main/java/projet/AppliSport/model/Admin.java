package projet.AppliSport.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "admin", uniqueConstraints = { @UniqueConstraint(columnNames = "compte_identifiant", name = "admin_identifiant_uk"), @UniqueConstraint(columnNames = "compte_mail", name = "admin_mail_uk") })
public class Admin extends Compte {

	
	public Admin() {
		
	}

	public Admin(String identifiant, String mdp, String mail) {
		super(identifiant, mdp, mail);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(this.getClass().getSimpleName()));
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return getMdp();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getIdentifiant();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	

	
	
	
}
