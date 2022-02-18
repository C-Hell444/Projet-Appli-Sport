package projet.AppliSport.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Caracteristique;


public interface CaracteristiqueRepository extends JpaRepository<Caracteristique, Long> {

	// =================== Attribut collectif ======================== //
	List<Caracteristique> findByCollectif(int collectif);
	List<Caracteristique> findByCollectifGreaterThanEqual(int collectif);
	List<Caracteristique> findByCollectifLessThan(int collectif);
	
	// =================== Attribut creativite ======================== //
	List<Caracteristique> findByCreativite(int creativite);
	List<Caracteristique> findByCreativiteGreaterThanEqual(int creativite);
	List<Caracteristique> findByCreativiteLessThan(int creativite);
	
	// =================== Attribut determination ======================== //
	List<Caracteristique> findByDetermination(int determination);
	List<Caracteristique> findByDeterminationGreaterThanEqual(int determination);
	List<Caracteristique> findByDeterminationLessThan(int determination);

	// =================== Attribut patience ======================== //
	List<Caracteristique> findByPatience(int patience);
	List<Caracteristique> findByPatienceGreaterThanEqual(int patience);
	List<Caracteristique> findByPatienceLessThan(int patience);

	// =================== Attribut detente ======================== //
	List<Caracteristique> findByDetente(int detente);
	List<Caracteristique> findByDetenteGreaterThanEqual(int detente);
	List<Caracteristique> findByDetenteLessThan(int detente);

	// =================== Attribut agilite ======================== //
	List<Caracteristique> findByAgilite(int agilite);
	List<Caracteristique> findByAgiliteGreaterThanEqual(int agilite);
	List<Caracteristique> findByAgiliteLessThan(int agilite);

	// =================== Attribut puissance ======================== //
	List<Caracteristique> findByPuissance(int puissance);
	List<Caracteristique> findByPuissanceGreaterThanEqual(int puissance);
	List<Caracteristique> findByPuissanceLessThan(int puissance);

	// =================== Attribut vitesse ======================== //
	List<Caracteristique> findByVitesse(int vitesse);
	List<Caracteristique> findByVitesseGreaterThanEqual(int vitesse);
	List<Caracteristique> findByVitesseLessThan(int vitesse);

	// =================== Attribut endurance ======================== //
	List<Caracteristique> findByEndurance(int endurance);
	List<Caracteristique> findByEnduranceGreaterThanEqual(int endurance);
	List<Caracteristique> findByEnduranceLessThan(int endurance);
	
	// =================== Attribut profil ======================== //
	
	@Query("select c from Caracteristique c left join fetch c.profil where c.id=:id")
	Optional<Caracteristique> findByIdProfil(@Param("id") Long id);

}
