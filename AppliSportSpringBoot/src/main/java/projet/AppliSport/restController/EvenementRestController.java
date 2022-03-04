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

import projet.AppliSport.exception.EvenementException;
import projet.AppliSport.model.Equipe;
import projet.AppliSport.model.Evenement;
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.services.EvenementService;
import projet.AppliSport.services.UtilisateurService;
import projet.AppliSport.views.Views;
@RestController
@RequestMapping("/api/evenement")
@CrossOrigin(origins="*")
public class EvenementRestController {
	
	@Autowired
	private EvenementService evenementService;
	
	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Evenement> getAll() {
		List<Evenement> list = evenementService.getAll();
		return list;
	}

//	@GetMapping("/utilisateur")
//	@JsonView(Views.Common.class)
//	public List<Utilisateur> getAllUtilisateur() {
//		List<Utilisateur> list = utilisateurService.getAll();
//		return list;
//	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Evenement getById(@PathVariable Long id) {
		return evenementService.getById(id);
	}
	
	@GetMapping("/{id}/utilisateur")
	@JsonView(Views.EvenementUtilisateur.class)
	public Evenement getByIdUtilisateur(@PathVariable Long id) {
		return evenementService.getByIdWithUtilisateur(id);
	}



	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Evenement create(@Valid @RequestBody Evenement evenement, BindingResult br) {
		if (br.hasErrors()) {
			throw new EvenementException();
		}
		return evenementService.createOrUpdate(evenement);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Evenement update(@PathVariable Long id, @Valid @RequestBody Evenement evenement, BindingResult br) {
		if (evenement.getId() == null || id != evenement.getId() || br.hasErrors()) {
			throw new EvenementException();
		}
		return evenementService.createOrUpdate(evenement);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		evenementService.deleteById(id);
	}

}
