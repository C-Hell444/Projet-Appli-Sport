package AppliSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import AppliSport.model.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long>{

}
