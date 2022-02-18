package projet.AppliSport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.AppliSport.model.Adresse;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Sport;

public interface ClubRepository extends JpaRepository<Club, Long>{

	
	List<Club> findByAdresse(Adresse adresse);
	List<Club> findByNumTel(String num);
	List<Club> findByClubNom(String nom);
	List<Club> findBySportClub(Sport sport);
	

}
