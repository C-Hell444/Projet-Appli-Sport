package projet.AppliSport.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import projet.AppliSport.exception.CompteException;
import projet.AppliSport.model.Compte;
import projet.AppliSport.services.CustomUserDetailsService;



@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
	
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@GetMapping("")
	public void auth(@AuthenticationPrincipal Compte user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getAuthorities());
	}
	
	@PostMapping("/inscription")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Compte create (@Valid @RequestBody Compte utilisateur, BindingResult br) {
		if(br.hasErrors()) {
			throw new CompteException();
		}
		return customUserDetailsService.createOrUpdate(utilisateur);
	}
	
	

}
