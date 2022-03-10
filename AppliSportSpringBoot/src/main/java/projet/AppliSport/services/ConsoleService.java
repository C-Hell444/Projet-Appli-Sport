package projet.AppliSport.services;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Service;

import projet.AppliSport.model.Admin;
import projet.AppliSport.model.Adresse;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleService.class);

	static Admin admin = new Admin();

	static Adresse adresse1 = new Adresse();
	static Adresse adresse2 = new Adresse();
	static Adresse adresse3 = new Adresse();
	static Adresse adresse4 = new Adresse();
	static Adresse adresse5 = new Adresse();
	static Adresse adresse6 = new Adresse();
	static Adresse adresse7 = new Adresse();
	static Adresse adresse8 = new Adresse();
	
	static Caracteristique caracteristique1 = new Caracteristique();
	static Caracteristique caracteristique2 = new Caracteristique();
	static Caracteristique caracteristique3 = new Caracteristique();
	static Caracteristique caracteristique4 = new Caracteristique();
	static Caracteristique caracteristique5 = new Caracteristique();
	static Caracteristique caracteristique6 = new Caracteristique();
	static Caracteristique caracteristique7 = new Caracteristique();
	static Caracteristique caracteristique8 = new Caracteristique();
	static Caracteristique caracteristique9 = new Caracteristique();
	static Caracteristique caracteristique10 = new Caracteristique();
	static Caracteristique caracteristique11 = new Caracteristique();
	static Caracteristique caracteristique12 = new Caracteristique();
	static Caracteristique caracteristique13 = new Caracteristique();
	static Caracteristique caracteristique14 = new Caracteristique();
	static Caracteristique caracteristique15 = new Caracteristique();
	static Caracteristique caracteristique16 = new Caracteristique();
	static Caracteristique caracteristique17 = new Caracteristique();

	static Profil profil1 = new Profil();
	static Profil profil2 = new Profil();
	static Profil profil3 = new Profil();
	static Profil profil4 = new Profil();
	static Profil profil5 = new Profil();
	static Profil profil6 = new Profil();
	static Profil profil7 = new Profil();
	static Profil profil8 = new Profil();
	static Profil profil9 = new Profil();
	static Profil profil10 = new Profil();
	static Profil profil11 = new Profil();
	static Profil profil12 = new Profil();

	static Utilisateur utilisateur1 = new Utilisateur();
	static Utilisateur utilisateur2 = new Utilisateur();
	static Utilisateur utilisateur3 = new Utilisateur();
	static Utilisateur utilisateur4 = new Utilisateur();
	static Utilisateur utilisateur5 = new Utilisateur();
	static Utilisateur utilisateur6 = new Utilisateur();
	static Utilisateur utilisateur7 = new Utilisateur();
	static Utilisateur utilisateur8 = new Utilisateur();
	static Utilisateur utilisateur9 = new Utilisateur();
	static Utilisateur utilisateur10 = new Utilisateur();
	static Utilisateur utilisateur11 = new Utilisateur();
	static Utilisateur utilisateur12 = new Utilisateur();
	

	static Sport sport1 = new Sport();
	static Sport sport2 = new Sport();
	static Sport sport3 = new Sport();
	static Sport sport4 = new Sport();
	static Sport sport5 = new Sport();
	

	static Club club1 = new Club();
	static Club club2 = new Club();
	static Club club3 = new Club();
	static Club club4 = new Club();
	static Club club5 = new Club();
	static Club club6 = new Club();

	static Evenement evenement1 = new Evenement();
	static Evenement evenement2 = new Evenement();
	static Evenement evenement3 = new Evenement();
	static Evenement evenement4 = new Evenement();
	static Evenement evenement5 = new Evenement();
	static Evenement evenement6 = new Evenement();

	static Equipe equipe1 = new Equipe();
	static Equipe equipe2 = new Equipe();
	static Equipe equipe3 = new Equipe();
	static Equipe equipe4 = new Equipe();
	static Equipe equipe5 = new Equipe();
	static Equipe equipe6 = new Equipe();

	static Interet interet1 = new Interet();
	static Interet interet2 = new Interet();
	static Interet interet3 = new Interet();
	static Interet interet4 = new Interet();
	static Interet interet5 = new Interet();
	static Interet interet6 = new Interet();
	static Interet interet7 = new Interet();
	static Interet interet8 = new Interet();
	static Interet interet9 = new Interet();
	static Interet interet10 = new Interet();
	static Interet interet11 = new Interet();
	static Interet interet12 = new Interet();

	static ClubUtilisateurKey clubUtilisateurKey1 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey2 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey3 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey4 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey5 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey6 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey7 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey8 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey9 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey10 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey11 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey12 = new ClubUtilisateurKey();

	static ClubUtilisateur clubUtilisateur1 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur2 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur3 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur4 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur5 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur6 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur7 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur8 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur9 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur10 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur11 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur12 = new ClubUtilisateur();

	static EquipeUtilisateurKey equipeUtilisateurKey1 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey2 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey3 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey4 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey5 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey6 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey7 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey8 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey9 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey10 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey11 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey12 = new EquipeUtilisateurKey();

	static EquipeUtilisateur equipeUtilisateur1 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur2 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur3 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur4 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur5 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur6 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur7 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur8 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur9 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur10 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur11 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur12 = new EquipeUtilisateur();

	static EvenementUtilisateurKey evenementUtilisateurKey1 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey2 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey3 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey4 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey5 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey6 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey7 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey8 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey9 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey10 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey11 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey12 = new EvenementUtilisateurKey();

	static EvenementUtilisateur evenementUtilisateur1 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur2 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur3 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur4 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur5 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur6 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur7 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur8 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur9 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur10 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur11 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur12 = new EvenementUtilisateur();

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("ça fonctionne");
		initDataBase();

	}

	private void initDataBase() {

		initAdmin();

		initAdresse();

		initCaracteristique();

		initProfil();

		initUtilisateur();

		initSport();

		initClub();

		initEvenement();

		initEquipe();

		initInteret();

		initClubUtilisateur();

		initEquipeUtilisateur();

		initEvenementUtilisateur();

	}

	private void initAdmin() {
		admin.setIdentifiant("admin");
		admin.setMdp("admin");
		admin.setMail("admin@google.com");
		customUserDetailsService.createOrUpdate(admin);
	}

	private void initAdresse() {
		adresse1.setNumero("1");
		adresse1.setRue("Rue de la soif");
		adresse1.setCodePostal("35000");
		adresse1.setVille("Rennes");

		adresse2.setNumero("6");
		adresse2.setRue("Rue rougemont");
		adresse2.setCodePostal("75009");
		adresse2.setVille("Paris");

		adresse3.setNumero("13");
		adresse3.setRue("Rue de la liberté");
		adresse3.setCodePostal("75009");
		adresse3.setVille("Bordeau");

		adresse4.setNumero("1");
		adresse4.setRue("Rue serpentine");
		adresse4.setCodePostal("92400");
		adresse4.setVille("Lyon");

		adresse5.setNumero("15");
		adresse5.setRue("Rue du vol");
		adresse5.setCodePostal("75006");
		adresse5.setVille("Marseille");

		adresse6.setNumero("126");
		adresse6.setRue("Rue de l'université");
		adresse6.setCodePostal("75007");
		adresse6.setVille("Paris");
		
		adresse7.setNumero("118");
		adresse7.setRue("Rue de l'égalité");
		adresse7.setCodePostal("75007");
		adresse7.setVille("Toulouse");
		
		adresse8.setNumero("218");
		adresse8.setRue("Rue de la fraternité");
		adresse8.setCodePostal("75007");
		adresse8.setVille("Paris");

	}

	private void initCaracteristique() {
		caracteristique1.setAgilite(5);
		caracteristique1.setCollectif(5);
		caracteristique1.setCreativite(5);
		caracteristique1.setDetente(5);
		caracteristique1.setDetermination(5);
		caracteristique1.setEndurance(5);
		caracteristique1.setPatience(5);
		caracteristique1.setPuissance(5);
		caracteristique1.setVitesse(5);
		caracteristiqueService.createOrUpdate(caracteristique1);

		caracteristique2.setAgilite(7);
		caracteristique2.setCollectif(7);
		caracteristique2.setCreativite(7);
		caracteristique2.setDetente(7);
		caracteristique2.setDetermination(7);
		caracteristique2.setEndurance(7);
		caracteristique2.setPatience(7);
		caracteristique2.setPuissance(7);
		caracteristique2.setVitesse(7);
		caracteristiqueService.createOrUpdate(caracteristique2);

		caracteristique3.setAgilite(3);
		caracteristique3.setCollectif(3);
		caracteristique3.setCreativite(3);
		caracteristique3.setDetente(3);
		caracteristique3.setDetermination(3);
		caracteristique3.setEndurance(3);
		caracteristique3.setPatience(3);
		caracteristique3.setPuissance(3);
		caracteristique3.setVitesse(3);
		caracteristiqueService.createOrUpdate(caracteristique3);

		caracteristique4.setAgilite(2);
		caracteristique4.setCollectif(3);
		caracteristique4.setCreativite(4);
		caracteristique4.setDetente(5);
		caracteristique4.setDetermination(6);
		caracteristique4.setEndurance(7);
		caracteristique4.setPatience(8);
		caracteristique4.setPuissance(9);
		caracteristique4.setVitesse(1);
		caracteristiqueService.createOrUpdate(caracteristique4);

		caracteristique5.setAgilite(1);
		caracteristique5.setCollectif(1);
		caracteristique5.setCreativite(1);
		caracteristique5.setDetente(1);
		caracteristique5.setDetermination(1);
		caracteristique5.setEndurance(1);
		caracteristique5.setPatience(1);
		caracteristique5.setPuissance(1);
		caracteristique5.setVitesse(1);
		caracteristiqueService.createOrUpdate(caracteristique5);

		caracteristique6.setAgilite(2);
		caracteristique6.setCollectif(3);
		caracteristique6.setCreativite(4);
		caracteristique6.setDetente(0);
		caracteristique6.setDetermination(0);
		caracteristique6.setEndurance(0);
		caracteristique6.setPatience(2);
		caracteristique6.setPuissance(0);
		caracteristique6.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique6);

		caracteristique7.setAgilite(2);
		caracteristique7.setCollectif(3);
		caracteristique7.setCreativite(4);
		caracteristique7.setDetente(0);
		caracteristique7.setDetermination(0);
		caracteristique7.setEndurance(0);
		caracteristique7.setPatience(2);
		caracteristique7.setPuissance(0);
		caracteristique7.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique7);

		caracteristique8.setAgilite(2);
		caracteristique8.setCollectif(3);
		caracteristique8.setCreativite(4);
		caracteristique8.setDetente(0);
		caracteristique8.setDetermination(0);
		caracteristique8.setEndurance(0);
		caracteristique8.setPatience(2);
		caracteristique8.setPuissance(0);
		caracteristique8.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique8);

		caracteristique9.setAgilite(2);
		caracteristique9.setCollectif(3);
		caracteristique9.setCreativite(4);
		caracteristique9.setDetente(0);
		caracteristique9.setDetermination(0);
		caracteristique9.setEndurance(0);
		caracteristique9.setPatience(2);
		caracteristique9.setPuissance(0);
		caracteristique9.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique9);

		caracteristique10.setAgilite(2);
		caracteristique10.setCollectif(2);
		caracteristique10.setCreativite(2);
		caracteristique10.setDetente(2);
		caracteristique10.setDetermination(2);
		caracteristique10.setEndurance(2);
		caracteristique10.setPatience(2);
		caracteristique10.setPuissance(2);
		caracteristique10.setVitesse(2);
		caracteristiqueService.createOrUpdate(caracteristique10);

		caracteristique11.setAgilite(2);
		caracteristique11.setCollectif(3);
		caracteristique11.setCreativite(4);
		caracteristique11.setDetente(0);
		caracteristique11.setDetermination(0);
		caracteristique11.setEndurance(0);
		caracteristique11.setPatience(2);
		caracteristique11.setPuissance(0);
		caracteristique11.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique11);

		caracteristique12.setAgilite(2);
		caracteristique12.setCollectif(3);
		caracteristique12.setCreativite(4);
		caracteristique12.setDetente(0);
		caracteristique12.setDetermination(0);
		caracteristique12.setEndurance(0);
		caracteristique12.setPatience(2);
		caracteristique12.setPuissance(0);
		caracteristique12.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique12);
		
		caracteristique13.setAgilite(2);
		caracteristique13.setCollectif(3);
		caracteristique13.setCreativite(0);
		caracteristique13.setDetente(0);
		caracteristique13.setDetermination(0);
		caracteristique13.setEndurance(5);
		caracteristique13.setPatience(0);
		caracteristique13.setPuissance(1);
		caracteristique13.setVitesse(2);
		caracteristiqueService.createOrUpdate(caracteristique13);
		
		caracteristique14.setAgilite(2);
		caracteristique14.setCollectif(3);
		caracteristique14.setCreativite(2);
		caracteristique14.setDetente(2);
		caracteristique14.setDetermination(1);
		caracteristique14.setEndurance(1);
		caracteristique14.setPatience(2);
		caracteristique14.setPuissance(2);
		caracteristique14.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique14);
		
		caracteristique15.setAgilite(1);
		caracteristique15.setCollectif(3);
		caracteristique15.setCreativite(1);
		caracteristique15.setDetente(0);
		caracteristique15.setDetermination(5);
		caracteristique15.setEndurance(2);
		caracteristique15.setPatience(4);
		caracteristique15.setPuissance(4);
		caracteristique15.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique15);
		
		caracteristique16.setAgilite(2);
		caracteristique16.setCollectif(3);
		caracteristique16.setCreativite(4);
		caracteristique16.setDetente(0);
		caracteristique16.setDetermination(0);
		caracteristique16.setEndurance(1);
		caracteristique16.setPatience(2);
		caracteristique16.setPuissance(0);
		caracteristique16.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique16);
		
		caracteristique17.setAgilite(2);
		caracteristique17.setCollectif(0);
		caracteristique17.setCreativite(0);
		caracteristique17.setDetente(0);
		caracteristique17.setDetermination(2);
		caracteristique17.setEndurance(0);
		caracteristique17.setPatience(2);
		caracteristique17.setPuissance(0);
		caracteristique17.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique17);
	}

	private void initProfil() {
		profil1.setDateNaissance(LocalDate.parse("1990-01-01"));
		profil1.setPoids(50);
		profil1.setSexe(Sexe.H);
		profil1.setTaille(1.5);
		profil1.setCaracteristique(caracteristique1);
		profilService.createOrUpdate(profil1);

		profil2.setDateNaissance(LocalDate.parse("1991-01-01"));
		profil2.setPoids(70);
		profil2.setSexe(Sexe.H);
		profil2.setTaille(2.0);
		profil2.setCaracteristique(caracteristique2);
		profilService.createOrUpdate(profil2);

		profil3.setDateNaissance(LocalDate.parse("1992-01-01"));
		profil3.setPoids(60);
		profil3.setSexe(Sexe.F);
		profil3.setTaille(1.8);
		profil3.setCaracteristique(caracteristique3);
		profilService.createOrUpdate(profil3);

		profil4.setDateNaissance(LocalDate.parse("1993-01-01"));
		profil4.setPoids(70);
		profil4.setSexe(Sexe.H);
		profil4.setTaille(1.7);
		profil4.setCaracteristique(caracteristique4);
		profilService.createOrUpdate(profil4);

		profil5.setDateNaissance(LocalDate.parse("1994-01-01"));
		profil5.setPoids(70);
		profil5.setSexe(Sexe.H);
		profil5.setTaille(1.8);
		profil5.setCaracteristique(caracteristique5);
		profilService.createOrUpdate(profil5);

		profil6.setDateNaissance(LocalDate.parse("1995-01-01"));
		profil6.setPoids(70);
		profil6.setSexe(Sexe.H);
		profil6.setTaille(1.9);
		profil6.setCaracteristique(caracteristique6);
		profilService.createOrUpdate(profil6);
		
		profil7.setDateNaissance(LocalDate.parse("1996-12-01"));
		profil7.setPoids(63);
		profil7.setSexe(Sexe.F);
		profil7.setTaille(1.9);
		profil7.setCaracteristique(caracteristique7);
		profilService.createOrUpdate(profil7);
		
		profil8.setDateNaissance(LocalDate.parse("1995-11-01"));
		profil8.setPoids(80);
		profil8.setSexe(Sexe.H);
		profil8.setTaille(1.9);
		profil8.setCaracteristique(caracteristique8);
		profilService.createOrUpdate(profil8);
		
		profil9.setDateNaissance(LocalDate.parse("1997-06-01"));
		profil9.setPoids(48);
		profil9.setSexe(Sexe.F);
		profil9.setTaille(1.6);
		profil9.setCaracteristique(caracteristique9);
		profilService.createOrUpdate(profil9);
		
		profil10.setDateNaissance(LocalDate.parse("1995-03-08"));
		profil10.setPoids(90);
		profil10.setSexe(Sexe.H);
		profil10.setTaille(1.9);
		profil10.setCaracteristique(caracteristique10);
		profilService.createOrUpdate(profil10);
		
		profil11.setDateNaissance(LocalDate.parse("1993-01-11"));
		profil11.setPoids(56);
		profil11.setSexe(Sexe.F);
		profil11.setTaille(1.68);
		profil11.setCaracteristique(caracteristique11);
		profilService.createOrUpdate(profil11);
		
		profil12.setDateNaissance(LocalDate.parse("1992-04-01"));
		profil12.setPoids(77);
		profil12.setSexe(Sexe.H);
		profil12.setTaille(1.83);
		profil12.setCaracteristique(caracteristique12);
		profilService.createOrUpdate(profil12);
	}

	private void initUtilisateur() {

		utilisateur1.setIdentifiant("user1");
		utilisateur1.setMdp("user1");
		utilisateur1.setMail("user1@google.com");
		utilisateur1.setNom("GUEVIN");
		utilisateur1.setPrenom("Nathan");
		utilisateur1.setNumTel("0606060606");
		utilisateur1.setAdresse(adresse1);
		utilisateur1.setProfilUtilisateur(profil1);
		customUserDetailsService.createOrUpdate(utilisateur1);

		utilisateur2.setIdentifiant("user2");
		utilisateur2.setMdp("user2");
		utilisateur2.setMail("user2@google.com");
		utilisateur2.setNom("RODRIGUEZ");
		utilisateur2.setPrenom("Antoine");
		utilisateur2.setNumTel("0606060607");
		utilisateur2.setAdresse(adresse2);
		utilisateur2.setProfilUtilisateur(profil2);
		customUserDetailsService.createOrUpdate(utilisateur2);

		utilisateur3.setIdentifiant("user3");
		utilisateur3.setMdp("user3");
		utilisateur3.setMail("user3@google.com");
		utilisateur3.setNom("SAFFAR");
		utilisateur3.setPrenom("Sarah");
		utilisateur3.setNumTel("0606060608");
		utilisateur3.setAdresse(adresse3);
		utilisateur3.setProfilUtilisateur(profil3);
		customUserDetailsService.createOrUpdate(utilisateur3);

		utilisateur4.setIdentifiant("user4");
		utilisateur4.setMdp("user4");
		utilisateur4.setMail("user4@google.com");
		utilisateur4.setNom("SELLIAH");
		utilisateur4.setPrenom("Aginath");
		utilisateur4.setNumTel("0606060609");
		utilisateur4.setAdresse(adresse4);
		utilisateur4.setProfilUtilisateur(profil4);
		customUserDetailsService.createOrUpdate(utilisateur4);

		utilisateur5.setIdentifiant("user5");
		utilisateur5.setMdp("user5");
		utilisateur5.setMail("user5@google.com");
		utilisateur5.setNom("BESNESVILLE");
		utilisateur5.setPrenom("Clement");
		utilisateur5.setNumTel("0606060600");
		utilisateur5.setAdresse(adresse5);
		utilisateur5.setProfilUtilisateur(profil5);
		customUserDetailsService.createOrUpdate(utilisateur5);

		utilisateur6.setIdentifiant("user6");
		utilisateur6.setMdp("user6");
		utilisateur6.setMail("user6@google.com");
		utilisateur6.setNom("ABBID");
		utilisateur6.setPrenom("Jordan");
		utilisateur6.setNumTel("0606060601");
		utilisateur6.setAdresse(adresse6);
		utilisateur6.setProfilUtilisateur(profil6);
		customUserDetailsService.createOrUpdate(utilisateur6);
		
		utilisateur7.setIdentifiant("user7");
		utilisateur7.setMdp("user7");
		utilisateur7.setMail("user7@google.com");
		utilisateur7.setNom("MISTER");
		utilisateur7.setPrenom("J");
		utilisateur7.setNumTel("0606060601");
		utilisateur7.setAdresse(adresse7);
		utilisateur7.setProfilUtilisateur(profil7);
		customUserDetailsService.createOrUpdate(utilisateur7);
		
		utilisateur8.setIdentifiant("user8");
		utilisateur8.setMdp("user8");
		utilisateur8.setMail("user8@google.com");
		utilisateur8.setNom("ABBID");
		utilisateur8.setPrenom("Jordan");
		utilisateur8.setNumTel("0606060601");
		utilisateur8.setAdresse(adresse8);
		utilisateur8.setProfilUtilisateur(profil8);
		customUserDetailsService.createOrUpdate(utilisateur8);
		
		utilisateur9.setIdentifiant("user9");
		utilisateur9.setMdp("user9");
		utilisateur9.setMail("user9@google.com");
		utilisateur9.setNom("ABBID");
		utilisateur9.setPrenom("Jordan");
		utilisateur9.setNumTel("0606060601");
		utilisateur9.setAdresse(adresse1);
		utilisateur9.setProfilUtilisateur(profil9);
		customUserDetailsService.createOrUpdate(utilisateur9);
		
		utilisateur10.setIdentifiant("user10");
		utilisateur10.setMdp("user10");
		utilisateur10.setMail("user10@google.com");
		utilisateur10.setNom("ABBID");
		utilisateur10.setPrenom("Jordan");
		utilisateur10.setNumTel("0606060601");
		utilisateur10.setAdresse(adresse4);
		utilisateur10.setProfilUtilisateur(profil10);
		customUserDetailsService.createOrUpdate(utilisateur10);
		
		utilisateur11.setIdentifiant("user11");
		utilisateur11.setMdp("user11");
		utilisateur11.setMail("user11@google.com");
		utilisateur11.setNom("ABBID");
		utilisateur11.setPrenom("Jordan");
		utilisateur11.setNumTel("0606060601");
		utilisateur11.setAdresse(adresse5);
		utilisateur11.setProfilUtilisateur(profil11);
		customUserDetailsService.createOrUpdate(utilisateur11);
		
		utilisateur12.setIdentifiant("user12");
		utilisateur12.setMdp("user12");
		utilisateur12.setMail("user12@google.com");
		utilisateur12.setNom("ABBID");
		utilisateur12.setPrenom("Jordan");
		utilisateur12.setNumTel("0606060601");
		utilisateur12.setAdresse(adresse6);
		utilisateur12.setProfilUtilisateur(profil12);
		customUserDetailsService.createOrUpdate(utilisateur12);
		
	}

	private void initSport() {

		sport1.setNom("Football");
		sport1.setCaracteristique(caracteristique13);
		sportService.createOrUpdate(sport1);

		sport2.setNom("Handball");
		sport2.setCaracteristique(caracteristique14);
		sportService.createOrUpdate(sport2);

		sport3.setNom("Rugby");
		sport3.setCaracteristique(caracteristique15);
		sportService.createOrUpdate(sport3);
		
		sport4.setNom("Natation");
		sport4.setCaracteristique(caracteristique16);
		sportService.createOrUpdate(sport4);
		
		sport5.setNom("Triathlon");
		sport5.setCaracteristique(caracteristique17);
		sportService.createOrUpdate(sport5);
	}

	private void initClub() {

		club1.setIdentifiant("club1");
		club1.setMdp("club1");
		club1.setMail("club1@gmail.com");
		club1.setClubNom("PSG");
		club1.setNumTel("0606060606");
		club1.setAdresse(adresse1);
		club1.setSportClub(sport1);
		customUserDetailsService.createOrUpdate(club1);

		club2.setIdentifiant("club2");
		club2.setMdp("club2");
		club2.setMail("club2@gmail.com");
		club2.setClubNom("Marseille");
		club2.setNumTel("0632781971");
		club2.setAdresse(adresse2);
		club2.setSportClub(sport2);
		customUserDetailsService.createOrUpdate(club2);

		club3.setIdentifiant("club3");
		club3.setMdp("club3");
		club3.setMail("club3@gmail.com");
		club3.setClubNom("Toulouse FC");
		club3.setNumTel("0657972412");
		club3.setAdresse(adresse3);
		club3.setSportClub(sport3);
		customUserDetailsService.createOrUpdate(club3);

		club4.setIdentifiant("club4");
		club4.setMdp("club4");
		club4.setMail("club4@gmail.com");
		club4.setClubNom("Les Canaries");
		club4.setNumTel("0606060606");
		club4.setAdresse(adresse4);
		club4.setSportClub(sport1);
		customUserDetailsService.createOrUpdate(club4);

		club5.setIdentifiant("club5");
		club5.setMdp("club5");
		club5.setMail("club5@gmail.com");
		club5.setClubNom("Les no stress");
		club5.setNumTel("0606060606");
		club5.setAdresse(adresse5);
		club5.setSportClub(sport2);
		customUserDetailsService.createOrUpdate(club5);

		club6.setIdentifiant("club6");
		club6.setMdp("club6");
		club6.setMail("club6@gmail.com");
		club6.setClubNom("Les Manchots");
		club6.setNumTel("0606060606");
		club6.setAdresse(adresse6);
		club6.setSportClub(sport3);
		customUserDetailsService.createOrUpdate(club6);
	}

	private void initEvenement() {

		evenement1.setClub(club1);
		evenement1.setDateDebut(LocalDate.parse("2021-01-01"));
		evenement1.setDateFin(LocalDate.parse("2023-01-01"));
		evenement1.setNom("Formule-E");
		evenementService.createOrUpdate(evenement1);

		evenement2.setClub(club1);
		evenement2.setDateDebut(LocalDate.parse("2021-02-01"));
		evenement2.setDateFin(LocalDate.parse("2023-02-01"));
		evenement2.setNom("Marathon de Paris");
		evenementService.createOrUpdate(evenement2);

		evenement3.setClub(club1);
		evenement3.setDateDebut(LocalDate.parse("2021-03-01"));
		evenement3.setDateFin(LocalDate.parse("2023-03-01"));
		evenement3.setNom("Le saut d'Hermès");
		evenementService.createOrUpdate(evenement3);

		evenement4.setClub(club2);
		evenement4.setDateDebut(LocalDate.parse("2021-04-01"));
		evenement4.setDateFin(LocalDate.parse("2023-04-01"));
		evenement4.setNom("The Color Run");
		evenementService.createOrUpdate(evenement4);

		evenement5.setClub(club2);
		evenement5.setDateDebut(LocalDate.parse("2021-05-01"));
		evenement5.setDateFin(LocalDate.parse("2023-05-01"));
		evenement5.setNom("La verticale de la tour Eiffel");
		evenementService.createOrUpdate(evenement5);

		evenement6.setClub(club2);
		evenement6.setDateDebut(LocalDate.parse("2021-06-01"));
		evenement6.setDateFin(LocalDate.parse("2023-06-01"));
		evenement6.setNom("Baignade dans la Seine");
		evenementService.createOrUpdate(evenement6);
	}

	private void initEquipe() {

		equipe1.setClub(club1);
		equipe1.setNom("FC Hermont");
		equipeService.createOrUpdate(equipe1);

		equipe2.setClub(club1);
		equipe2.setNom("Les Whites Walkers");
		equipeService.createOrUpdate(equipe2);

		equipe3.setClub(club1);
		equipe3.setNom("Redbull Sports club");
		equipeService.createOrUpdate(equipe3);

		equipe4.setClub(club2);
		equipe4.setNom("L'athlétic sport aixois ");
		equipeService.createOrUpdate(equipe4);

		equipe5.setClub(club2);
		equipe5.setNom("A.S SHARK NATATION DES ABYMES");
		equipeService.createOrUpdate(equipe5);

		equipe6.setClub(club2);
		equipe6.setNom("L'union sportives Montagnard");
		equipeService.createOrUpdate(equipe6);
	}

	private void initInteret() {

		interet1.setSport(sport1);
		interet1.setUtilisateur(utilisateur1);
		interetService.createOrUpdate(interet1);

		interet2.setSport(sport2);
		interet2.setUtilisateur(utilisateur2);
		interetService.createOrUpdate(interet2);

		interet3.setSport(sport3);
		interet3.setUtilisateur(utilisateur3);
		interetService.createOrUpdate(interet3);

		interet4.setSport(sport1);
		interet4.setUtilisateur(utilisateur4);
		interetService.createOrUpdate(interet4);

		interet5.setSport(sport2);
		interet5.setUtilisateur(utilisateur5);
		interetService.createOrUpdate(interet5);

		interet6.setSport(sport3);
		interet6.setUtilisateur(utilisateur6);
		interetService.createOrUpdate(interet6);
		
		interet7.setSport(sport3);
		interet7.setUtilisateur(utilisateur7);
		interetService.createOrUpdate(interet7);
		
		interet8.setSport(sport2);
		interet8.setUtilisateur(utilisateur8);
		interetService.createOrUpdate(interet8);
		
		interet9.setSport(sport1);
		interet9.setUtilisateur(utilisateur9);
		interetService.createOrUpdate(interet9);
		
		interet10.setSport(sport3);
		interet10.setUtilisateur(utilisateur10);
		interetService.createOrUpdate(interet10);
		
		interet11.setSport(sport2);
		interet11.setUtilisateur(utilisateur11);
		interetService.createOrUpdate(interet11);
		
		interet12.setSport(sport1);
		interet12.setUtilisateur(utilisateur12);
		interetService.createOrUpdate(interet12);
		
	}

	private void initClubUtilisateur() {
		clubUtilisateurKey1.setClub(club1);
		clubUtilisateurKey1.setUtilisateur(utilisateur1);
		clubUtilisateur1.setClubUtilisateurKey(clubUtilisateurKey1);
		clubUtilisateur1.setDateDebut(LocalDate.parse("2020-01-01"));
		clubUtilisateur1.setDateFin(LocalDate.parse("null"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur1);

		clubUtilisateurKey2.setClub(club2);
		clubUtilisateurKey2.setUtilisateur(utilisateur2);
		clubUtilisateur2.setClubUtilisateurKey(clubUtilisateurKey2);
		clubUtilisateur2.setDateDebut(LocalDate.parse("2020-02-01"));
		clubUtilisateur2.setDateFin(LocalDate.parse("null"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur2);

		clubUtilisateurKey3.setClub(club1);
		clubUtilisateurKey3.setUtilisateur(utilisateur3);
		clubUtilisateur3.setClubUtilisateurKey(clubUtilisateurKey3);
		clubUtilisateur3.setDateDebut(LocalDate.parse("2020-03-01"));
		clubUtilisateur3.setDateFin(LocalDate.parse("null"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur3);

		clubUtilisateurKey4.setClub(club2);
		clubUtilisateurKey4.setUtilisateur(utilisateur4);
		clubUtilisateur4.setClubUtilisateurKey(clubUtilisateurKey4);
		clubUtilisateur4.setDateDebut(LocalDate.parse("2020-04-01"));
		clubUtilisateur4.setDateFin(LocalDate.parse("null"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur4);

		clubUtilisateurKey5.setClub(club2);
		clubUtilisateurKey5.setUtilisateur(utilisateur5);
		clubUtilisateur5.setClubUtilisateurKey(clubUtilisateurKey5);
		clubUtilisateur5.setDateDebut(LocalDate.parse("2020-05-01"));
		clubUtilisateur5.setDateFin(LocalDate.parse("null"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur5);

		clubUtilisateurKey6.setClub(club2);
		clubUtilisateurKey6.setUtilisateur(utilisateur6);
		clubUtilisateur6.setClubUtilisateurKey(clubUtilisateurKey6);
		clubUtilisateur6.setDateDebut(LocalDate.parse("2020-06-01"));
		clubUtilisateur6.setDateFin(LocalDate.parse("null"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur6);
		
		clubUtilisateurKey7.setClub(club1);
		clubUtilisateurKey7.setUtilisateur(utilisateur7);
		clubUtilisateur7.setClubUtilisateurKey(clubUtilisateurKey7);
		clubUtilisateur7.setDateDebut(LocalDate.parse("2020-01-01"));
		clubUtilisateur7.setDateFin(LocalDate.parse("null"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur7);

		clubUtilisateurKey8.setClub(club2);
		clubUtilisateurKey8.setUtilisateur(utilisateur8);
		clubUtilisateur8.setClubUtilisateurKey(clubUtilisateurKey8);
		clubUtilisateur8.setDateDebut(LocalDate.parse("2020-02-01"));
		clubUtilisateur8.setDateFin(LocalDate.parse("null"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur8);
		
		clubUtilisateurKey9.setClub(club1);
		clubUtilisateurKey9.setUtilisateur(utilisateur9);
		clubUtilisateur9.setClubUtilisateurKey(clubUtilisateurKey9);
		clubUtilisateur9.setDateDebut(LocalDate.parse("2020-01-01"));
		clubUtilisateur9.setDateFin(LocalDate.parse("null"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur9);

		clubUtilisateurKey10.setClub(club2);
		clubUtilisateurKey10.setUtilisateur(utilisateur10);
		clubUtilisateur10.setClubUtilisateurKey(clubUtilisateurKey10);
		clubUtilisateur10.setDateDebut(LocalDate.parse("2020-02-01"));
		clubUtilisateur10.setDateFin(LocalDate.parse("null"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur10);
		
		clubUtilisateurKey11.setClub(club1);
		clubUtilisateurKey11.setUtilisateur(utilisateur11);
		clubUtilisateur11.setClubUtilisateurKey(clubUtilisateurKey11);
		clubUtilisateur11.setDateDebut(LocalDate.parse("2020-01-01"));
		clubUtilisateur11.setDateFin(LocalDate.parse("null"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur1);

		clubUtilisateurKey12.setClub(club2);
		clubUtilisateurKey12.setUtilisateur(utilisateur12);
		clubUtilisateur12.setClubUtilisateurKey(clubUtilisateurKey12);
		clubUtilisateur12.setDateDebut(LocalDate.parse("2020-02-01"));
		clubUtilisateur12.setDateFin(LocalDate.parse("null"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur12);
		
		
		
	}

	private void initEquipeUtilisateur() {
		equipeUtilisateurKey1.setEquipe(equipe1);
		equipeUtilisateurKey1.setUtilisateur(utilisateur1);
		equipeUtilisateur1.setEquipeUtilisateurKey(equipeUtilisateurKey1);
		equipeUtilisateur1.setDateDebut(LocalDate.parse("2020-01-01"));
		equipeUtilisateur1.setDateFin(LocalDate.parse("null"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur1);

		equipeUtilisateurKey2.setEquipe(equipe1);
		equipeUtilisateurKey2.setUtilisateur(utilisateur2);
		equipeUtilisateur2.setEquipeUtilisateurKey(equipeUtilisateurKey2);
		equipeUtilisateur2.setDateDebut(LocalDate.parse("2020-02-01"));
		equipeUtilisateur2.setDateFin(LocalDate.parse("null"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur2);

		equipeUtilisateurKey3.setEquipe(equipe2);
		equipeUtilisateurKey3.setUtilisateur(utilisateur3);
		equipeUtilisateur3.setEquipeUtilisateurKey(equipeUtilisateurKey3);
		equipeUtilisateur3.setDateDebut(LocalDate.parse("2020-03-01"));
		equipeUtilisateur3.setDateFin(LocalDate.parse("null"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur3);

		equipeUtilisateurKey4.setEquipe(equipe2);
		equipeUtilisateurKey4.setUtilisateur(utilisateur4);
		equipeUtilisateur4.setEquipeUtilisateurKey(equipeUtilisateurKey4);
		equipeUtilisateur4.setDateDebut(LocalDate.parse("2020-04-01"));
		equipeUtilisateur4.setDateFin(LocalDate.parse("null"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur4);

		equipeUtilisateurKey5.setEquipe(equipe3);
		equipeUtilisateurKey5.setUtilisateur(utilisateur5);
		equipeUtilisateur5.setEquipeUtilisateurKey(equipeUtilisateurKey5);
		equipeUtilisateur5.setDateDebut(LocalDate.parse("2020-05-01"));
		equipeUtilisateur5.setDateFin(LocalDate.parse("null"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur5);

		equipeUtilisateurKey6.setEquipe(equipe3);
		equipeUtilisateurKey6.setUtilisateur(utilisateur6);
		equipeUtilisateur6.setEquipeUtilisateurKey(equipeUtilisateurKey6);
		equipeUtilisateur6.setDateDebut(LocalDate.parse("2020-06-01"));
		equipeUtilisateur6.setDateFin(LocalDate.parse("null"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur6);
		
		equipeUtilisateurKey7.setEquipe(equipe1);
		equipeUtilisateurKey7.setUtilisateur(utilisateur7);
		equipeUtilisateur7.setEquipeUtilisateurKey(equipeUtilisateurKey7);
		equipeUtilisateur7.setDateDebut(LocalDate.parse("2020-01-01"));
		equipeUtilisateur7.setDateFin(LocalDate.parse("null"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur7);
		
		equipeUtilisateurKey8.setEquipe(equipe2);
		equipeUtilisateurKey8.setUtilisateur(utilisateur8);
		equipeUtilisateur8.setEquipeUtilisateurKey(equipeUtilisateurKey8);
		equipeUtilisateur8.setDateDebut(LocalDate.parse("2020-01-01"));
		equipeUtilisateur8.setDateFin(LocalDate.parse("null"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur8);
		
		equipeUtilisateurKey9.setEquipe(equipe1);
		equipeUtilisateurKey9.setUtilisateur(utilisateur9);
		equipeUtilisateur9.setEquipeUtilisateurKey(equipeUtilisateurKey9);
		equipeUtilisateur9.setDateDebut(LocalDate.parse("2020-01-01"));
		equipeUtilisateur9.setDateFin(LocalDate.parse("null"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur7);
		
		equipeUtilisateurKey10.setEquipe(equipe2);
		equipeUtilisateurKey10.setUtilisateur(utilisateur10);
		equipeUtilisateur10.setEquipeUtilisateurKey(equipeUtilisateurKey10);
		equipeUtilisateur10.setDateDebut(LocalDate.parse("2020-01-01"));
		equipeUtilisateur10.setDateFin(LocalDate.parse("null"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur10);
		
		equipeUtilisateurKey11.setEquipe(equipe1);
		equipeUtilisateurKey11.setUtilisateur(utilisateur11);
		equipeUtilisateur11.setEquipeUtilisateurKey(equipeUtilisateurKey11);
		equipeUtilisateur11.setDateDebut(LocalDate.parse("2020-01-01"));
		equipeUtilisateur11.setDateFin(LocalDate.parse("null"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur11);
		
		equipeUtilisateurKey12.setEquipe(equipe2);
		equipeUtilisateurKey12.setUtilisateur(utilisateur12);
		equipeUtilisateur12.setEquipeUtilisateurKey(equipeUtilisateurKey12);
		equipeUtilisateur12.setDateDebut(LocalDate.parse("2020-01-01"));
		equipeUtilisateur12.setDateFin(LocalDate.parse("null"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur12);

	}

	private void initEvenementUtilisateur() {
		evenementUtilisateurKey1.setEvenement(evenement1);
		evenementUtilisateurKey1.setUtilisateur(utilisateur1);
		evenementUtilisateur1.setId(evenementUtilisateurKey1);
		evenementUtilisateur1.setDateDebut(evenement1.getDateDebut());
		evenementUtilisateur1.setDateFin(evenement1.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur1);

		evenementUtilisateurKey2.setEvenement(evenement2);
		evenementUtilisateurKey2.setUtilisateur(utilisateur2);
		evenementUtilisateur2.setId(evenementUtilisateurKey2);
		evenementUtilisateur2.setDateDebut(evenement2.getDateDebut());
		evenementUtilisateur2.setDateFin(evenement2.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur2);

		evenementUtilisateurKey3.setEvenement(evenement3);
		evenementUtilisateurKey3.setUtilisateur(utilisateur3);
		evenementUtilisateur3.setId(evenementUtilisateurKey3);
		evenementUtilisateur3.setDateDebut(evenement3.getDateDebut());
		evenementUtilisateur3.setDateFin(evenement3.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur3);

		evenementUtilisateurKey4.setEvenement(evenement3);
		evenementUtilisateurKey4.setUtilisateur(utilisateur4);
		evenementUtilisateur4.setId(evenementUtilisateurKey4);
		evenementUtilisateur4.setDateDebut(evenement3.getDateDebut());
		evenementUtilisateur4.setDateFin(evenement3.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur4);

		evenementUtilisateurKey5.setEvenement(evenement4);
		evenementUtilisateurKey5.setUtilisateur(utilisateur5);
		evenementUtilisateur5.setId(evenementUtilisateurKey5);
		evenementUtilisateur5.setDateDebut(evenement4.getDateDebut());
		evenementUtilisateur5.setDateFin(evenement4.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur5);

		evenementUtilisateurKey6.setEvenement(evenement5);
		evenementUtilisateurKey6.setUtilisateur(utilisateur6);
		evenementUtilisateur6.setId(evenementUtilisateurKey6);
		evenementUtilisateur6.setDateDebut(evenement5.getDateDebut());
		evenementUtilisateur6.setDateFin(evenement5.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur6);
		
		evenementUtilisateurKey7.setEvenement(evenement1);
		evenementUtilisateurKey7.setUtilisateur(utilisateur7);
		evenementUtilisateur7.setId(evenementUtilisateurKey7);
		evenementUtilisateur7.setDateDebut(evenement1.getDateDebut());
		evenementUtilisateur7.setDateFin(evenement1.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur7);

		evenementUtilisateurKey8.setEvenement(evenement2);
		evenementUtilisateurKey8.setUtilisateur(utilisateur8);
		evenementUtilisateur8.setId(evenementUtilisateurKey8);
		evenementUtilisateur8.setDateDebut(evenement2.getDateDebut());
		evenementUtilisateur8.setDateFin(evenement2.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur8);
		
		evenementUtilisateurKey9.setEvenement(evenement1);
		evenementUtilisateurKey9.setUtilisateur(utilisateur9);
		evenementUtilisateur9.setId(evenementUtilisateurKey9);
		evenementUtilisateur9.setDateDebut(evenement1.getDateDebut());
		evenementUtilisateur9.setDateFin(evenement1.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur9);

		evenementUtilisateurKey10.setEvenement(evenement2);
		evenementUtilisateurKey10.setUtilisateur(utilisateur10);
		evenementUtilisateur10.setId(evenementUtilisateurKey10);
		evenementUtilisateur10.setDateDebut(evenement2.getDateDebut());
		evenementUtilisateur10.setDateFin(evenement2.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur10);
	}

}
