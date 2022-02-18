package projet.AppliSport.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import projet.AppliSport.model.Sport;

public interface SportRepository extends JpaRepository<Sport, Long>{
	
	

}
