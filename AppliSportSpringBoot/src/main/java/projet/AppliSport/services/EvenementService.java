package projet.AppliSport.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.EquipeException;
import projet.AppliSport.exception.EvenementException;
import projet.AppliSport.model.Evenement;
import projet.AppliSport.repositories.EvenementRepository;
import projet.AppliSport.repositories.EvenementUtilisateurRepository;


@Service
public class EvenementService {
	@Autowired
	private Validator validator;
	
	@Autowired
	private EvenementUtilisateurRepository evenementUtilisateurRepository;
		
	@Autowired
	private EvenementRepository evenementRepository;

	public Evenement getById(Long id) {
		return evenementRepository.findById(id).orElseThrow(()->{
			throw new EvenementException("evenement inconnu");
		});
	}
	public List<Evenement> getAll() {
		return evenementRepository.findAll();
	}
	
	private void checkdata(Evenement evenement) {
		if (!validator.validate(evenement).isEmpty()) {
			throw new EvenementException();
		}
	}
	
	public Evenement createOrUpdate(Evenement evenement) {
		if(evenement==null) {
			throw new EvenementException("evenement non saisi");
		}
		checkdata(evenement);
		Evenement evenementEnBase = new Evenement();
		if(evenement.getId()==null) {
			return evenementRepository.save(evenement);
		}
		else {
			evenementEnBase=this.getById(evenement.getId());
			evenementEnBase.setNom(evenement.getNom());
			evenementEnBase.setClub(evenement.getClub());	
			return evenementRepository.save(evenementEnBase);
		
		}
	}
	public void delete(Evenement evenement) {
		if (evenement==null) {
			throw new EvenementException("Evenement non saisi");
		}
		if (evenement.getId()==null) {
			throw new EquipeException("Suppression d'une evenement sans id");
		}
		Evenement evenementEnBase = this.getById(evenement.getId());
		evenementUtilisateurRepository.deleteEvenementUtilisateurByEvenement(evenementEnBase);
		evenementRepository.delete(evenementEnBase);
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}




}