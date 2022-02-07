package AppliSport.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AppliSport.model.Club;
import AppliSport.model.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long>{

	List<Evenement> findByNom(String nom);
	
	List<Evenement> findByIdOrNom(Long id, String nom);
	
	List<Evenement> findByDateDebut(LocalDate dateDebut);
	
	List<Evenement> findByDateFin(LocalDate dateFin);
	
	List<Evenement> findByClub(Club club);

}
