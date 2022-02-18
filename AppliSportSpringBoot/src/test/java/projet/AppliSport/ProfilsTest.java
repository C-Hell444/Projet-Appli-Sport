package projet.AppliSport;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import projet.AppliSport.model.Caracteristique;
import projet.AppliSport.model.Interet;
import projet.AppliSport.model.Profil;
import projet.AppliSport.services.CaracteristiqueService;
import projet.AppliSport.services.InteretService;
import projet.AppliSport.services.ProfilService;

@SpringBootTest
class ProfilsTest {

	@Autowired
	private ProfilService profilService;
	@Autowired
	private InteretService interetService;
	@Autowired
	private CaracteristiqueService caracteristiqueService;

	@Test
	@Transactional
	@Commit
	void testProfilsGetAll() {
		Profil p1 = new Profil();
		Interet i1 = new Interet();
		Caracteristique c1 = new Caracteristique();
		Profil p2 = new Profil();
		Interet i2 = new Interet();
		Caracteristique c2 = new Caracteristique();
		profilService.getAll();
		interetService.getAll();
		caracteristiqueService.getAll();
	}

	@Test
	@Transactional
	@Commit
	void testProfilsById() {
		Profil a = new Profil();
		Interet c = new Interet();
		Caracteristique u = new Caracteristique();
		profilService.getById(a.getId());
		interetService.getById(c.getId());
		caracteristiqueService.getById(u.getId());
	}

	@Test
	@Transactional
	@Commit
	void testProfilsCreateOrUpdate() {
		Profil a = new Profil();
		Interet c = new Interet();
		Caracteristique u = new Caracteristique();
		profilService.createOrUpdate(a);
		interetService.createOrUpdate(c);
		caracteristiqueService.createOrUpdate(u);
	}

	@Test
	@Transactional
	@Commit
	void testProfilsnDeleteById() {
		Profil a = new Profil();
		Interet c = new Interet();
		Caracteristique u = new Caracteristique();
		profilService.createOrUpdate(a);
		interetService.createOrUpdate(c);
		caracteristiqueService.createOrUpdate(u);
	}

}
