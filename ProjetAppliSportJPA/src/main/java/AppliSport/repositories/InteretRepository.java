package AppliSport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import AppliSport.model.Interet;


public interface InteretRepository extends JpaRepository<Interet, Long>{

	
	@Query("select i from Interet i left join  Utilisateur u where u.id=:id")
	List<Interet> findByIdUtilisateur(@Param("id") Long id);
	
	@Query("select i from Interet i left join  Sport s where s.id=:id")
	List<Interet> findByIdSport(@Param("id") Long id);
	
}
