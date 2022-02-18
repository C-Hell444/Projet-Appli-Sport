package projet.AppliSport.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Evenement;
import projet.AppliSport.model.Profil;

public interface EvenementRepository extends JpaRepository<Evenement, Long>{
	
	// ===================  Attribut identifiant ======================== //
	List<Evenement> findByNom(String nom);
	List<Evenement> findByIdOrNom(Long id, String nom);
	
	// ===================  Attribut date ======================== //
	List<Evenement> findByDateDebut(LocalDate dateDebut);
	List<Evenement> findByDateFin(LocalDate dateFin);
	
	// ===================  Attribut club ======================== //
	@Query("select e from Evenement e left join fetch e.club.id where e.club.id=:id")
	List<Evenement> findByIdClub(@Param("id") Long id);

}
