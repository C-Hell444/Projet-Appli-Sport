package projet.AppliSport.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import projet.AppliSport.exception.CompteException;
import projet.AppliSport.model.Admin;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Compte;
import projet.AppliSport.model.CompteRepository;
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.services.CustomUserDetailsService;
import projet.AppliSport.views.Views;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="*")
public class AuthRestController {
	
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private CompteRepository compteRepository;
	
	
	@GetMapping("")
	@JsonView(Views.Common.class)
	public Compte auth(@AuthenticationPrincipal Compte user) {
		return user;
	}
	
	@PreAuthorize("isAnonymous()")
	@PostMapping("/inscription/utilisateur")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Utilisateur create (@Valid @RequestBody Utilisateur utilisateur, BindingResult br) {
		if(br.hasErrors()) {
			throw new CompteException();
		}
		return (Utilisateur) customUserDetailsService.createOrUpdate(utilisateur);
	}
	
	@PreAuthorize("isAnonymous()")
	@PostMapping("/inscription/club")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Club create (@Valid @RequestBody Club club, BindingResult br) {
		if(br.hasErrors()) {
			throw new CompteException();
		}
		return (Club) customUserDetailsService.createOrUpdate(club);
	}
	
	@PreAuthorize("isAnonymous()")
	@PostMapping("/inscription/admin")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Admin create (@Valid @RequestBody Admin admin, BindingResult br) {
		if(br.hasErrors()) {
			throw new CompteException();
		}
		return (Admin) customUserDetailsService.createOrUpdate(admin);
	}
	
	@GetMapping("/search/{identifiant}")
	public boolean usernameDejaUtilise(@PathVariable String identifiant) {
		return compteRepository.findByIdentifiant(identifiant).isPresent();
	}
	
	@GetMapping("/search/{mail}")
	public boolean mailDejaUtilise(@PathVariable String mail) {
		return compteRepository.findByMail(mail).isPresent();
	}

}
