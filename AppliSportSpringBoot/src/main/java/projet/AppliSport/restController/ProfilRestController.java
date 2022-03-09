package projet.AppliSport.restController;

import java.time.LocalDate;
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
import projet.AppliSport.model.Sexe;
import projet.AppliSport.services.ProfilService;
import projet.AppliSport.views.Views;

@RestController
@RequestMapping("/api/profil")
@CrossOrigin(origins="*")
public class ProfilRestController {

	@Autowired
	private ProfilService profilService;

	// =================== Get All + tri  ======================== //
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Profil> getAll() {
		List<Profil> profils = profilService.getAll();
		return profils;
	}
	
	// =================== Get By ? ======================== //
	
	@GetMapping("/poids/{poids}")
	@JsonView(Views.Common.class)
	public List<Profil> getByPoids(@PathVariable double poids) {
		return profilService.getByPoids(poids);
	}
	@GetMapping("/poids/{poids}/greater")
	@JsonView(Views.Common.class)
	public List<Profil> getByPoidsGreaterThan(@PathVariable double poids) {
		return profilService.getByPoidsGreaterThan(poids);
	}
	@GetMapping("/poids/{poids}/less")
	@JsonView(Views.Common.class)
	public List<Profil> getByPoidsLesserThan(@PathVariable double poids) {
		return profilService.getByPoidsLesserThan(poids);
	}
	
	@GetMapping("/taille/{taille}")
	@JsonView(Views.Common.class)
	public List<Profil> getByTaille(@PathVariable double taille) {
		return profilService.getByTaille(taille);
	}
	@GetMapping("/taille/{taille}/greater")
	@JsonView(Views.Common.class)
	public List<Profil> getByTailleGreaterThan(@PathVariable double taille) {
		return profilService.getByTailleGreaterThan(taille);
	}
	@GetMapping("/taille/{taille}/less")
	@JsonView(Views.Common.class)
	public List<Profil> getByTailleLesserThan(@PathVariable double taille) {
		return profilService.getByTailleLesserThan(taille);
	}
	
//	@GetMapping("/age/{age}")
//	@JsonView(Views.Common.class)
//	public List<Profil> getByDateNaissance(@PathVariable Long age) {
//		LocalDate dateNaissance = LocalDate.now().minusYears(age);
//		return profilService.getByDateNaissance(dateNaissance);
//	}
	@GetMapping("/age/{age}/greater")
	@JsonView(Views.Common.class)
	public List<Profil> getByAgeGreaterThan(@PathVariable Long age) {
		LocalDate dateNaissance = LocalDate.now().minusYears(age);
		return profilService.getByDateNaissanceLesserThan(dateNaissance);
	}
	@GetMapping("/age/{age}/less")
	@JsonView(Views.Common.class)
	public List<Profil> getByAgeLesserThan(@PathVariable Long age) {
		LocalDate dateNaissance = LocalDate.now().minusYears(age);
		System.out.println(dateNaissance);
		return profilService.getByDateNaissanceGreaterThan(dateNaissance);
	}
	
	@GetMapping("/sexe/{sexe}")
	@JsonView(Views.Common.class)
	public List<Profil> getBySexe(@PathVariable Sexe sexe) {
		return profilService.getBySexe(sexe);
	}
	

	// =================== Get By Id ======================== //
	
	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Profil getById(@PathVariable Long id) {
		return profilService.getById(id);
	}
	
	@GetMapping("/{id}/utilisateur")
	@JsonView(Views.ProfilWithUtilisateur.class)
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
