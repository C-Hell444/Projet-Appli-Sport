package projet.AppliSport.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Service;

import projet.AppliSport.model.Admin;
import projet.AppliSport.model.Caracteristique;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.ClubUtilisateur;
import projet.AppliSport.model.ClubUtilisateurKey;
import projet.AppliSport.model.Equipe;
import projet.AppliSport.model.EquipeUtilisateur;
import projet.AppliSport.model.EquipeUtilisateurKey;
import projet.AppliSport.model.Evenement;
import projet.AppliSport.model.EvenementUtilisateur;
import projet.AppliSport.model.EvenementUtilisateurKey;
import projet.AppliSport.model.Interet;
import projet.AppliSport.model.Profil;
import projet.AppliSport.model.Sexe;
import projet.AppliSport.model.Sport;
import projet.AppliSport.model.Utilisateur;







@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private SportService sportService;
	
	@Autowired
	private EvenementService evenementService;
	
	@Autowired
	private ProfilService profilService;
	
	@Autowired
	private InteretService interetService;
	
	@Autowired
	private EquipeService equipeService;
	
	@Autowired
	private CaracteristiqueService caracteristiqueService;
	
	@Autowired 
	private EquipeUtilisateurService equipeUtilisateurService;
	
	@Autowired
	private EvenementUtilisateurService evenementUtilisateurService;
	
	@Autowired
	private ClubUtilisateurService clubUtilisateurService;
	
	
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
		caracteristiqueService.createOrUpdate(c2);
	
		
		
		Sport football= new Sport();
		football.setNom("Foot");
		sportService.createOrUpdate(football);
		
		Sport basketball= new Sport();
		basketball.setNom("Basket");
		sportService.createOrUpdate(basketball);
		
		Evenement Fete= new Evenement();
		Fete.setClub(club);
		Fete.setDateDebut(null);
		Fete.setDateFin(null);
		Fete.setNom("Fete");
		evenementService.createOrUpdate(Fete);
		
		Evenement Fete2= new Evenement();
		Fete2.setClub(club);
		Fete2.setDateDebut(null);
		Fete2.setDateFin(null);
		Fete2.setNom("Fete2");
		evenementService.createOrUpdate(Fete2);
		
		Profil bg= new Profil();
		bg.setDateNaissance(null);
		bg.setPoids(40);
		bg.setSexe(Sexe.H);
		bg.setTaille(2);
		bg.setCaracteristique(c2);
		profilService.createOrUpdate(bg);
		
		Profil bg2= new Profil();
		bg2.setDateNaissance(null);
		bg2.setPoids(60);
		bg2.setSexe(Sexe.F);
		bg2.setTaille(2);
		bg2.setCaracteristique(c2);
		profilService.createOrUpdate(bg2);
		
		Equipe equipe = new Equipe();
		equipe.setClub(club);
		equipe.setNom("PSG");
		equipeService.createOrUpdate(equipe);
		
		Equipe equipe2 = new Equipe();
		equipe2.setClub(club);
		equipe2.setNom("OM");
		equipeService.createOrUpdate(equipe2);
		
		Interet yolo = new Interet();
		yolo.setSport(football);
		yolo.setUtilisateur(utilisateur);
		interetService.createOrUpdate(yolo);
		
		Interet dormir = new Interet();
		dormir.setSport(basketball);
		dormir.setUtilisateur(utilisateur);
		interetService.createOrUpdate(dormir);
		
		
		EquipeUtilisateurKey euKey1 = new EquipeUtilisateurKey(utilisateur, equipe);
		EquipeUtilisateurKey euKey2 = new EquipeUtilisateurKey(utilisateur, equipe2);
		
		EquipeUtilisateur eu1 = new EquipeUtilisateur(euKey1);
		eu1.setDateDebut(null);
		eu1.setDateFin(null);
		equipeUtilisateurService.createOrUpdate(eu1);
		EquipeUtilisateur eu2 = new EquipeUtilisateur(euKey2);
		eu1.setDateDebut(null);
		eu1.setDateFin(null);
		equipeUtilisateurService.createOrUpdate(eu2);
		
		
		EvenementUtilisateurKey evuKey1 = new EvenementUtilisateurKey(utilisateur, Fete);
		EvenementUtilisateurKey evuKey2 = new EvenementUtilisateurKey(utilisateur, Fete2);
		
		EvenementUtilisateur evu1 = new EvenementUtilisateur(evuKey1);
		evu1.setDateDebut(null);
		evu1.setDateFin(null);
		evenementUtilisateurService.createOrUpdate(evu1);
		EvenementUtilisateur evu2 = new EvenementUtilisateur(evuKey2);
		evu1.setDateDebut(null);
		evu1.setDateFin(null);
		evenementUtilisateurService.createOrUpdate(evu2);
		
		
		ClubUtilisateurKey cuKey1 = new ClubUtilisateurKey(utilisateur,club );
		
		
		ClubUtilisateur cu1 = new ClubUtilisateur(cuKey1);
		cu1.setDateDebut(null);
		cu1.setDateFin(null);
		clubUtilisateurService.createOrUpdate(cu1);
		
		
		
	}
	      
	
	

}
