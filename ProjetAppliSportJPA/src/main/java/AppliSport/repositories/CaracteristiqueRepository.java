package AppliSport.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import AppliSport.model.Caracteristique;


public interface CaracteristiqueRepository extends JpaRepository<Caracteristique, Long> {

	// =================== Attribut collectif ======================== //
	List<Caracteristique> findByValeurCollectif(int collectif);
	List<Caracteristique> findByGreaterThanEqualsValeurCollectif(int collectif);
	List<Caracteristique> findByLesserThanValeurCollectif(int collectif);
	
	// =================== Attribut creativite ======================== //
	List<Caracteristique> findByValeurCreativite(int creativite);
	List<Caracteristique> findByGreaterThanEqualsValeurCreativite(int creativite);
	List<Caracteristique> findByLesserThanValeurCreativite(int creativite);
	
	// =================== Attribut determination ======================== //
	List<Caracteristique> findByValeurDetermination(int determination);
	List<Caracteristique> findByGreaterThanEqualsValeurDetermination(int determination);
	List<Caracteristique> findByLesserThanValeurDetermination(int determination);

	// =================== Attribut patience ======================== //
	List<Caracteristique> findByValeurPatience(int patience);
	List<Caracteristique> findByGreaterThanEqualsValeurPatience(int patience);
	List<Caracteristique> findByLesserThanValeurPatience(int patience);

	// =================== Attribut detente ======================== //
	List<Caracteristique> findByValeurDetente(int detente);
	List<Caracteristique> findByGreaterThanEqualsValeurDetente(int detente);
	List<Caracteristique> findByLesserThanValeurDetente(int detente);

	// =================== Attribut agilite ======================== //
	List<Caracteristique> findByValeurAgilite(int agilite);
	List<Caracteristique> findByGreaterThanEqualsValeurAgilite(int agilite);
	List<Caracteristique> findByLesserThanValeurAgilite(int agilite);

	// =================== Attribut puissance ======================== //
	List<Caracteristique> findByValeurPuissance(int puissance);
	List<Caracteristique> findByGreaterThanEqualsValeurPuissance(int puissance);
	List<Caracteristique> findByLesserThanValeurPuissance(int puissance);

	// =================== Attribut vitesse ======================== //
	List<Caracteristique> findByValeurVitesse(int vitesse);
	List<Caracteristique> findByGreaterThanEqualsValeurVitesse(int vitesse);
	List<Caracteristique> findByLesserThanValeurVitesse(int vitesse);

	// =================== Attribut endurance ======================== //
	List<Caracteristique> findByValeurEndurance(int endurance);
	List<Caracteristique> findByGreaterThanEqualsValeurEndurance(int endurance);
	List<Caracteristique> findByLesserThanValeurEndurance(int endurance);
	
	// =================== Attribut profil ======================== //
	
	@Query("select c from Caracteristique c left join fetch c.profil where c.id=:id")
	Optional<Caracteristique> findByIdProfil(@Param("id") Long id);

}
