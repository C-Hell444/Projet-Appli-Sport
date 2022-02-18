package projet.AppliSport.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.AppliSport.model.Club;
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

}
