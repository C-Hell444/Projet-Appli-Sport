package AppliSport.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AppliSport.model.Caracteristique;
import AppliSport.model.Profil;
import AppliSport.model.Sexe;

public interface ProfilRepository extends JpaRepository<Profil, Long>{


	// ===================  Attribut poids ======================== //
	List<Profil> findByPoids(double poids);
	List<Profil> findByGreaterThanEqualsValeurPoids(double poids);
	List<Profil> findByLesserThanValeurPoids(double poids);
	
	// ===================  Attribut taille ======================== //
	List<Profil> findByTaille(double taille);
	List<Profil> findByGreaterThanEqualsValeurTaille(double taille);
	List<Profil> findByLesserThanValeurTaille(double taille);
	
	// ===================  Attribut date de naissance ======================== //
	List<Profil> findByNaissance (LocalDate dateNaissance);
	List<Profil> findByGreaterThanEqualsValeurDateNaissance(LocalDate dateNaissance);
	List<Profil> findByLesserThanValeurDateNaissance(LocalDate dateNaissance);
	
	// ===================  Attribut sexe ======================== //
	List<Profil> findBySexe(Sexe sexe);
	
	// ===================  Attribut caracteristique ======================== //
	@Query("select p from Profil p left join fetch p.caracteristique where p.id=:id")
	Optional<Profil> findByIdCaracteristique(@Param("id") Long id);
	
	// ===================  Attribut utilisateur ======================== //
	@Query("select p from Profil p left join fetch p.utilisateur where p.id=:id")
	Optional<Profil> findByIdUtilisateur(@Param("id") Long id);
	
}
