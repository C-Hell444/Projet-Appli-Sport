package projet.AppliSport.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.ClubException;
import projet.AppliSport.exception.EquipeException;
import projet.AppliSport.model.Equipe;
import projet.AppliSport.repositories.EquipeRepository;
import projet.AppliSport.repositories.EquipeUtilisateurRepository;


@Service
public class EquipeService {
	@Autowired
	private Validator validator;
	
	@Autowired
	private EquipeUtilisateurRepository equipeUtilisateurRepository;
		
	@Autowired
	private EquipeRepository equipeRepository;

	public Equipe getById(Long id) {
		return equipeRepository.findById(id).orElseThrow(()->{
			throw new EquipeException("equipe inconnu");
		});
	}
	
	public Equipe getByIdWithUtilisateur(Long id) {
		return equipeRepository.findByIdWithUtilisateur(id).orElseThrow(EquipeException::new);
	}
	public List<Equipe> getAll() {
		return equipeRepository.findAll();
	}
	
	private void checkdata(Equipe equipe) {
		if (!validator.validate(equipe).isEmpty()) {
			throw new EquipeException();
		}
	}
	
	public Equipe createOrUpdate(Equipe equipe) {
		if(equipe==null) {
			throw new EquipeException("equipe non saisi");
		}
		checkdata(equipe);
		Equipe equipeEnBase = new Equipe();
		if(equipe.getId()==null) {
			return equipeRepository.save(equipe);
		}
		else {
			equipeEnBase=this.getById(equipe.getId());
			equipeEnBase.setNom(equipe.getNom());
			equipeEnBase.setClub(equipe.getClub());	
			return equipeRepository.save(equipeEnBase);
		
		}
	}
	public void delete(Equipe equipe) {
		if (equipe==null) {
			throw new EquipeException("Equipe non saisi");
		}
		if (equipe.getId()==null) {
			throw new EquipeException("Suppression d'une equipe sans id");
		}
		Equipe equipeEnBase = this.getById(equipe.getId());
		equipeUtilisateurRepository.deleteEquipeUtilisateurByEquipe(equipeEnBase);
		equipeRepository.delete(equipeEnBase);
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}
	

}
