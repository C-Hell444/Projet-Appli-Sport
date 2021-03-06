package projet.AppliSport.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.AppliSport.model.Interet;
import projet.AppliSport.model.Sport;
import projet.AppliSport.model.Utilisateur;

public interface InteretRepository extends JpaRepository<Interet, Long>{

	
	@Query("select i from Interet i left join  Utilisateur u where u.id=:id")
	List<Interet> findByIdUtilisateur(@Param("id") Long id);
	
	@Query("select i from Interet i left join  Sport s where s.id=:id")
	List<Interet> findByIdSport(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query("delete from Interet i where i.utilisateur=:utilisateur")
	void deleteInteretByUtilisateur(@Param("utilisateur") Utilisateur utilisateur);
	
	@Transactional
	@Modifying
	@Query("delete from Interet i where i.sport=:sport")
	void deleteInteretBySport(@Param("sport") Sport sport);
	
	
}
