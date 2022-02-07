package AppliSport.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AppliSport.model.ClubUtilisateur;
import AppliSport.model.EvenementUtilisateur;
import AppliSport.model.EvenementUtilisateurKey;

public interface EvenementUtilisateurRepository extends JpaRepository<EvenementUtilisateur, EvenementUtilisateurKey>{
	List<EvenementUtilisateur> findByDateDebut(LocalDate dateDebut);
	List<EvenementUtilisateur> findByDateFin(LocalDate dateFin);
	Optional<EvenementUtilisateur> findById(EvenementUtilisateurKey id);
	@Query("select u from Utilisateur u left join fetch evenement where u.id=:id")
	Optional<EvenementUtilisateur> findByIdWithEvenement(@Param("id") Long id);

}
