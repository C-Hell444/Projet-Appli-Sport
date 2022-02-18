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

import projet.AppliSport.exception.ClubException;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.services.ClubService;
import projet.AppliSport.services.UtilisateurService;
import projet.AppliSport.views.Views;



@RestController
@RequestMapping("/api/club")
public class ClubRestController {

	@Autowired
	private ClubService clubService;
	
	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Club> getAll() {
		List<Club> list = clubService.getAll();
		return list;
	}

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getAllUtilisateur() {
		List<Utilisateur> list = utilisateurService.getAll();
		return list;
	}


	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Club getById(@PathVariable Long id) {
		return clubService.getById(id);
	}



	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Club create(@Valid @RequestBody Club club, BindingResult br) {
		if (br.hasErrors()) {
			throw new ClubException();
		}
		return clubService.createOrUpdate(club);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Club update(@PathVariable Long id, @Valid @RequestBody Club club, BindingResult br) {
		if (club.getId() == null || id != club.getId() || br.hasErrors()) {
			throw new ClubException();
		}
		return clubService.createOrUpdate(club);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clubService.deleteById(id);
	}

}

