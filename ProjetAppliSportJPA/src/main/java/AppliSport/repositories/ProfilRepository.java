package AppliSport.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import AppliSport.model.Admin;
import AppliSport.model.Profil;

public interface ProfilRepository extends JpaRepository<Profil, Long>{

}
