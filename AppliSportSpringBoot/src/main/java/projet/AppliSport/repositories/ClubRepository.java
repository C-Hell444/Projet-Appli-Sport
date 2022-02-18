package projet.AppliSport.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Adresse;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Sport;

public interface ClubRepository extends JpaRepository<Club, Long>{

	
	List<Club> findByAdresse(Adresse adresse);
	List<Club> findByNumTel(String num);
	List<Club> findByClubNom(String nom);
	List<Club> findBySportClub(Sport sport);
	
	@Transactional
	@Modifying
	@Query("update Club c set c.sportClub=null where c.sportClub=:sport")
	void setSportToNull(@Param("sport") Sport sport);

}
