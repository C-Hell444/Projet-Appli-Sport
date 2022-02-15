package AppliSport.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AppliSport.model.Adresse;
import AppliSport.model.Club;
import AppliSport.model.Equipe;
import AppliSport.model.Evenement;
import AppliSport.model.Interet;
import AppliSport.model.Profil;
import AppliSport.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	List<Utilisateur> findByNom(String nom);
	
	List<Utilisateur> findByNomLike(String nom);
	
	List<Utilisateur> findByNomStartingWith (String nom);
	
	List<Utilisateur> findByNomContaining(String nom);
	
	
	
	Optional<Utilisateur> findByNumTel(String numTel);
	
	List<Utilisateur> findByNumTelStartingWith(String numTel);
	
	
	
	Optional<Utilisateur> findByAdresse(Adresse adresse);
	
	
	
	Optional<Utilisateur> findByProfilUtilisateur(Profil profilUtilisateur);
	
	@Query("select u from Utilisateur u left join fetch Profil p where p.id=:id")
	Optional<Utilisateur> findByIdProfilUtilisateur(@Param("id") Long id);
	
	
	
	@Query("select u from Utilisateur u left join fetch ClubUtilisateur c where c.id.club=:id")
	List<Utilisateur> findUtilisateurWithClubId(@Param("id") Long id);
	
	
	
	@Query("select u from Utilisateur u left join fetch EvenementUtilisateur e where e.id.evenement=:id")
	List<Utilisateur> findUtilisateurWithEvenementId(@Param("id") Long id);
	
	
	
	@Query("select u from Utilisateur u left join fetch EquipeUtilisateur e where e.id.equipe=:id")
	List<Utilisateur> findUtilisateurWithEquipeId(@Param("id") Long id);
	
	
	
	@Query("select u from Utilisateur u left join fetch Interet i where i.id=:id")
	List<Utilisateur> findUtilisateurWithInteretId(@Param("id") Long id);
	
	
	
	
	
	
}
