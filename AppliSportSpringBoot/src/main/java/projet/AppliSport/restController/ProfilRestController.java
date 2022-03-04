package projet.AppliSport.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import projet.AppliSport.exception.ProfilException;
import projet.AppliSport.model.Profil;
import projet.AppliSport.services.ProfilService;
import projet.AppliSport.views.Views;

@RestController
@RequestMapping("/api/profil")
@CrossOrigin(origins="*")
public class ProfilRestController {

	@Autowired
	private ProfilService profilService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Profil> getAll() {
		List<Profil> profils = profilService.getAll();
		return profils;
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Profil getById(@PathVariable Long id) {
		return profilService.getById(id);
	}
	
	@GetMapping("/{id}/utilisateur")
	@JsonView(Views.ProfilUtilisateur.class)
	public Profil getByIdWithUtilisateur(@PathVariable Long id) {
		return profilService.getByIdWithUtilisateur(id);
	}
	
	

	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Profil create(@Valid @RequestBody Profil profil, BindingResult br) {
		if (br.hasErrors()) {
			throw new ProfilException();
		}
		return profilService.createOrUpdate(profil);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Profil update(@PathVariable Long id, @Valid @RequestBody Profil profil, BindingResult br) {
		if (profil.getId() == null || id != profil.getId() || br.hasErrors()) {
			throw new ProfilException();
		}
		return profilService.createOrUpdate(profil);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		profilService.deleteById(id);
	}

}
