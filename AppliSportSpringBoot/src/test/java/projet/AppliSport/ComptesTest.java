package projet.AppliSport;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import projet.AppliSport.model.Admin;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.services.AdminService;
import projet.AppliSport.services.ClubService;
import projet.AppliSport.services.UtilisateurService;

@SpringBootTest
class ComptesTest {

	@Autowired
	private AdminService adminService;
	@Autowired
	private ClubService clubService;
	@Autowired
	private UtilisateurService utilisateurService;

	@Test
	@Transactional
	@Commit
	void testComptesGetAll() {
		Admin a1 = new Admin();
		Club c1 = new Club();
		Utilisateur u1 = new Utilisateur();
		Admin a2 = new Admin();
		Club c2 = new Club();
		Utilisateur u2 = new Utilisateur();
		adminService.getAll();
		clubService.getAll();
		utilisateurService.getAll();
	}

	@Test
	@Transactional
	@Commit
	void testComptesById() {
		Admin a = new Admin();
		Club c = new Club();
		Utilisateur u = new Utilisateur();
		adminService.getById(a.getId());
		clubService.getById(c.getId());
		utilisateurService.getById(u.getId());
	}

	@Test
	@Transactional
	@Commit
	void testComptesCreateOrUpdate() {
		Admin a = new Admin();
		Club c = new Club();
		Utilisateur u = new Utilisateur();
		adminService.createOrUpdate(a);
		clubService.createOrUpdate(c);
		utilisateurService.createOrUpdate(u);
	}

	@Test
	@Transactional
	@Commit
	void testComptesnDeleteById() {
		Admin a = new Admin();
		Club c = new Club();
		Utilisateur u = new Utilisateur();
		adminService.createOrUpdate(a);
		clubService.createOrUpdate(c);
		utilisateurService.createOrUpdate(u);
	}

}
