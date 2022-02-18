package projet.AppliSport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.AdminException;
import projet.AppliSport.model.Admin;
import projet.AppliSport.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepo;

	public List<Admin> getAll() {
		return adminRepo.findAll();
	}

	public Admin getById(Long id) {
		return adminRepo.findById(id).orElseThrow(() -> {
			throw new AdminException("administrateur non reconnu");
		});
	}

	public Admin createOrUpdate(Admin a) {
		if (a == null) {
			throw new AdminException();
		}
		Admin adminEnBase = null;
		if (a.getId() == null) {
			checkData(a);
			return adminRepo.save(a);
		} else {
			adminEnBase = this.getById(a.getId());
			checkData(a);
			adminEnBase.setIdentifiant(a.getIdentifiant());
			return adminRepo.save(adminEnBase);
		}
	}

	private void checkData(Admin a) {
		if (a.getIdentifiant() == null || a.getIdentifiant().isEmpty()) {
			throw new AdminException("Admin non reconnu");
		}
	}

	public void delete(Admin a) {
		if (a == null || a.getId() == null) {
			throw new AdminException();
		}
		Admin adminEnBase = adminRepo.findById(a.getId()).orElseThrow(AdminException::new);
		adminRepo.delete(adminEnBase);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}

}
