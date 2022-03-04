package projet.AppliSport;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import projet.AppliSport.model.Club;
import projet.AppliSport.model.ClubUtilisateur;
import projet.AppliSport.model.ClubUtilisateurKey;
import projet.AppliSport.model.Equipe;
import projet.AppliSport.model.EquipeUtilisateur;
import projet.AppliSport.model.EquipeUtilisateurKey;
import projet.AppliSport.model.Evenement;
import projet.AppliSport.model.EvenementUtilisateur;
import projet.AppliSport.model.EvenementUtilisateurKey;
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.services.ClubService;
import projet.AppliSport.services.ClubUtilisateurService;
import projet.AppliSport.services.EquipeService;
import projet.AppliSport.services.EquipeUtilisateurService;
import projet.AppliSport.services.EvenementService;
import projet.AppliSport.services.EvenementUtilisateurService;
import projet.AppliSport.services.UtilisateurService;

@SpringBootTest
class RelationsTest {

	@Autowired
	private EvenementService evenementService;
	@Autowired
	private UtilisateurService utilisateurService;
	@Autowired
	private ClubService clubService;
	@Autowired
	private EvenementUtilisateurService evenementUtilisateurService;
	@Autowired
	private EquipeService equipeService;
	@Autowired
	private EquipeUtilisateurService equipeUtilisateurService;
	@Autowired
	private ClubUtilisateurService clubUtilisateurService;

	@Test
	@Transactional
	@Commit
	void testRelationsGetAll() {
		Evenement ev1 = new Evenement();
		EvenementUtilisateur evu1 = new EvenementUtilisateur();
		Equipe eq1 = new Equipe();
		EquipeUtilisateur equ1 = new EquipeUtilisateur();
		ClubUtilisateur cu1 = new ClubUtilisateur();
		Evenement ev2 = new Evenement();
		EvenementUtilisateur evu2 = new EvenementUtilisateur();
		Equipe eq2 = new Equipe();
		EquipeUtilisateur equ2 = new EquipeUtilisateur();
		ClubUtilisateur cu2 = new ClubUtilisateur();

		evenementService.getAll();
		evenementUtilisateurService.getAll();
		equipeService.getAll();
		equipeUtilisateurService.getAll();
		clubUtilisateurService.getAll();
	}

	@Test
	@Transactional
	@Commit
	void testRelationsId() {
		Evenement ev = new Evenement();
		EvenementUtilisateur evu = new EvenementUtilisateur();
		Equipe eq = new Equipe();
		EquipeUtilisateur equ = new EquipeUtilisateur();
		ClubUtilisateur cu = new ClubUtilisateur();
		evenementService.getById(ev.getId());
		evenementUtilisateurService.getById(evu.getId());
		equipeService.getById(eq.getId());
		equipeUtilisateurService.getById(equ.getEquipeUtilisateurKey());
		clubUtilisateurService.getById(cu.getClubUtilisateurKey());
	}

	@Test
	@Transactional
	@Commit
	void testRelationsCreateOrUpdate() {
		Evenement ev = new Evenement();
		ev.setNom("testEv");
		Utilisateur u = new Utilisateur("toto", "toto", "toto@toto.com", "toto", "toto", "0000000007");
		Club c = new Club("tata", "tata", "tata@tata.com", "0000000008", "tata");
		Equipe eq = new Equipe();
		eq.setNom("tutu");
		EvenementUtilisateur evu = new EvenementUtilisateur(new EvenementUtilisateurKey(u, ev));
		EquipeUtilisateur equ = new EquipeUtilisateur(new EquipeUtilisateurKey(u, eq));
		ClubUtilisateur cu = new ClubUtilisateur(new ClubUtilisateurKey(u, c));
		evenementService.createOrUpdate(ev);
		equipeService.createOrUpdate(eq);
		utilisateurService.createOrUpdate(u);
		clubService.createOrUpdate(c);
		evenementUtilisateurService.createOrUpdate(evu);
		equipeUtilisateurService.createOrUpdate(equ);
		clubUtilisateurService.createOrUpdate(cu);
	}

	@Test
	@Transactional
	@Commit
	void testRelationsnDeleteById() {
		Evenement ev = new Evenement();
		EvenementUtilisateur evu = new EvenementUtilisateur();
		Equipe eq = new Equipe();
		EquipeUtilisateur equ = new EquipeUtilisateur();
		ClubUtilisateur cu = new ClubUtilisateur();
		evenementService.deleteById(ev.getId());
		evenementUtilisateurService.deleteById(evu.getId());
		equipeService.deleteById(eq.getId());
		equipeUtilisateurService.deleteById(equ.getEquipeUtilisateurKey());
		clubUtilisateurService.deleteById(cu.getClubUtilisateurKey());
	}

}
