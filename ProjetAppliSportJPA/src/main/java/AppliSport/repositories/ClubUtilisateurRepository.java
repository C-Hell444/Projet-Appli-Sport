package AppliSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import AppliSport.model.ClubUtilisateur;
import AppliSport.model.ClubUtilisateurKey;

public interface ClubUtilisateurRepository extends JpaRepository<ClubUtilisateur, ClubUtilisateurKey>{

}
