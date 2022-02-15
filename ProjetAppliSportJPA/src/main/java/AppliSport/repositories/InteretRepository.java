package AppliSport.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AppliSport.model.Interet;
import AppliSport.model.Utilisateur;

public interface InteretRepository extends JpaRepository<Interet, Long>{

	
	@Query("select i from Interet i left join  Utilisateur u where u.id=:id")
	List<Interet> findByIdUtilisateur(@Param("id") Long id);
	
	@Query("select i from Interet i left join  Sport s where s.id=:id")
	List<Interet> findByIdSport(@Param("id") Long id);
	
	@Transactional
	@Modifying
	@Query("delete from Interet i where i.utilisateur=:utilisateur")
	void deleteInteretByUtilisateur(@Param("utilisateur") Utilisateur utilisateur);
	
	
}
