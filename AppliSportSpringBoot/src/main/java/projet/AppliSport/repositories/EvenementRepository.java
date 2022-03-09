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
import projet.AppliSport.model.Profil;

public interface EvenementRepository extends JpaRepository<Evenement, Long>{
	
	
	List<Evenement> findByNom(String nom);
	List<Evenement> findByClub(Club club);
	@Query("select e from Evenement e where e.club.clubNom=:nom")
	List<Evenement> findByClubNom(@Param("nom")String nom);

	
	List<Evenement> findByDateDebutGreaterThanEqual(LocalDate date);
	
	List<Evenement> findByDateFinLessThanEqual(LocalDate date);
	
	List<Evenement> findAllByOrderById();
	List<Evenement> findAllByOrderByNom();
	List<Evenement> findAllByOrderByClub();
	List<Evenement> findAllByOrderByDateDebut();
	List<Evenement> findAllByOrderByDateFin();
	
	
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
	
	@Query("select e from Evenement e left join e.club where e.id=:id")
	Optional<Evenement> findByIdWithClub(@Param("id") Long id);
	

}
