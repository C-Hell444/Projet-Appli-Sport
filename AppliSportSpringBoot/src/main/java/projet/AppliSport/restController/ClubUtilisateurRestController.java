package projet.AppliSport.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import projet.AppliSport.exception.ClubUtilisateurException;
import projet.AppliSport.model.ClubUtilisateur;
import projet.AppliSport.model.ClubUtilisateurKey;
import projet.AppliSport.services.ClubUtilisateurService;
import projet.AppliSport.views.Views;

@RestController
@RequestMapping("/api/clubUtilisateur")

public class ClubUtilisateurRestController {

	@Autowired
	private ClubUtilisateurService clubUtilisateurService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<ClubUtilisateur> getAll() {
		List<ClubUtilisateur> clubUtilisateurs = clubUtilisateurService.getAll();
		return clubUtilisateurs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public ClubUtilisateur getById(@PathVariable ClubUtilisateurKey id) {
		return clubUtilisateurService.getById(id);
	}

	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClubUtilisateur create(@Valid @RequestBody ClubUtilisateur clubUtilisateur, BindingResult br) {
		if (br.hasErrors()) {
			throw new ClubUtilisateurException();
		}
		return clubUtilisateurService.createOrUpdate(clubUtilisateur);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public ClubUtilisateur update(@PathVariable ClubUtilisateurKey id, @Valid @RequestBody ClubUtilisateur clubUtilisateur, BindingResult br) {
		if (clubUtilisateur.getClubUtilisateurKey() == null || id != clubUtilisateur.getClubUtilisateurKey() || br.hasErrors()) {
			throw new ClubUtilisateurException();
		}
		return clubUtilisateurService.createOrUpdate(clubUtilisateur);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable ClubUtilisateurKey id) {
		clubUtilisateurService.deleteById(id);
	}

}
