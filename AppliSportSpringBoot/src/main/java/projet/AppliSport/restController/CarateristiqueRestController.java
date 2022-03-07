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

import projet.AppliSport.exception.CaracteristiqueException;
import projet.AppliSport.model.Caracteristique;
import projet.AppliSport.services.CaracteristiqueService;
import projet.AppliSport.views.Views;

@RestController
@RequestMapping("/api/caracteristique")
@CrossOrigin(origins="*")
public class CarateristiqueRestController {

	@Autowired
	private CaracteristiqueService caracteristiqueService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Caracteristique> getAll() {
		List<Caracteristique> caracteristiques = caracteristiqueService.getAll();
		return caracteristiques;
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Caracteristique getById(@PathVariable Long id) {
		return caracteristiqueService.getById(id);
	}
	
	@GetMapping("/{id}/profil")
	@JsonView(Views.CaracteristiqueWithProfil.class)
	public Caracteristique getByIdWithProfil(@PathVariable Long id) {
		return caracteristiqueService.getByIdWithProfil(id);
	}




	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Caracteristique create(@Valid @RequestBody Caracteristique caracteristique, BindingResult br) {
		if (br.hasErrors()) {
			throw new CaracteristiqueException();
		}
		return caracteristiqueService.createOrUpdate(caracteristique);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Caracteristique update(@PathVariable Long id, @Valid @RequestBody Caracteristique caracteristique, BindingResult br) {
		if (caracteristique.getId() == null || id != caracteristique.getId() || br.hasErrors()) {
			throw new CaracteristiqueException();
		}
		return caracteristiqueService.createOrUpdate(caracteristique);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		caracteristiqueService.deleteById(id);
	}

}
