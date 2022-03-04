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
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.services.UtilisateurService;
import projet.AppliSport.views.Views;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="*")
public class UtilisateurRestController {

	@Autowired
	private UtilisateurService utilisateurService;
	
	
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Utilisateur> getAll() {
		return utilisateurService.getAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Utilisateur getById(@PathVariable Long id) {
		return utilisateurService.getById(id);
	}
	
	
	@GetMapping("/{id}/club")
	@JsonView(Views.UtilisateurWithClubUtilisateur.class)
	public Utilisateur getByIdWithClubUtilisateur(@PathVariable Long id) {
		return utilisateurService.getByIdWithClubUtilisateur(id);
	}
	
	@GetMapping("/{id}/evenement")
	@JsonView(Views.UtilisateurWithEvenementUtilisateur.class)
	public Utilisateur getByIdWithEvenementUtilisateur(@PathVariable Long id) {
		return utilisateurService.getByIdWithEvenementUtilisateur(id);
	}
	
	@GetMapping("/{id}/equipe")
	@JsonView(Views.UtilisateurWithEquipeUtilisateur.class)
	public Utilisateur getByIdWithEquipeUtilisateur(@PathVariable Long id) {
		return utilisateurService.getByIdWithEquipeUtilisateur(id);
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
	public Utilisateur update(@PathVariable Long id,@Valid @RequestBody Utilisateur utilisateur, BindingResult br) {
		utilisateurService.getById(id);
		if(utilisateur.getId()==null) {
			throw new UtilisateurException();
		}
		if(br.hasErrors()) {
			throw new UtilisateurException();
		}
		return utilisateurService.createOrUpdate(utilisateur);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		utilisateurService.deleteById(id);
	}
	
	
	
	
	
}
