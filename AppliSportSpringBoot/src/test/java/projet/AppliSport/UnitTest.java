package projet.AppliSport;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import projet.AppliSport.model.Club;
import projet.AppliSport.services.ClubService;

@SpringBootTest
class UnitTest {

	@Autowired
	private ClubService clubService;

	@Test
	@Transactional
	@Commit
	void testProfilsById() {
		Club c = new Club();
		clubService.getById(c.getId());
	}

}
