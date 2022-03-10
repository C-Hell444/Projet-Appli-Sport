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

import projet.AppliSport.exception.ClubException;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Equipe;
import projet.AppliSport.model.Evenement;
import projet.AppliSport.model.Sport;
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.services.ClubService;
import projet.AppliSport.services.CustomUserDetailsService;
import projet.AppliSport.services.EquipeService;
import projet.AppliSport.services.EvenementService;
import projet.AppliSport.services.SportService;
import projet.AppliSport.services.UtilisateurService;
import projet.AppliSport.views.Views;
import projet.AppliSport.views.Views.ClubWithEvenement;



@RestController
@RequestMapping("/api/club")
@CrossOrigin(origins="*")
public class ClubRestController {

	@Autowired
	private ClubService clubService;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private EvenementService evenementService;
	
	@Autowired
	private EquipeService equipeService;
	
	@Autowired
	private SportService sportService;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	
	// =================== Get All + tri  ======================== //
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Club> getAll() {
		return clubService.getAll();
		
	}
	
	@GetMapping("/id")
	@JsonView(Views.Common.class)
	public List<Club> getAllOrderById() {
		return  clubService.getAllOrderById();
	}
	
	@GetMapping("/nom")
	@JsonView(Views.Common.class)
	public List<Club> getAllOrderByClubNom() {
		return  clubService.getAllOrderByClubNom();
	}
	
	@GetMapping("/numero")
	@JsonView(Views.Common.class)
	public List<Club> getAllOrderByNumTel() {
		return clubService.getAllOrderByNumTel();
	
	}
	
	@GetMapping("/sport")
	@JsonView(Views.ClubWithSport.class)
	public List<Club> getAllOrderBySportClub() {
		return clubService.getAllOrderBySportClub();
	}
	
	@GetMapping("/ville")
	@JsonView(Views.Common.class)
	public List<Club> getAllOrderByVille() {
		return clubService.getAllOrderByVille();

	}
	
	@GetMapping("/cp")
	@JsonView(Views.Common.class)
	public List<Club> getAllOrderByCodePostal() {
		return clubService.getAllOrderByCodePostal();

	}
	
	

	// =================== Get By Id ======================== //
	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Club getById(@PathVariable Long id) {
		return clubService.getById(id);
	}
	
	@GetMapping("/{id}/equipe")
	@JsonView(Views.ClubWithEquipe.class)
	public Club getByIdEquipe(@PathVariable Long id) {
		return clubService.getByIdWithEquipe(id);
	}
	
	
	
	@GetMapping("/{id}/sport")
	@JsonView(Views.ClubWithSport.class)
	public Club getByIdWithSport(@PathVariable Long id) {
		return clubService.getByIdWithSport(id);
	}
	
	// =================== Get By ? ======================== //
	
	@GetMapping("/nom/{nom}")
	@JsonView(Views.Common.class)
	public List<Club> getByClubNom(@PathVariable String nom) {
			return clubService.getByClubNom(nom);
	}
	
	@GetMapping("/numero/{num}")
	@JsonView(Views.Common.class)
	public List<Club> getByNumTel(@PathVariable String num) {
			return clubService.getByNumTel(num);
	}
	
	@GetMapping("/sport/nom/{sport}")
	@JsonView(Views.ClubWithSport.class)
	public List<Club> getBySportNom(@PathVariable String sport) {
			return clubService.getBySportNom(sport);
	}
	
	@GetMapping("/sport/{id}")
	@JsonView(Views.ClubWithSport.class)
	public List<Club> getBySport( @PathVariable Long id) {
			return clubService.getBySportClub(sportService.getById(id));
	}
	
//	@GetMapping("/sport/liste")
//	@JsonView(Views.ClubWithSport.class)
//	public List<Club> getByListeSport( @RequestBody List<Sport> sports) {
//			return clubService.getByListeSport(sports);
//	}
	
	
	@GetMapping("/ville/{ville}")
	@JsonView(Views.Common.class)
	public List<Club> getByVille(@PathVariable String ville) {
			return clubService.getByVille(ville);
	}
	
	@GetMapping("/cp/{cp}")
	@JsonView(Views.Common.class)
	public List<Club> getByCodePostal(@PathVariable String cp) {
			return clubService.getByCodePostal(cp);
	}
	
	
	
	
	
	// =================== Get Utilisateurs + tri ======================== //
	
	@GetMapping("/{id}/utilisateur")
	@JsonView(Views.ClubWithClubUtilisateur.class)
	public Club getByIdUtilisateur(@PathVariable Long id) {
		return clubService.getByIdWithUtilisateur(id);
	}
	
	@GetMapping("/{id}/utilisateur/date-debut-asc")
	@JsonView(Views.ClubWithClubUtilisateur.class)
	public Club getByIdWithClubUtilisateurOrderByDateDebutAsc(@PathVariable Long id) {
		return clubService.getByIdWithClubUtilisateurOrderByDateDebutAsc(id);
	}
	
	@GetMapping("/{id}/utilisateur/date-debut-desc")
	@JsonView(Views.ClubWithClubUtilisateur.class)
	public Club getByIdWithClubUtilisateurbOrderByDateDebutDesc(@PathVariable Long id) {
		return clubService.getByIdWithClubUtilisateurOrderByDateDebutDesc(id);
	}
	
	@GetMapping("/{id}/utilisateur/date-fin-asc")
	@JsonView(Views.ClubWithClubUtilisateur.class)
	public Club getByIdWithClubUtilisateurOrderByDateFinAsc(@PathVariable Long id) {
		return clubService.getByIdWithClubUtilisateurOrderByDateFinAsc(id);
	}
	
	@GetMapping("/{id}/utilisateur/date-fin-desc")
	@JsonView(Views.ClubWithClubUtilisateur.class)
	public Club getByIdWithClubUtilisateurOrderByDateFinDesc(@PathVariable Long id) {
		return clubService.getByIdWithClubUtilisateurOrderByDateFinDesc(id);
	}
	
	// =================== Get Evenements + tri ======================== //
	
	@GetMapping("/{id}/evenement")
	@JsonView(Views.ClubWithEvenement.class)
	public Club getByIdEvenement(@PathVariable Long id) {
		return clubService.getByIdWithEvenement(id);
	}
	@GetMapping("/{id}/evenement/date-debut-asc")
	@JsonView(Views.ClubWithEvenement.class)
	public Club getByIdWithEvenementOrderByDateDebutAsc(@PathVariable Long id) {
		return clubService.getByIdWithEvenementOrderByDateDebutAsc(id);
	}
	
	@GetMapping("/{id}/evenement/date-debut-desc")
	@JsonView(Views.ClubWithEvenement.class)
	public Club getByIdWithEvenementbOrderByDateDebutDesc(@PathVariable Long id) {
		return clubService.getByIdWithEvenementOrderByDateDebutDesc(id);
	}
	
	@GetMapping("/{id}/evenement/date-fin-asc")
	@JsonView(Views.ClubWithEvenement.class)
	public Club getByIdWithEvenementOrderByDateFinAsc(@PathVariable Long id) {
		return clubService.getByIdWithEvenementOrderByDateFinAsc(id);
	}
	
	@GetMapping("/{id}/evenement/date-fin-desc")
	@JsonView(Views.ClubWithEvenement.class)
	public Club getByIdWithEvenementOrderByDateFinDesc(@PathVariable Long id) {
		return clubService.getByIdWithEvenementOrderByDateFinDesc(id);
	}



//	@PostMapping("")
//	@JsonView(Views.Common.class)
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public Club create(@Valid @RequestBody Club club, BindingResult br) {
//		if (br.hasErrors()) {
//			throw new ClubException();
//		}
//		return clubService.createOrUpdate(club);
//	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Club update(@PathVariable Long id, @Valid @RequestBody Club club, BindingResult br) {
		if (club.getId() == null ||id != club.getId() ||br.hasErrors()) {
			throw new ClubException("test");
		}
	
		
		return (Club) customUserDetailsService.createOrUpdate(club);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clubService.deleteById(id);
	}

}

