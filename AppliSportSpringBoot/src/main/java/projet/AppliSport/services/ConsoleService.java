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

	static Profil profil1 = new Profil();
	static Profil profil2 = new Profil();
	static Profil profil3 = new Profil();
	static Profil profil4 = new Profil();
	static Profil profil5 = new Profil();
	static Profil profil6 = new Profil();

	static Utilisateur utilisateur1 = new Utilisateur();
	static Utilisateur utilisateur2 = new Utilisateur();
	static Utilisateur utilisateur3 = new Utilisateur();
	static Utilisateur utilisateur4 = new Utilisateur();
	static Utilisateur utilisateur5 = new Utilisateur();
	static Utilisateur utilisateur6 = new Utilisateur();

	static Sport sport1 = new Sport();
	static Sport sport2 = new Sport();
	static Sport sport3 = new Sport();

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

	static ClubUtilisateurKey clubUtilisateurKey1 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey2 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey3 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey4 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey5 = new ClubUtilisateurKey();
	static ClubUtilisateurKey clubUtilisateurKey6 = new ClubUtilisateurKey();

	static ClubUtilisateur clubUtilisateur1 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur2 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur3 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur4 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur5 = new ClubUtilisateur();
	static ClubUtilisateur clubUtilisateur6 = new ClubUtilisateur();

	static EquipeUtilisateurKey equipeUtilisateurKey1 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey2 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey3 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey4 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey5 = new EquipeUtilisateurKey();
	static EquipeUtilisateurKey equipeUtilisateurKey6 = new EquipeUtilisateurKey();

	static EquipeUtilisateur equipeUtilisateur1 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur2 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur3 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur4 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur5 = new EquipeUtilisateur();
	static EquipeUtilisateur equipeUtilisateur6 = new EquipeUtilisateur();

	static EvenementUtilisateurKey evenementUtilisateurKey1 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey2 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey3 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey4 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey5 = new EvenementUtilisateurKey();
	static EvenementUtilisateurKey evenementUtilisateurKey6 = new EvenementUtilisateurKey();

	static EvenementUtilisateur evenementUtilisateur1 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur2 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur3 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur4 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur5 = new EvenementUtilisateur();
	static EvenementUtilisateur evenementUtilisateur6 = new EvenementUtilisateur();

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
		adresse3.setRue("Rue rougemont");
		adresse3.setCodePostal("75009");
		adresse3.setVille("Paris");

		adresse4.setNumero("1");
		adresse4.setRue("Rue serpentine");
		adresse4.setCodePostal("92400");
		adresse4.setVille("Courbevoie");

		adresse5.setNumero("15");
		adresse5.setRue("Rue de vaugirard");
		adresse5.setCodePostal("75006");
		adresse5.setVille("Paris");

		adresse6.setNumero("126");
		adresse6.setRue("Rue de l'université");
		adresse6.setCodePostal("75007");
		adresse6.setVille("Paris");

	}

	private void initCaracteristique() {
		caracteristique1.setAgilite(2);
		caracteristique1.setCollectif(3);
		caracteristique1.setCreativite(4);
		caracteristique1.setDetente(0);
		caracteristique1.setDetermination(0);
		caracteristique1.setEndurance(0);
		caracteristique1.setPatience(2);
		caracteristique1.setPuissance(0);
		caracteristique1.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique1);

		caracteristique2.setAgilite(2);
		caracteristique2.setCollectif(3);
		caracteristique2.setCreativite(4);
		caracteristique2.setDetente(0);
		caracteristique2.setDetermination(0);
		caracteristique2.setEndurance(0);
		caracteristique2.setPatience(2);
		caracteristique2.setPuissance(0);
		caracteristique2.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique2);

		caracteristique3.setAgilite(2);
		caracteristique3.setCollectif(3);
		caracteristique3.setCreativite(4);
		caracteristique3.setDetente(0);
		caracteristique3.setDetermination(0);
		caracteristique3.setEndurance(0);
		caracteristique3.setPatience(2);
		caracteristique3.setPuissance(0);
		caracteristique3.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique3);

		caracteristique4.setAgilite(2);
		caracteristique4.setCollectif(3);
		caracteristique4.setCreativite(4);
		caracteristique4.setDetente(0);
		caracteristique4.setDetermination(0);
		caracteristique4.setEndurance(0);
		caracteristique4.setPatience(2);
		caracteristique4.setPuissance(0);
		caracteristique4.setVitesse(0);
		caracteristiqueService.createOrUpdate(caracteristique4);

		caracteristique5.setAgilite(2);
		caracteristique5.setCollectif(3);
		caracteristique5.setCreativite(4);
		caracteristique5.setDetente(0);
		caracteristique5.setDetermination(0);
		caracteristique5.setEndurance(0);
		caracteristique5.setPatience(2);
		caracteristique5.setPuissance(0);
		caracteristique5.setVitesse(0);
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
		caracteristique10.setCollectif(3);
		caracteristique10.setCreativite(4);
		caracteristique10.setDetente(0);
		caracteristique10.setDetermination(0);
		caracteristique10.setEndurance(0);
		caracteristique10.setPatience(2);
		caracteristique10.setPuissance(0);
		caracteristique10.setVitesse(0);
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
	}

	private void initProfil() {
		profil1.setDateNaissance(LocalDate.parse("1990-01-01"));
		profil1.setPoids(70);
		profil1.setSexe(Sexe.H);
		profil1.setTaille(1.7);
		profil1.setCaracteristique(caracteristique1);
		profilService.createOrUpdate(profil1);

		profil2.setDateNaissance(LocalDate.parse("1991-01-01"));
		profil2.setPoids(70);
		profil2.setSexe(Sexe.H);
		profil2.setTaille(1.7);
		profil2.setCaracteristique(caracteristique2);
		profilService.createOrUpdate(profil2);

		profil3.setDateNaissance(LocalDate.parse("1992-01-01"));
		profil3.setPoids(70);
		profil3.setSexe(Sexe.H);
		profil3.setTaille(1.7);
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
		profil5.setTaille(1.7);
		profil5.setCaracteristique(caracteristique5);
		profilService.createOrUpdate(profil5);

		profil6.setDateNaissance(LocalDate.parse("1995-01-01"));
		profil6.setPoids(70);
		profil6.setSexe(Sexe.H);
		profil6.setTaille(1.7);
		profil6.setCaracteristique(caracteristique6);
		profilService.createOrUpdate(profil6);
	}

	private void initUtilisateur() {

		utilisateur1.setIdentifiant("user1");
		utilisateur1.setMdp("user1");
		utilisateur1.setMail("user1@google.com");
		utilisateur1.setNom("user");
		utilisateur1.setPrenom("user");
		utilisateur1.setNumTel("0606060606");
		utilisateur1.setAdresse(adresse1);
		utilisateur1.setProfilUtilisateur(profil1);
		customUserDetailsService.createOrUpdate(utilisateur1);

		utilisateur2.setIdentifiant("user2");
		utilisateur2.setMdp("user2");
		utilisateur2.setMail("user2@google.com");
		utilisateur2.setNom("user");
		utilisateur2.setPrenom("user");
		utilisateur2.setNumTel("0606060607");
		utilisateur2.setAdresse(adresse2);
		utilisateur2.setProfilUtilisateur(profil2);
		customUserDetailsService.createOrUpdate(utilisateur2);

		utilisateur3.setIdentifiant("user3");
		utilisateur3.setMdp("user3");
		utilisateur3.setMail("user3@google.com");
		utilisateur3.setNom("user");
		utilisateur3.setPrenom("user");
		utilisateur3.setNumTel("0606060608");
		utilisateur3.setAdresse(adresse3);
		utilisateur3.setProfilUtilisateur(profil3);
		customUserDetailsService.createOrUpdate(utilisateur3);

		utilisateur4.setIdentifiant("user4");
		utilisateur4.setMdp("user4");
		utilisateur4.setMail("user4@google.com");
		utilisateur4.setNom("user");
		utilisateur4.setPrenom("user");
		utilisateur4.setNumTel("0606060609");
		utilisateur4.setAdresse(adresse4);
		utilisateur4.setProfilUtilisateur(profil4);
		customUserDetailsService.createOrUpdate(utilisateur4);

		utilisateur5.setIdentifiant("user5");
		utilisateur5.setMdp("user5");
		utilisateur5.setMail("user5@google.com");
		utilisateur5.setNom("user");
		utilisateur5.setPrenom("user");
		utilisateur5.setNumTel("0606060600");
		utilisateur5.setAdresse(adresse5);
		utilisateur5.setProfilUtilisateur(profil5);
		customUserDetailsService.createOrUpdate(utilisateur5);

		utilisateur6.setIdentifiant("user6");
		utilisateur6.setMdp("user6");
		utilisateur6.setMail("user6@google.com");
		utilisateur6.setNom("user");
		utilisateur6.setPrenom("user");
		utilisateur6.setNumTel("0606060601");
		utilisateur6.setAdresse(adresse6);
		utilisateur6.setProfilUtilisateur(profil6);
		customUserDetailsService.createOrUpdate(utilisateur6);
	}

	private void initSport() {

		sport1.setNom("Football");
		sport1.setCaracteristique(caracteristique10);
		sportService.createOrUpdate(sport1);

		sport2.setNom("Handball");
		sport2.setCaracteristique(caracteristique11);
		sportService.createOrUpdate(sport2);

		sport3.setNom("Rugby");
		sport3.setCaracteristique(caracteristique12);
		sportService.createOrUpdate(sport3);
	}

	private void initClub() {

		club1.setIdentifiant("club1");
		club1.setMdp("club1");
		club1.setMail("club1@gmail.com");
		club1.setClubNom("club");
		club1.setNumTel("0606060606");
		club1.setAdresse(adresse1);
		club1.setSportClub(sport1);
		customUserDetailsService.createOrUpdate(club1);

		club2.setIdentifiant("club2");
		club2.setMdp("club2");
		club2.setMail("club2@gmail.com");
		club2.setClubNom("club");
		club2.setNumTel("0606060606");
		club2.setAdresse(adresse2);
		club2.setSportClub(sport2);
		customUserDetailsService.createOrUpdate(club2);

		club3.setIdentifiant("club3");
		club3.setMdp("club3");
		club3.setMail("club3@gmail.com");
		club3.setClubNom("club");
		club3.setNumTel("0606060606");
		club3.setAdresse(adresse3);
		club3.setSportClub(sport3);
		customUserDetailsService.createOrUpdate(club3);

		club4.setIdentifiant("club4");
		club4.setMdp("club4");
		club4.setMail("club4@gmail.com");
		club4.setClubNom("club");
		club4.setNumTel("0606060606");
		club4.setAdresse(adresse4);
		club4.setSportClub(sport1);
		customUserDetailsService.createOrUpdate(club4);

		club5.setIdentifiant("club5");
		club5.setMdp("club5");
		club5.setMail("club5@gmail.com");
		club5.setClubNom("club");
		club5.setNumTel("0606060606");
		club5.setAdresse(adresse5);
		club5.setSportClub(sport2);
		customUserDetailsService.createOrUpdate(club5);

		club6.setIdentifiant("club6");
		club6.setMdp("club6");
		club6.setMail("club6@gmail.com");
		club6.setClubNom("club");
		club6.setNumTel("0606060606");
		club6.setAdresse(adresse6);
		club6.setSportClub(sport3);
		customUserDetailsService.createOrUpdate(club6);
	}

	private void initEvenement() {

		evenement1.setClub(club1);
		evenement1.setDateDebut(LocalDate.parse("2021-01-01"));
		evenement1.setDateFin(LocalDate.parse("2023-01-01"));
		evenement1.setNom("Evenement1");
		evenementService.createOrUpdate(evenement1);

		evenement2.setClub(club1);
		evenement2.setDateDebut(LocalDate.parse("2021-02-01"));
		evenement2.setDateFin(LocalDate.parse("2023-02-01"));
		evenement2.setNom("Evenement2");
		evenementService.createOrUpdate(evenement2);

		evenement3.setClub(club1);
		evenement3.setDateDebut(LocalDate.parse("2021-03-01"));
		evenement3.setDateFin(LocalDate.parse("2023-03-01"));
		evenement3.setNom("Evenement3");
		evenementService.createOrUpdate(evenement3);

		evenement4.setClub(club2);
		evenement4.setDateDebut(LocalDate.parse("2021-04-01"));
		evenement4.setDateFin(LocalDate.parse("2023-04-01"));
		evenement4.setNom("Evenement4");
		evenementService.createOrUpdate(evenement4);

		evenement5.setClub(club2);
		evenement5.setDateDebut(LocalDate.parse("2021-05-01"));
		evenement5.setDateFin(LocalDate.parse("2023-05-01"));
		evenement5.setNom("Evenement5");
		evenementService.createOrUpdate(evenement5);

		evenement6.setClub(club2);
		evenement6.setDateDebut(LocalDate.parse("2021-06-01"));
		evenement6.setDateFin(LocalDate.parse("2023-06-01"));
		evenement6.setNom("Evenement6");
		evenementService.createOrUpdate(evenement6);
	}

	private void initEquipe() {

		equipe1.setClub(club1);
		equipe1.setNom("Equipe1");
		equipeService.createOrUpdate(equipe1);

		equipe2.setClub(club1);
		equipe2.setNom("Equipe2");
		equipeService.createOrUpdate(equipe2);

		equipe3.setClub(club1);
		equipe3.setNom("Equipe3");
		equipeService.createOrUpdate(equipe3);

		equipe4.setClub(club2);
		equipe4.setNom("Equipe4");
		equipeService.createOrUpdate(equipe4);

		equipe5.setClub(club2);
		equipe5.setNom("Equipe5");
		equipeService.createOrUpdate(equipe5);

		equipe6.setClub(club2);
		equipe6.setNom("Equipe6");
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
	}

	private void initClubUtilisateur() {
		clubUtilisateurKey1.setClub(club1);
		clubUtilisateurKey1.setUtilisateur(utilisateur1);
		clubUtilisateur1.setClubUtilisateurKey(clubUtilisateurKey1);
		clubUtilisateur1.setDateDebut(LocalDate.parse("2020-01-01"));
		clubUtilisateur1.setDateFin(LocalDate.parse("2023-01-01"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur1);

		clubUtilisateurKey2.setClub(club1);
		clubUtilisateurKey2.setUtilisateur(utilisateur2);
		clubUtilisateur2.setClubUtilisateurKey(clubUtilisateurKey2);
		clubUtilisateur2.setDateDebut(LocalDate.parse("2020-02-01"));
		clubUtilisateur2.setDateFin(LocalDate.parse("2023-02-01"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur2);

		clubUtilisateurKey3.setClub(club1);
		clubUtilisateurKey3.setUtilisateur(utilisateur3);
		clubUtilisateur3.setClubUtilisateurKey(clubUtilisateurKey3);
		clubUtilisateur3.setDateDebut(LocalDate.parse("2020-03-01"));
		clubUtilisateur3.setDateFin(LocalDate.parse("2023-03-01"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur3);

		clubUtilisateurKey4.setClub(club2);
		clubUtilisateurKey4.setUtilisateur(utilisateur4);
		clubUtilisateur4.setClubUtilisateurKey(clubUtilisateurKey4);
		clubUtilisateur4.setDateDebut(LocalDate.parse("2020-04-01"));
		clubUtilisateur4.setDateFin(LocalDate.parse("2023-04-01"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur4);

		clubUtilisateurKey5.setClub(club2);
		clubUtilisateurKey5.setUtilisateur(utilisateur5);
		clubUtilisateur5.setClubUtilisateurKey(clubUtilisateurKey5);
		clubUtilisateur5.setDateDebut(LocalDate.parse("2020-05-01"));
		clubUtilisateur5.setDateFin(LocalDate.parse("2023-05-01"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur5);

		clubUtilisateurKey6.setClub(club2);
		clubUtilisateurKey6.setUtilisateur(utilisateur6);
		clubUtilisateur6.setClubUtilisateurKey(clubUtilisateurKey6);
		clubUtilisateur6.setDateDebut(LocalDate.parse("2020-06-01"));
		clubUtilisateur6.setDateFin(LocalDate.parse("2023-06-01"));
		clubUtilisateurService.createOrUpdate(clubUtilisateur6);
	}

	private void initEquipeUtilisateur() {
		equipeUtilisateurKey1.setEquipe(equipe1);
		equipeUtilisateurKey1.setUtilisateur(utilisateur1);
		equipeUtilisateur1.setEquipeUtilisateurKey(equipeUtilisateurKey1);
		equipeUtilisateur1.setDateDebut(LocalDate.parse("2020-01-01"));
		equipeUtilisateur1.setDateFin(LocalDate.parse("2023-01-01"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur1);

		equipeUtilisateurKey2.setEquipe(equipe1);
		equipeUtilisateurKey2.setUtilisateur(utilisateur2);
		equipeUtilisateur2.setEquipeUtilisateurKey(equipeUtilisateurKey2);
		equipeUtilisateur2.setDateDebut(LocalDate.parse("2020-02-01"));
		equipeUtilisateur2.setDateFin(LocalDate.parse("2023-02-01"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur2);

		equipeUtilisateurKey3.setEquipe(equipe2);
		equipeUtilisateurKey3.setUtilisateur(utilisateur3);
		equipeUtilisateur3.setEquipeUtilisateurKey(equipeUtilisateurKey3);
		equipeUtilisateur3.setDateDebut(LocalDate.parse("2020-03-01"));
		equipeUtilisateur3.setDateFin(LocalDate.parse("2023-03-01"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur3);

		equipeUtilisateurKey4.setEquipe(equipe2);
		equipeUtilisateurKey4.setUtilisateur(utilisateur4);
		equipeUtilisateur4.setEquipeUtilisateurKey(equipeUtilisateurKey4);
		equipeUtilisateur4.setDateDebut(LocalDate.parse("2020-04-01"));
		equipeUtilisateur4.setDateFin(LocalDate.parse("2023-04-01"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur4);

		equipeUtilisateurKey5.setEquipe(equipe3);
		equipeUtilisateurKey5.setUtilisateur(utilisateur5);
		equipeUtilisateur5.setEquipeUtilisateurKey(equipeUtilisateurKey5);
		equipeUtilisateur5.setDateDebut(LocalDate.parse("2020-05-01"));
		equipeUtilisateur5.setDateFin(LocalDate.parse("2023-05-01"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur5);

		equipeUtilisateurKey6.setEquipe(equipe3);
		equipeUtilisateurKey6.setUtilisateur(utilisateur6);
		equipeUtilisateur6.setEquipeUtilisateurKey(equipeUtilisateurKey6);
		equipeUtilisateur6.setDateDebut(LocalDate.parse("2020-06-01"));
		equipeUtilisateur6.setDateFin(LocalDate.parse("2023-06-01"));
		equipeUtilisateurService.createOrUpdate(equipeUtilisateur6);

	}

	private void initEvenementUtilisateur() {
		evenementUtilisateurKey1.setEvenement(evenement1);
		evenementUtilisateurKey1.setUtilisateur(utilisateur1);
		evenementUtilisateur1.setId(evenementUtilisateurKey1);
		evenementUtilisateur1.setDateDebut(evenement1.getDateDebut());
		evenementUtilisateur1.setDateFin(evenement1.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur1);

		evenementUtilisateurKey2.setEvenement(evenement2);
		evenementUtilisateurKey2.setUtilisateur(utilisateur1);
		evenementUtilisateur2.setId(evenementUtilisateurKey2);
		evenementUtilisateur2.setDateDebut(evenement2.getDateDebut());
		evenementUtilisateur2.setDateFin(evenement2.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur2);

		evenementUtilisateurKey3.setEvenement(evenement3);
		evenementUtilisateurKey3.setUtilisateur(utilisateur2);
		evenementUtilisateur3.setId(evenementUtilisateurKey3);
		evenementUtilisateur3.setDateDebut(evenement3.getDateDebut());
		evenementUtilisateur3.setDateFin(evenement3.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur3);

		evenementUtilisateurKey4.setEvenement(evenement3);
		evenementUtilisateurKey4.setUtilisateur(utilisateur3);
		evenementUtilisateur4.setId(evenementUtilisateurKey4);
		evenementUtilisateur4.setDateDebut(evenement3.getDateDebut());
		evenementUtilisateur4.setDateFin(evenement3.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur4);

		evenementUtilisateurKey5.setEvenement(evenement4);
		evenementUtilisateurKey5.setUtilisateur(utilisateur4);
		evenementUtilisateur5.setId(evenementUtilisateurKey5);
		evenementUtilisateur5.setDateDebut(evenement4.getDateDebut());
		evenementUtilisateur5.setDateFin(evenement4.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur5);

		evenementUtilisateurKey6.setEvenement(evenement5);
		evenementUtilisateurKey6.setUtilisateur(utilisateur5);
		evenementUtilisateur6.setId(evenementUtilisateurKey6);
		evenementUtilisateur6.setDateDebut(evenement5.getDateDebut());
		evenementUtilisateur6.setDateFin(evenement5.getDateFin());
		evenementUtilisateurService.createOrUpdate(evenementUtilisateur6);
	}

}
