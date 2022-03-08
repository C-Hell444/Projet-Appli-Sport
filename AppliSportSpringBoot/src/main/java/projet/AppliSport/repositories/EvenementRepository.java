package projet.AppliSport.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Club;
import projet.AppliSport.model.Equipe;
import projet.AppliSport.model.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long>{
	
	// ===================  Attribut identifiant ======================== //
	List<Evenement> findByNom(String nom);
	List<Evenement> findByIdOrNom(Long id, String nom);
	
	// ===================  Attribut date ======================== //
	List<Evenement> findByDateDebut(LocalDate dateDebut);
	List<Evenement> findByDateFin(LocalDate dateFin);
	
	// ===================  Attribut club ======================== //
	List<Evenement> findByClub(Club club);
	
	@Query("select e from Evenement e left join fetch e.participants where e.id=:id")
	Optional<Evenement> findByIdWithUtilisateur(Long id);
	
	@Query("select e from Evenement e left join fetch e.participants p where e.id=:id order by p.dateDebut asc")
	Optional<Evenement> findByIdWithEvenementUtilisateurOrderByDateDebutAsc(@Param("id") Long id);
	
	@Query("select e from Evenement e left join fetch e.participants p where e.id=:id order by p.dateDebut desc")
	Optional<Evenement> findByIdWithEvenementUtilisateurOrderByDateDebutDesc(@Param("id") Long id);
	
	@Query("select e from Evenement e left join fetch e.participants p where e.id=:id order by p.dateFin asc")
	Optional<Evenement> findByIdWithEvenementUtilisateurOrderByDateFinAsc(@Param("id") Long id);
	
	@Query("select e from Evenement e left join fetch e.participants p where e.id=:id order by p.dateFin desc")
	Optional<Evenement> findByIdWithEvenementUtilisateurOrderByDateFinDesc(@Param("id") Long id);
	

}
