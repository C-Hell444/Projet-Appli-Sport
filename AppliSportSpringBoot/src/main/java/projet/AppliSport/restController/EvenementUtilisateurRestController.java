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

import projet.AppliSport.exception.EvenementUtilisateurException;
import projet.AppliSport.model.EvenementUtilisateur;
import projet.AppliSport.model.EvenementUtilisateurKey;
import projet.AppliSport.services.EvenementUtilisateurService;
import projet.AppliSport.views.Views;

@RestController
@RequestMapping("/api/evenement-utilisateur")
@CrossOrigin(origins="*")
public class EvenementUtilisateurRestController {

	@Autowired
	private EvenementUtilisateurService evenementUtilisateurService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<EvenementUtilisateur> getAll() {
		List<EvenementUtilisateur> evenementUtilisateurs = evenementUtilisateurService.getAll();
		return evenementUtilisateurs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public EvenementUtilisateur getById(@PathVariable EvenementUtilisateurKey id) {
		return evenementUtilisateurService.getById(id);
	}

	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public EvenementUtilisateur create(@Valid @RequestBody EvenementUtilisateur evenementUtilisateur, BindingResult br) {
		if (br.hasErrors()) {
			throw new EvenementUtilisateurException();
		}
		return evenementUtilisateurService.createOrUpdate(evenementUtilisateur);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public EvenementUtilisateur update(@PathVariable EvenementUtilisateurKey id, @Valid @RequestBody EvenementUtilisateur evenementUtilisateur, BindingResult br) {
		if (evenementUtilisateur.getId() == null || id != evenementUtilisateur.getId() || br.hasErrors()) {
			throw new EvenementUtilisateurException();
		}
		return evenementUtilisateurService.createOrUpdate(evenementUtilisateur);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable EvenementUtilisateurKey id) {
		evenementUtilisateurService.deleteById(id);
	}

	
}
