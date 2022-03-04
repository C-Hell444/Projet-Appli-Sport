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

import projet.AppliSport.exception.EquipeUtilisateurException;
import projet.AppliSport.model.EquipeUtilisateur;
import projet.AppliSport.model.EquipeUtilisateurKey;
import projet.AppliSport.services.EquipeUtilisateurService;
import projet.AppliSport.views.Views;

@RestController
@RequestMapping("/api/equipe-utilisateur")
@CrossOrigin(origins="*")
public class EquipeUtilisateurRestController {

	@Autowired
	private EquipeUtilisateurService equipeUtilisateurService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<EquipeUtilisateur> getAll() {
		List<EquipeUtilisateur> equipeUtilisateurs = equipeUtilisateurService.getAll();
		return equipeUtilisateurs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public EquipeUtilisateur getById(@PathVariable EquipeUtilisateurKey id) {
		return equipeUtilisateurService.getById(id);
	}

	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public EquipeUtilisateur create(@Valid @RequestBody EquipeUtilisateur equipeUtilisateur, BindingResult br) {
		if (br.hasErrors()) {
			throw new EquipeUtilisateurException();
		}
		return equipeUtilisateurService.createOrUpdate(equipeUtilisateur);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public EquipeUtilisateur update(@PathVariable EquipeUtilisateurKey id, @Valid @RequestBody EquipeUtilisateur equipeUtilisateur, BindingResult br) {
		if (equipeUtilisateur.getEquipeUtilisateurKey() == null || id != equipeUtilisateur.getEquipeUtilisateurKey() || br.hasErrors()) {
			throw new EquipeUtilisateurException();
		}
		return equipeUtilisateurService.createOrUpdate(equipeUtilisateur);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable EquipeUtilisateurKey id) {
		equipeUtilisateurService.deleteById(id);
	}

}
