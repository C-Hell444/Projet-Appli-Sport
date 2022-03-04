package projet.AppliSport.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Caracteristique;
import projet.AppliSport.model.Profil;
import projet.AppliSport.model.Sexe;
import projet.AppliSport.model.Utilisateur;

public interface ProfilRepository extends JpaRepository<Profil, Long>{


	// ===================  Attribut poids ======================== //
	List<Profil> findByPoids(double poids);
	List<Profil> findByPoidsGreaterThanEqual(double poids);
	List<Profil> findByPoidsLessThan(double poids);
	
	// ===================  Attribut taille ======================== //
	List<Profil> findByTaille(double taille);
	List<Profil> findByTailleGreaterThanEqual(double taille);
	List<Profil> findByTailleLessThan(double taille);
	
	// ===================  Attribut date de naissance ======================== //
	List<Profil> findByDateNaissance (LocalDate dateNaissance);
	List<Profil> findByDateNaissanceGreaterThanEqual(LocalDate dateNaissance);
	List<Profil> findByDateNaissanceLessThan(LocalDate dateNaissance);
	
	// ===================  Attribut sexe ======================== //
	List<Profil> findBySexe(Sexe sexe);
	
	// ===================  Attribut caracteristique ======================== //
	@Query("select p from Profil p left join fetch p.caracteristique where p.id=:id")
	Optional<Profil> findByIdCaracteristique(@Param("id") Long id);
	
	// ===================  Attribut utilisateur ======================== //
	@Query("select p from Profil p left join fetch p.utilisateur where p.id=:id")
	Optional<Profil> findByIdWithUtilisateur(@Param("id") Long id);
	


	
	@Transactional
	@Modifying
	@Query("delete from Profil p where p.utilisateur=:utilisateur")
	void deleteProfilByUtilisateur(@Param("utilisateur") Utilisateur utilisateur);
	
	
	@Transactional
	@Modifying
	@Query("update Profil p set p.caracteristique=null where p.caracteristique=:caracteristique")
	void setCaracteristiqueToNull(@Param("caracteristique") Caracteristique caracteristique);
	
	

}
