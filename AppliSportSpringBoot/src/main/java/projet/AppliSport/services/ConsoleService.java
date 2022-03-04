package projet.AppliSport.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Service;

import projet.AppliSport.model.Admin;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Utilisateur;






@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ConsoleService.class);
	
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("ça fonctionne");
		initDataBase();
		
	}
	

	private void initDataBase() {
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdentifiant("user");
		utilisateur.setMdp("user");
		utilisateur.setMail("user@google.com");
		utilisateur.setNom("user");
		utilisateur.setPrenom("user");
		utilisateur.setNumTel("0606060606");
		customUserDetailsService.createOrUpdate(utilisateur);
		
		Admin admin = new Admin();
		admin.setIdentifiant("admin");
		admin.setMdp("admin");
		admin.setMail("admin@google.com");
		customUserDetailsService.createOrUpdate(admin);
		
		Club club = new Club();
		club.setIdentifiant("club");
		club.setMdp("club");
		club.setMail("club@gmail.com");
		club.setClubNom("club");
		club.setNumTel("0606060606");
		customUserDetailsService.createOrUpdate(club);
		
		
	}
	      
	
	

}
