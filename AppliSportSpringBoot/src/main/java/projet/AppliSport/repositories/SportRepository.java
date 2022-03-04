package projet.AppliSport.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projet.AppliSport.model.Sport;

public interface SportRepository extends JpaRepository<Sport, Long>{

	@Query("select s from Sport s left join s.clubs where s.id=:id")
	Optional<Sport> findByIdWithClub(Long id);
	
	@Query("select s from Sport s left join s.interets where s.id=:id")
	Optional<Sport> findByIdWithInteret(Long id);
	
	

}
