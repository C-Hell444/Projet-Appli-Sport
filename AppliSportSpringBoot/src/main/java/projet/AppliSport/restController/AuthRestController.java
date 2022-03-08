package projet.AppliSport.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import projet.AppliSport.exception.CompteException;
import projet.AppliSport.model.Admin;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Compte;
import projet.AppliSport.model.CompteRepository;
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.services.CustomUserDetailsService;



@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="*")
public class AuthRestController {
	
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@GetMapping("")
	public void auth(@AuthenticationPrincipal Compte user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getAuthorities());
	}
	
	@PostMapping("/inscription/utilisateur")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Utilisateur create (@Valid @RequestBody Utilisateur utilisateur, BindingResult br) {
		if(br.hasErrors()) {
			throw new CompteException();
		}
		return (Utilisateur) customUserDetailsService.createOrUpdate(utilisateur);
	}
	
	@PostMapping("/inscription/club")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Club create (@Valid @RequestBody Club club, BindingResult br) {
		if(br.hasErrors()) {
			throw new CompteException();
		}
		return (Club) customUserDetailsService.createOrUpdate(club);
	}
	
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
