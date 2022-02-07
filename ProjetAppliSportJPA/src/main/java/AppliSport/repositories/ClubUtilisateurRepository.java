package AppliSport.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import AppliSport.model.ClubUtilisateur;
import AppliSport.model.ClubUtilisateurKey;

public interface ClubUtilisateurRepository extends JpaRepository<ClubUtilisateur, ClubUtilisateurKey>{
	
	List<ClubUtilisateur> findByDateDebut(LocalDate dateDebut);
	List<ClubUtilisateur> findByDateFin(LocalDate dateFin);
	@Override
	Optional<ClubUtilisateur> findById(ClubUtilisateurKey id);
	@Override
	List<ClubUtilisateur> findAll();
	List<ClubUtilisateur> findByUtilisateurAndClub(Long id);
	
}
