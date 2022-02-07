package AppliSport.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import AppliSport.model.ClubUtilisateur;
import AppliSport.model.EquipeUtilisateur;
import AppliSport.model.EquipeUtilisateurKey;

public interface EquipeUtilisateurRepository extends JpaRepository<EquipeUtilisateur, EquipeUtilisateurKey>{
	List<EquipeUtilisateur> findByDateDebut(LocalDate dateDebut);
	List<EquipeUtilisateur> findByDateFin(LocalDate dateFin);
	Optional<EquipeUtilisateur> findById(EquipeUtilisateurKey id);
	List<EquipeUtilisateur> findAll();
	List<EquipeUtilisateur> findByUtilisateurAndEquipe(Long id);

}
