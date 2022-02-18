package projet.AppliSport.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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


import projet.AppliSport.exception.SportException;
import projet.AppliSport.model.Sport;
import projet.AppliSport.services.SportService;
import projet.AppliSport.views.ViewsSport;

@RestController
@RequestMapping("/api/sport")
public class SportRestController {

	@Autowired
	private SportService sportService;
	
	@GetMapping("")
	@JsonView(ViewsSport.Common.class)
	public List<Sport> getAll(){
		return sportService.getAll();
	}
	
	
	@GetMapping("/{id}")
	@JsonView(ViewsSport.Common.class)
	public Sport getById(@PathVariable Long id) {
		return sportService.getById(id);
	}
	
	
	
	@PostMapping("")
	@JsonView(ViewsSport.Common.class)
	@ResponseStatus(code=HttpStatus.CREATED)
	public Sport create (@Valid @RequestBody Sport Sport, BindingResult br) {
		if(br.hasErrors()) {
			throw new SportException();
		}
		return sportService.createOrUpdate(Sport);
	}

	@PutMapping("/{id}")
	@JsonView(ViewsSport.Common.class)
	public Sport update(@PathVariable Long id, @Valid @RequestBody Sport sport, BindingResult br) {
		
		sportService.getById(id);
		
		if(sport.getId()==null || id!=sport.getId()||br.hasErrors()) {
			throw new SportException();
		}
		
		return sportService.createOrUpdate(sport);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		sportService.deleteById(id);
	}
	
}
