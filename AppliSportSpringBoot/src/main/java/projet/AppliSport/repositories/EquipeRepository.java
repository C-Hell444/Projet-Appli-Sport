package projet.AppliSport.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Club;
import projet.AppliSport.model.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

	
	
	List<Equipe> findByNom(String nom);
	List<Equipe> findByClub(Club club);
	@Query("select e from Equipe e where e.club.clubNom=:nom")
	List<Equipe> findByClubNom(@Param("nom")String nom);
	
	List<Equipe> findAllByOrderById();
	List<Equipe> findAllByOrderByNom();
	List<Equipe> findAllByOrderByClub();
	
	
	@Query("select e from Equipe e left join e.club where e.id=:id")
	Optional<Equipe> findByIdWithClub(@Param("id") Long id);
	
	
	
	@Query("select e from Equipe e left join fetch e.equipe where e.id=:id")
	Optional<Equipe> findByIdWithUtilisateur(@Param("id") Long id);
	
	@Query("select e from Equipe e left join fetch e.equipe m where e.id=:id order by m.dateDebut asc")
	Optional<Equipe> findByIdWithEquipeUtilisateurOrderByDateDebutAsc(@Param("id") Long id);
	
	@Query("select e from Equipe e left join fetch e.equipe m where e.id=:id order by m.dateDebut desc")
	Optional<Equipe> findByIdWithEquipeUtilisateurOrderByDateDebutDesc(@Param("id") Long id);
	
	@Query("select e from Equipe e left join fetch e.equipe m where e.id=:id order by m.dateFin asc")
	Optional<Equipe> findByIdWithEquipeUtilisateurOrderByDateFinAsc(@Param("id") Long id);
	
	@Query("select e from Equipe e left join fetch e.equipe m where e.id=:id order by m.dateFin desc")
	Optional<Equipe> findByIdWithEquipeUtilisateurOrderByDateFinDesc(@Param("id") Long id);
	
	
}