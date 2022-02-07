package AppliSport.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AppliSport.model.Club;
import AppliSport.model.Equipe;
import AppliSport.model.Profil;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

	
	// ===================  Attribut identifiant ======================== //
	List<Equipe> findByNom(String nom);

	List<Equipe> findByIdOrNom(Long id, String nom);

	// ===================  Attribut club ======================== //

	@Query("select e from Equipe e left join fetch e.club where e.id=:id")
	Optional<Profil> findByIdClub(@Param("id") Long id);
	

}