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

import projet.AppliSport.exception.InteretException;
import projet.AppliSport.model.Interet;
import projet.AppliSport.services.InteretService;
import projet.AppliSport.views.Views;

@RestController
@RequestMapping("/api/interet")
@CrossOrigin(origins="*")
public class InteretRestController {

	@Autowired
	private InteretService interetService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Interet> getAll() {
		List<Interet> interets = interetService.getAll();
		return interets;
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Interet getById(@PathVariable Long id) {
		return interetService.getById(id);
	}



	@PostMapping("")
	@JsonView(Views.Common.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Interet create(@Valid @RequestBody Interet interet, BindingResult br) {
		if (br.hasErrors()) {
			throw new InteretException();
		}
		return interetService.createOrUpdate(interet);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Interet update(@PathVariable Long id, @Valid @RequestBody Interet interet, BindingResult br) {
		if (interet.getId() == null || id != interet.getId() || br.hasErrors()) {
			throw new InteretException();
		}
		return interetService.createOrUpdate(interet);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		interetService.deleteById(id);
	}

}
