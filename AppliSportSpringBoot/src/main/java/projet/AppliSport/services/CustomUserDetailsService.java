package projet.AppliSport.services;

import java.util.Collection;

import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.CompteException;
import projet.AppliSport.model.Admin;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Compte;
import projet.AppliSport.model.CompteRepository;
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.repositories.AdminRepository;
import projet.AppliSport.repositories.ClubRepository;
import projet.AppliSport.repositories.UtilisateurRepository;

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
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ClubRepository clubRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	
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
		
		if (compte instanceof Admin) {
			adminService.checkData((Admin)compte);
		} else if (compte instanceof Club) {
			clubService.checkData((Club)compte);
		} else if (compte instanceof Utilisateur) {
			utilisateurService.checkData((Utilisateur)compte);
		}
		
	}
	
	public Compte create (@Valid Compte compte){
		
		check(compte);
		
		if (compte instanceof Admin) {
			Admin admin = new Admin();
			admin.setIdentifiant(compte.getIdentifiant());
			admin.setMdp(passwordEncoder.encode(compte.getMdp()));
			admin.setMail(compte.getMail());
			
			return (Compte) adminRepository.save(admin);
		}
		
		else if (compte instanceof Club) {
			Club club = new Club();
			club.setIdentifiant(compte.getIdentifiant());
			club.setMdp(passwordEncoder.encode(compte.getMdp()));
			club.setMail(compte.getMail());
			
			return (Compte) clubRepository.save(club);
		}
		
		else if (compte instanceof Utilisateur) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setIdentifiant(compte.getIdentifiant());
			utilisateur.setMdp(passwordEncoder.encode(compte.getMdp()));
			utilisateur.setMail(compte.getMail());
			
			return (Compte) utilisateurRepository.save(utilisateur);
		}
		
		else return null;
	}

}
