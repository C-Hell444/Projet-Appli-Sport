package projet.AppliSport.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import projet.AppliSport.model.Admin;
import projet.AppliSport.services.AdminService;
//import projet.AppliSport.services.CustomUserDetailsService;
import projet.AppliSport.views.Views;


@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins="*")
public class AdminRestController {
	

	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Admin> getAll() {
		return adminService.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Admin getById(@PathVariable Long id) {
		return adminService.getById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		adminService.deleteById(id);
	}

}
