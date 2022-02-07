package AppliSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import AppliSport.model.EvenementUtilisateur;
import AppliSport.model.EvenementUtilisateurKey;

public interface EvenementUtilisateurRepository extends JpaRepository<EvenementUtilisateur, EvenementUtilisateurKey>{

}
