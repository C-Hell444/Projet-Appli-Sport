package AppliSport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AppliSport.model.Club;
import AppliSport.model.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

	List<Equipe> findByNom(String nom);

	List<Equipe> findByIdOrNom(Long id, String nom);

	List<Equipe> findByClub(Club club);

}