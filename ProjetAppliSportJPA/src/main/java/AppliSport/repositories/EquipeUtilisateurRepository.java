package AppliSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import AppliSport.model.EquipeUtilisateur;
import AppliSport.model.EquipeUtilisateurKey;

public interface EquipeUtilisateurRepository extends JpaRepository<EquipeUtilisateur, EquipeUtilisateurKey>{

}
