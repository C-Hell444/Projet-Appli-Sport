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

import projet.AppliSport.exception.UtilisateurException;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Profil;
import projet.AppliSport.model.Sport;
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.services.CustomUserDetailsService;
import projet.AppliSport.services.SportService;
import projet.AppliSport.services.UtilisateurService;
import projet.AppliSport.views.Views;

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin(origins="*")
public class UtilisateurRestController {

	@Autowired
	private UtilisateurService utilisateurService;
	
	@Autowired
	private SportService sportService;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	// =================== Get All + tri  ======================== //
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getAll() {
		return utilisateurService.getAll();
	}
	
	@GetMapping("/id")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getAllOrderById() {
		return  utilisateurService.getAllOrderById();
	}
	@GetMapping("/nom")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getAllOrderByNom() {
		return  utilisateurService.getAllOrderByNom();
	}
	
	@GetMapping("/prenom")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getAllOrderByPrenom() {
		return  utilisateurService.getAllOrderByPrenom();
	}
	
	@GetMapping("/numero")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getAllOrderByNumTel() {
		return utilisateurService.getAllOrderByNumTel();
	
	}
	
	@GetMapping("/ville")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getAllOrderByVille() {
		return utilisateurService.getAllOrderByVille();

	}
	
	@GetMapping("/cp")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getAllOrderByCodePostal() {
		return utilisateurService.getAllOrderByCodePostal();

	}
	
	// =================== Get All by sport  ======================== //
	
	@GetMapping("/sport/{id}")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getAllByIdSport(@PathVariable Long id){
		return utilisateurService.getAllBySport(sportService.getById(id));
	}
	
	
	// =================== Get By ? ======================== //
	
		@GetMapping("/nom/{nom}")
		@JsonView(Views.Common.class)
		public List<Utilisateur> getByNom(@PathVariable String nom) {
				return utilisateurService.getByNom(nom);
		}
		
		@GetMapping("/prenom/{prenom}")
		@JsonView(Views.Common.class)
		public List<Utilisateur> getByPrenom(@PathVariable String prenom) {
				return utilisateurService.getByPrenom(prenom);
		}
		
		@GetMapping("/numero/{num}")
		@JsonView(Views.Common.class)
		public List<Utilisateur> getByNumTel(@PathVariable String num) {
				return utilisateurService.getByNumTel(num);
		}
		
		@GetMapping("/ville/{ville}")
		@JsonView(Views.Common.class)
		public List<Utilisateur> getByVille(@PathVariable String ville) {
				return utilisateurService.getByVille(ville);
		}
		
		@GetMapping("/cp/{cp}")
		@JsonView(Views.Common.class)
		public List<Utilisateur> getByCodePostal(@PathVariable String cp) {
				return utilisateurService.getByCodePostal(cp);
		}
		
		@GetMapping("/profil/liste")
		@JsonView(Views.ProfilWithUtilisateur.class)
		public List<Utilisateur> getByListeSport( @RequestBody List<Profil> profils) {
				return utilisateurService.getByListeProfil(profils);
		}
		
	
	// =================== Get By Id ======================== //
	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Utilisateur getById(@PathVariable Long id) {
		return utilisateurService.getById(id);
	}
	
	
	@GetMapping("/{id}/profil")
	@JsonView(Views.UtilisateurWithProfil.class)
	public Utilisateur getByIdWithProfil(@PathVariable Long id) {
		return utilisateurService.getById(id);
	}
	
	@GetMapping("/{id}/interet")
	@JsonView(Views.UtilisateurWithInteret.class)
	public Utilisateur getByIdWithInteret(@PathVariable Long id) {
		return utilisateurService.getByIdWithInteret(id);
	}
	
	
	
	// =================== Get Clubs + tri ======================== //
	@GetMapping("/{id}/club")
	@JsonView(Views.UtilisateurWithClubUtilisateur.class)
	public Utilisateur getByIdWithClubUtilisateur(@PathVariable Long id) {
		return utilisateurService.getByIdWithClubUtilisateur(id);
	}
	
	@GetMapping("/{id}/club/date-debut-asc")
	@JsonView(Views.UtilisateurWithClubUtilisateur.class)
	public Utilisateur getByIdWithClubUtilisateurOrderByDateDebutAsc(@PathVariable Long id) {
		return utilisateurService.getByIdWithClubUtilisateurOrderByDateDebutAsc(id);
	}
	
	@GetMapping("/{id}/club/date-debut-desc")
	@JsonView(Views.UtilisateurWithClubUtilisateur.class)
	public Utilisateur getByIdWithClubUtilisateurOrderByDateDebutDesc(@PathVariable Long id) {
		return utilisateurService.getByIdWithClubUtilisateurOrderByDateDebutDesc(id);
	}
	
	@GetMapping("/{id}/club/date-fin-asc")
	@JsonView(Views.UtilisateurWithClubUtilisateur.class)
	public Utilisateur getByIdWithClubUtilisateurOrderByDateFinAsc(@PathVariable Long id) {
		return utilisateurService.getByIdWithClubUtilisateurOrderByDateFinAsc(id);
	}
	
	@GetMapping("/{id}/club/date-fin-desc")
	@JsonView(Views.UtilisateurWithClubUtilisateur.class)
	public Utilisateur getByIdWithClubUtilisateurOrderByDateFinDesc(@PathVariable Long id) {
		return utilisateurService.getByIdWithClubUtilisateurOrderByDateFinDesc(id);
	}
	
	// =================== Get Evenements + tri ======================== //
	
	@GetMapping("/{id}/evenement")
	@JsonView(Views.UtilisateurWithEvenementUtilisateur.class)
	public Utilisateur getByIdWithEvenementUtilisateur(@PathVariable Long id) {
		return utilisateurService.getByIdWithEvenementUtilisateur(id);
	}
	
	@GetMapping("/{id}/evenement/date-debut-asc")
	@JsonView(Views.UtilisateurWithEvenementUtilisateur.class)
	public Utilisateur getByIdWithEvenementUtilisateurOrderByDateDebutAsc(@PathVariable Long id) {
		return utilisateurService.getByIdWithEvenementUtilisateurOrderByDateDebutAsc(id);
	}
	
	@GetMapping("/{id}/evenement/date-debut-desc")
	@JsonView(Views.UtilisateurWithEvenementUtilisateur.class)
	public Utilisateur getByIdWithEvenementUtilisateurOrderByDateDebutDesc(@PathVariable Long id) {
		return utilisateurService.getByIdWithEvenementUtilisateurOrderByDateDebutDesc(id);
	}
	
	@GetMapping("/{id}/evenement/date-fin-asc")
	@JsonView(Views.UtilisateurWithEvenementUtilisateur.class)
	public Utilisateur getByIdWithEvenementUtilisateurOrderByDateFinAsc(@PathVariable Long id) {
		return utilisateurService.getByIdWithEvenementUtilisateurOrderByDateFinAsc(id);
	}
	
	@GetMapping("/{id}/evenement/date-fin-desc")
	@JsonView(Views.UtilisateurWithEvenementUtilisateur.class)
	public Utilisateur getByIdWithEvenementUtilisateurOrderByDateFinDesc(@PathVariable Long id) {
		return utilisateurService.getByIdWithEvenementUtilisateurOrderByDateFinDesc(id);
	}
	
	// =================== Get Equipe + tri ======================== //
	
	@GetMapping("/{id}/equipe")
	@JsonView(Views.UtilisateurWithEquipeUtilisateur.class)
	public Utilisateur getByIdWithEquipeUtilisateur(@PathVariable Long id) {
		return utilisateurService.getByIdWithEquipeUtilisateur(id);
	}
	
	@GetMapping("/{id}/equipe/date-debut-asc")
	@JsonView(Views.UtilisateurWithEquipeUtilisateur.class)
	public Utilisateur getByIdWithEquipeUtilisateurOrderByDateDebutAsc(@PathVariable Long id) {
		return utilisateurService.getByIdWithEquipeUtilisateurOrderByDateDebutAsc(id);
	}
	
	@GetMapping("/{id}/equipe/date-debut-desc")
	@JsonView(Views.UtilisateurWithEquipeUtilisateur.class)
	public Utilisateur getByIdWithEquipeUtilisateurOrderByDateDebutDesc(@PathVariable Long id) {
		return utilisateurService.getByIdWithEquipeUtilisateurOrderByDateDebutDesc(id);
	}
	
	@GetMapping("/{id}/equipe/date-fin-asc")
	@JsonView(Views.UtilisateurWithEquipeUtilisateur.class)
	public Utilisateur getByIdWithEquipeUtilisateurOrderByDateFinAsc(@PathVariable Long id) {
		return utilisateurService.getByIdWithEquipeUtilisateurOrderByDateFinAsc(id);
	}
	
	@GetMapping("/{id}/equipe/date-fin-desc")
	@JsonView(Views.UtilisateurWithEquipeUtilisateur.class)
	public Utilisateur getByIdWithEquipeUtilisateurOrderByDateFinDesc(@PathVariable Long id) {
		return utilisateurService.getByIdWithEquipeUtilisateurOrderByDateFinDesc(id);
	}
	
	
	
	
	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Utilisateur create(@Valid @RequestBody Utilisateur utilisateur, BindingResult br) {
		if(br.hasErrors()) {
			throw new UtilisateurException();
		}
		return utilisateurService.createOrUpdate(utilisateur);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Utilisateur update(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
		utilisateurService.getById(id);
		if(utilisateur.getId()==null) {
			throw new UtilisateurException();
		}
		if(utilisateur.getMdp()==null) {
			utilisateur.setMdp("toto");
		}
		return (Utilisateur) customUserDetailsService.createOrUpdate(utilisateur);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		utilisateurService.deleteById(id);
	}
	
	
	
	
	
}
