package AppliSport.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import AppliSport.model.Admin;
import AppliSport.model.Compte;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	@Override
	Optional<Admin> findById(Long id);
	Optional<Admin> findById(String identifiant);

	
	

}
