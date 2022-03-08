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

import projet.AppliSport.exception.EvenementException;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Equipe;
import projet.AppliSport.model.Evenement;
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.services.EvenementService;
import projet.AppliSport.services.UtilisateurService;
import projet.AppliSport.views.Views;

@RestController
@RequestMapping("/api/evenement")
@CrossOrigin(origins = "*")
public class EvenementRestController {

	@Autowired
	private EvenementService evenementService;

	@Autowired
	private UtilisateurService utilisateurService;

	// =================== Get All + tri ======================== //
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Evenement> getAllEvenement() {
		return evenementService.getAll();
	}
	@GetMapping("/id")
	@JsonView(Views.Common.class)
	public List<Evenement> getAllOrderById() {
		return evenementService.getAllOrderById();
	}

	@GetMapping("/nom")
	@JsonView(Views.Common.class)
	public List<Evenement> getAllOrderByNom() {
		return evenementService.getAllOrderByNom();
	}

	@GetMapping("/club")
	@JsonView(Views.EvenementWithClub.class)
	public List<Evenement> getAllOrderByClub() {
		return evenementService.getAllOrderByClub();
	}
	
	@GetMapping("/date-debut")
	@JsonView(Views.Common.class)
	public List<Evenement> getAllOrderByDateDebut() {
		return evenementService.getAllOrderByDateDebut();
	}
	
	@GetMapping("/date-fin")
	@JsonView(Views.Common.class)
	public List<Evenement> getAllOrderByDateFin() {
		return evenementService.getAllOrderByDateFin();
	}
	// =================== Get By ? ======================== //

	@GetMapping("/nom/{nom}")
	@JsonView(Views.Common.class)
	public List<Evenement> getByNom(@PathVariable String nom) {
		return evenementService.getByNom(nom);
	}

	@GetMapping("/club/{nom}")
	@JsonView(Views.EvenementWithClub.class)
	public List<Evenement> getByClubNom(@PathVariable String nom) {
		return evenementService.getByClubNom(nom);
	}

	@GetMapping("/club/objet")
	@JsonView(Views.EvenementWithClub.class)
	public List<Evenement> getByClub( @RequestBody Club club) {
		return evenementService.getByClub(club);
	}
	
	@GetMapping("/date/futur")
	@JsonView(Views.Common.class)
	public List<Evenement> getByDateFutur() {
		LocalDate date=LocalDate.now();
		return evenementService.getByDateFutur(date);
	}
	
	@GetMapping("/date/passe")
	@JsonView(Views.Common.class)
	public List<Evenement> getByDatePasse() {
		LocalDate date=LocalDate.now();
		return evenementService.getByDatePasse(date);
	}
	
	

	
	// =================== Get By Id ======================== //
	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Evenement getById(@PathVariable Long id) {
		return evenementService.getById(id);
	}

	
	// =================== Get Utilisateurs + tri ======================== //
	
	@GetMapping("/{id}/utilisateur")
	@JsonView(Views.EvenementWithEvenementUtilisateur.class)
	public Evenement getByIdUtilisateur(@PathVariable Long id) {
		return evenementService.getByIdWithUtilisateur(id);
	}

	@GetMapping("/{id}/utilisateur/date-debut-asc")
	@JsonView(Views.EvenementWithEvenementUtilisateur.class)
	public Evenement getByIdWithEvenementUtilisateurOrderByDateDebutAsc(@PathVariable Long id) {
		return evenementService.getByIdWithEvenementUtilisateurOrderByDateDebutAsc(id);
	}

	@GetMapping("/{id}/utilisateur/date-fin-asc")
	@JsonView(Views.EvenementWithEvenementUtilisateur.class)
	public Evenement getByIdWithEvenementUtilisateurOrderByDateFinAsc(@PathVariable Long id) {
		return evenementService.getByIdWithEvenementUtilisateurOrderByDateFinAsc(id);
	}

	@GetMapping("/{id}/utilisateur/date-debut-desc")
	@JsonView(Views.EvenementWithEvenementUtilisateur.class)
	public Evenement getByIdWithEvenementUtilisateurOrderByDateDebutDesc(@PathVariable Long id) {
		return evenementService.getByIdWithEvenementUtilisateurOrderByDateDebutDesc(id);
	}

	@GetMapping("/{id}/utilisateur/date-fin-desc")
	@JsonView(Views.EvenementWithEvenementUtilisateur.class)
	public Evenement getByIdWithEvenementUtilisateurOrderByDateFinDesc(@PathVariable Long id) {
		return evenementService.getByIdWithEvenementUtilisateurOrderByDateFinDesc(id);
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
