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

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Equipe> getAllEquipe() {
		List<Equipe> list = equipeService.getAll();
		return list;
	}
	
	@GetMapping("/utilisateur")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getAllUtilisateur() {
		List<Utilisateur> list = utilisateurService.getAll();
		return list;
	}



	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Equipe getById(@PathVariable Long id) {
		return equipeService.getById(id);
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
