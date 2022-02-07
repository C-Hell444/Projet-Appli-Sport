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
	
	@Query("select c from Club c left join fetch c.listeMembre where c.id=:id")
	Optional<Club> findByIdWithListeMembre(@Param("id") Long id);

	@Query("select c from Club c left join fetch c.equipes where c.id=:id")
	Optional<Club> findByIdWithEquipe(@Param("id") Long id);

	@Query("select c from Club c left join fetch c.evenements where c.id=:id")
	Optional<Club> findByIdWithEvenements(@Param("id") Long id);
}
