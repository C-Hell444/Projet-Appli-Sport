package projet.AppliSport.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Club;
import projet.AppliSport.model.ClubUtilisateur;
import projet.AppliSport.model.ClubUtilisateurKey;
import projet.AppliSport.model.Utilisateur;


public interface ClubUtilisateurRepository extends JpaRepository<ClubUtilisateur, ClubUtilisateurKey>{
	
	List<ClubUtilisateur> findByDateDebut(LocalDate dateDebut);
	List<ClubUtilisateur> findByDateFin(LocalDate dateFin);
	@Query("select u from ClubUtilisateur u left join fetch u.id.club where u.id=:id")
	Optional<ClubUtilisateur> findByIdWithClub(@Param("id") Long id);

	
	@Transactional
	@Modifying
	@Query("delete from ClubUtilisateur c where c.id.utilisateur=:utilisateur")
	void deleteClubUtilisateurByUtilisateur(@Param("utilisateur") Utilisateur utilisateur);
	
	
	@Transactional
	@Modifying
	@Query("delete from ClubUtilisateur c where c.id.club=:club")
	void deleteClubUtilisateurByClub(@Param("club") Club club);
	
	
	
	
}
