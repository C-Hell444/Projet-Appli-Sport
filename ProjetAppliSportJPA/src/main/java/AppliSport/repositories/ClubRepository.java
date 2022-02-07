package AppliSport.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AppliSport.model.Adresse;
import AppliSport.model.Club;
import AppliSport.model.Sport;

public interface ClubRepository extends JpaRepository<Club, Long>{

	
	Club findByAdresse(Adresse adresse);
	Club findByNumTel(String num);
	Club findByClubNom(String nom);
	Club findBySportClub(Sport sport);
	
	@Query("select c from Club c left join fetch c.listeMembre where c.id=:id")
	Optional<Club> findByIdWithListeMembre(@Param("id") Long id);

	@Query("select c from Club c left join fetch c.equipes where c.id=:id")
	Optional<Club> findByIdWithEquipe(@Param("id") Long id);

	@Query("select c from Club c left join fetch c.evenements where c.id=:id")
	Optional<Club> findByIdWithEvenements(@Param("id") Long id);
}
