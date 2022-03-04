package projet.AppliSport.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.SportException;
import projet.AppliSport.model.Sport;
import projet.AppliSport.repositories.ClubRepository;
import projet.AppliSport.repositories.InteretRepository;
import projet.AppliSport.repositories.SportRepository;

@Service
public class SportService {

	@Autowired
	private SportRepository sportRepo;
	
	@Autowired
	private InteretRepository interetRepository;
	
	@Autowired
	private ClubRepository clubRepository;
	
	@Autowired
	private Validator validator;

	public List<Sport> getAll() {
		return sportRepo.findAll();
	}

	public Sport getById(Long id) {
		return sportRepo.findById(id).orElseThrow(() -> {
			throw new SportException("sport non reconnu");
		});
	}
	public Sport getByIdWithClub(Long id) {
		return sportRepo.findByIdWithClub(id).orElseThrow(SportException::new);
	}

	public Sport getByIdWithInteret(Long id) {
		return sportRepo.findByIdWithInteret(id).orElseThrow(SportException::new);
	}
	
	public Sport createOrUpdate(Sport sport) {
		if (sport == null) {
			throw new SportException();
		}
		Sport sportEnBase = null;
		if (sport.getId() == null) {
			checkData(sport);
			return sportRepo.save(sport);
		} else {
			sportEnBase = this.getById(sport.getId());
			checkData(sport);
			sportEnBase.setNom(sport.getNom());
			sportEnBase.setClubs(sport.getClubs());
			sportEnBase.setInterets(sport.getInterets());
			return sportRepo.save(sportEnBase);
		}
	}

	private void checkData(Sport sport) {
		if(!validator.validate(sport).isEmpty()) {
			throw new SportException("erreur de validation");
		}
	}

	public void delete(Sport sport) {
		if (sport==null) {
			throw new SportException("Sport non saisi");
		}
		if (sport.getId()==null) {
			throw new SportException("Suppression d'un sport sans id");
		}
		Sport sportEnBase = sportRepo.findById(sport.getId()).orElseThrow(SportException::new);
		
		interetRepository.deleteInteretBySport(sportEnBase);
		clubRepository.setSportToNull(sportEnBase);
		sportRepo.delete(sportEnBase);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}

	

}
