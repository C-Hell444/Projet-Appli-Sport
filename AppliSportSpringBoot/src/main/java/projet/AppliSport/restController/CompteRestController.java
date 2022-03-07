package projet.AppliSport.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import projet.AppliSport.model.Compte;
import projet.AppliSport.services.CompteService;
import projet.AppliSport.views.Views;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins="*")
public class CompteRestController {

	@Autowired
	private CompteService compteService;
	
	@GetMapping("/{identifiant}")
	@JsonView(Views.Common.class)
	public Compte getByIdentifiant(@PathVariable String identifiant) {
		return compteService.getByIdentifiant(identifiant);
	}
}
