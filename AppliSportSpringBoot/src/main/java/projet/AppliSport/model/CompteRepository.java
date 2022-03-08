package projet.AppliSport.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {

	Optional<Compte> findByIdentifiant(String identifiant);
	Optional<Compte> findByMail(String mail);
	
}
