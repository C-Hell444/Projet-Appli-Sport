package projet.AppliSport.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Club;
import projet.AppliSport.model.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

	// =================== Attribut identifiant ======================== //
	List<Equipe> findByNom(String nom);

	List<Equipe> findByIdOrNom(Long id, String nom);

	// =================== Attribut club ======================== //

	List<Equipe> findByClub(Club c);

	
	@Query("select e from Equipe e left join fetch e.equipe where e.id=:id")
	Optional<Equipe> findByIdWithUtilisateur(@Param("id") Long id);
}