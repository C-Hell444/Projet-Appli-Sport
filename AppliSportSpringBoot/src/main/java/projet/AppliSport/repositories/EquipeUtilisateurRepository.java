package projet.AppliSport.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Equipe;
import projet.AppliSport.model.EquipeUtilisateur;
import projet.AppliSport.model.EquipeUtilisateurKey;
import projet.AppliSport.model.Utilisateur;

public interface EquipeUtilisateurRepository extends JpaRepository<EquipeUtilisateur, EquipeUtilisateurKey>{
	List<EquipeUtilisateur> findByDateDebut(LocalDate dateDebut);
	List<EquipeUtilisateur> findByDateFin(LocalDate dateFin);
	Optional<EquipeUtilisateur> findById(EquipeUtilisateurKey id);
	
	@Query("select eu from EquipeUtilisateur eu left join fetch eu.id.equipe e where e.id=:id")
	List<EquipeUtilisateur> findByEquipeId(@Param("id") Long id);


	
	@Transactional
	@Modifying
	@Query("delete from EquipeUtilisateur e where e.id.utilisateur=:utilisateur")
	void deleteEquipeUtilisateurByUtilisateur(@Param("utilisateur") Utilisateur utilisateur);
	
	
	@Transactional
	@Modifying
	@Query("delete from EquipeUtilisateur e where e.id.equipe=:equipe")
	void deleteEquipeUtilisateurByEquipe(@Param("equipe") Equipe equipe);
	
	
	
	
}
