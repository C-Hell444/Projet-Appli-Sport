package projet.AppliSport.services;



import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import projet.AppliSport.exception.CompteException;
import projet.AppliSport.model.Admin;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Compte;
import projet.AppliSport.model.CompteRepository;
import projet.AppliSport.model.Utilisateur;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired 
	private Validator validator;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ClubService clubService;
	
	@Autowired
	private UtilisateurService utilisateurService;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return compteRepository.findByIdentifiant(username).orElseThrow(()->{
			throw new UsernameNotFoundException("utilisateur inconnu");
		});
	}
	
	private void check(Compte compte) {
		if (!validator.validate(compte).isEmpty()) {
			throw new CompteException();
		}
		
	}
	
	public Compte createOrUpdate (@Valid Compte compte){
		
		check(compte);
		compte.setMdp(passwordEncoder.encode(compte.getMdp()));
		
		if (compte instanceof Admin) {
			return adminService.createOrUpdate((Admin)compte);
		}
		
		else if (compte instanceof Club) {
			return clubService.createOrUpdate((Club)compte);
		}
		
		else if (compte instanceof Utilisateur) {
			return utilisateurService.createOrUpdate((Utilisateur)compte);
		}
		
		else return null;
	}


	
}
