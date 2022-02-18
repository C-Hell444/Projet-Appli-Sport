package projet.AppliSport.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import projet.AppliSport.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	@Override
	Optional<Admin> findById(Long id);
	Optional<Admin> findByIdentifiant(String identifiant);

	
	

}
