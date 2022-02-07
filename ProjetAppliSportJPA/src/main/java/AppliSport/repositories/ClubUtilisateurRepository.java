package AppliSport.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AppliSport.model.ClubUtilisateur;
import AppliSport.model.ClubUtilisateurKey;


public interface ClubUtilisateurRepository extends JpaRepository<ClubUtilisateur, ClubUtilisateurKey>{
	
	List<ClubUtilisateur> findByDateDebut(LocalDate dateDebut);
	List<ClubUtilisateur> findByDateFin(LocalDate dateFin);
	@Query("select u from Utilisateur u left join fetch Club where u.id=:id")
	Optional<ClubUtilisateur> findByIdWithClub(@Param("id") Long id);
	Optional<ClubUtilisateur> findByClubAndUtilisateur(Long id1,Long id2);
	
	
}
