package projet.AppliSport.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Service;

import projet.AppliSport.model.Admin;
import projet.AppliSport.model.Caracteristique;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Equipe;
import projet.AppliSport.model.Evenement;
import projet.AppliSport.model.Interet;
import projet.AppliSport.model.Profil;
import projet.AppliSport.model.Sexe;
import projet.AppliSport.model.Sport;
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
		
		Caracteristique c2 = new Caracteristique();
		c2.setAgilite(2);
		c2.setCollectif(3);
		c2.setCreativite(4);
		c2.setDetente(0);
		c2.setDetermination(0);
		c2.setEndurance(0);
		c2.setPatience(2);
		c2.setPuissance(0);
		c2.setVitesse(0);
	
		
		
		Sport football= new Sport();
		football.setNom("Foot");
		
		Sport basketball= new Sport();
		basketball.setNom("Basket");
		
		Evenement Fete= new Evenement();
		Fete.setClub(club);
		Fete.setDateDebut(null);
		Fete.setDateFin(null);
		Fete.setNom("Fete");
		
		Evenement Fete2= new Evenement();
		Fete2.setClub(club);
		Fete2.setDateDebut(null);
		Fete2.setDateFin(null);
		Fete2.setNom("Fete2");
		
		Profil bg= new Profil();
		bg.setDateNaissance(null);
		bg.setPoids(40);
		bg.setSexe(Sexe.H);
		bg.setTaille(2);
		bg.setCaracteristique(c2);
		
		Profil bg2= new Profil();
		bg2.setDateNaissance(null);
		bg2.setPoids(60);
		bg2.setSexe(Sexe.F);
		bg2.setTaille(2);
		bg2.setCaracteristique(c2);
		
		Equipe equipe = new Equipe();
		equipe.setClub(club);
		equipe.setNom("PSG");
		
		Equipe equipe2 = new Equipe();
		equipe2.setClub(club);
		equipe2.setNom("OM");
		
		Interet yolo = new Interet();
		yolo.setSport(football);
		yolo.setUtilisateur(utilisateur);
		
		Interet dormir = new Interet();
		dormir.setSport(basketball);
		dormir.setUtilisateur(utilisateur);
		
		
	}
	      
	
	

}
