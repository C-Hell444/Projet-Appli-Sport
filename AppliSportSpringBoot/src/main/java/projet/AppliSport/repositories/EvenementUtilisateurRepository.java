package projet.AppliSport.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Evenement;
import projet.AppliSport.model.EvenementUtilisateur;
import projet.AppliSport.model.EvenementUtilisateurKey;
import projet.AppliSport.model.Utilisateur;

public interface EvenementUtilisateurRepository extends JpaRepository<EvenementUtilisateur, EvenementUtilisateurKey>{
	List<EvenementUtilisateur> findByDateDebut(LocalDate dateDebut);
	List<EvenementUtilisateur> findByDateFin(LocalDate dateFin);
	Optional<EvenementUtilisateur> findById(EvenementUtilisateurKey id);
	@Query("select u from EvenementUtilisateur u left join fetch u.id.evenement where u.id=:id")
	Optional<EvenementUtilisateur> findByIdWithEvenement(@Param("id") Long id);

	
	@Transactional
	@Modifying
	@Query("delete from EvenementUtilisateur e where e.id.utilisateur=:utilisateur")
	void deleteEvenementUtilisateurByUtilisateur(@Param("utilisateur") Utilisateur utilisateur);
	
	
	@Transactional
	@Modifying
	@Query("delete from EvenementUtilisateur e where e.id.evenement=:evenement")
	void deleteEvenementUtilisateurByEvenement(@Param("evenement") Evenement evenement);
	
}
