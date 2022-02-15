package AppliSport.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AppliSport.model.Adresse;
import AppliSport.model.Club;
import AppliSport.model.Sport;

public interface ClubRepository extends JpaRepository<Club, Long>{

	
	List<Club> findByAdresse(Adresse adresse);
	List<Club> findByNumTel(String num);
	List<Club> findByClubNom(String nom);
	List<Club> findBySportClub(Sport sport);
	

}
