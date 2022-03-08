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

import projet.AppliSport.exception.EquipeException;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Equipe;
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.services.EquipeService;
import projet.AppliSport.services.UtilisateurService;
import projet.AppliSport.views.Views;


@RestController
@RequestMapping("/api/equipe")
@CrossOrigin(origins="*")
public class EquipeRestController {
	@Autowired
	private EquipeService equipeService;
	
	@Autowired
	private UtilisateurService utilisateurService;

	// =================== Get All + tri  ======================== //
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Equipe> getAll() {
		return equipeService.getAll();
	}
	
	@GetMapping("/id")
	@JsonView(Views.Common.class)
	public List<Equipe> getAllOrderById() {
		return  equipeService.getAllOrderById();
	}
	
	@GetMapping("/nom")
	@JsonView(Views.Common.class)
	public List<Equipe> getAllOrderByNom() {
		return  equipeService.getAllOrderByNom();
	}
	
	@GetMapping("/club")
	@JsonView(Views.EquipeWithClub.class)
	public List<Equipe> getAllOrderByClub() {
		return  equipeService.getAllOrderByClub();
	}
	
	// =================== Get By ? ======================== //

	@GetMapping("/nom/{nom}")
	@JsonView(Views.Common.class)
	public List<Equipe> getByNom(@PathVariable String nom) {
			return equipeService.getByNom(nom);
	}
	
	@GetMapping("/club/{nom}")
	@JsonView(Views.EquipeWithClub.class)
	public List<Equipe> getByClubNom(@PathVariable String nom) {
			return equipeService.getByClubNom(nom);
	}
	@GetMapping("/club/objet")
	@JsonView(Views.EquipeWithClub.class)
	public List<Equipe> getByClub( @RequestBody Club club) {
			return equipeService.getByClub(club);
	}
	
	
	// =================== Get By Id ======================== //
	
	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Equipe getById(@PathVariable Long id) {
		return equipeService.getById(id);
	}
	
	
	// =================== Get Utilisateurs + tri ======================== //
	
	@GetMapping("/{id}/utilisateur")
	@JsonView(Views.EquipeWithEquipeUtilisateur.class)
	public Equipe getByIdWithEquipeUtilisateur(@PathVariable Long id) {
		return equipeService.getByIdWithUtilisateur(id);
	}
	
	@GetMapping("/{id}/utilisateur/date-debut-asc")
	@JsonView(Views.EquipeWithEquipeUtilisateur.class)
	public Equipe getByIdWithEquipeUtilisateurOrderByDateDebutAsc(@PathVariable Long id) {
		return equipeService.getByIdWithEquipeUtilisateurOrderByDateDebutAsc(id);
	}
	
	@GetMapping("/{id}/utilisateur/date-fin-asc")
	@JsonView(Views.EquipeWithEquipeUtilisateur.class)
	public Equipe getByIdWithEquipeUtilisateurOrderByDateFinAsc(@PathVariable Long id) {
		return equipeService.getByIdWithEquipeUtilisateurOrderByDateFinAsc(id);
	}
	
	@GetMapping("/{id}/utilisateur/date-debut-desc")
	@JsonView(Views.EquipeWithEquipeUtilisateur.class)
	public Equipe getByIdWithEquipeUtilisateurOrderByDateDebutDesc(@PathVariable Long id) {
		return equipeService.getByIdWithEquipeUtilisateurOrderByDateDebutDesc(id);
	}
	
	@GetMapping("/{id}/utilisateur/date-fin-desc")
	@JsonView(Views.EquipeWithEquipeUtilisateur.class)
	public Equipe getByIdWithEquipeUtilisateurOrderByDateFinDesc(@PathVariable Long id) {
		return equipeService.getByIdWithEquipeUtilisateurOrderByDateFinDesc(id);
	}
	
	



	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Equipe create(@Valid @RequestBody Equipe equipe, BindingResult br) {
		if (br.hasErrors()) {
			throw new EquipeException();
		}
		return equipeService.createOrUpdate(equipe);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Equipe update(@PathVariable Long id, @Valid @RequestBody Equipe equipe, BindingResult br) {
		if (equipe.getId() == null || id != equipe.getId() || br.hasErrors()) {
			throw new EquipeException();
		}
		return equipeService.createOrUpdate(equipe);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		equipeService.deleteById(id);
	}

}
