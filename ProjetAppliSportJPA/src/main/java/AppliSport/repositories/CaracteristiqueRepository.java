package AppliSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import AppliSport.model.Admin;
import AppliSport.model.Caracteristique;

public interface CaracteristiqueRepository extends JpaRepository<Caracteristique, Long>{

}
