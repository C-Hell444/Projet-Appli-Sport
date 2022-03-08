package projet.AppliSport.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.EvenementException;
import projet.AppliSport.exception.EvenementUtilisateurException;
import projet.AppliSport.model.EvenementUtilisateur;
import projet.AppliSport.model.EvenementUtilisateurKey;
import projet.AppliSport.repositories.EvenementUtilisateurRepository;

@Service
public class EvenementUtilisateurService {

	@Autowired
	EvenementUtilisateurRepository evenementUtilisateurRepository;

	@Autowired
	private Validator validator;

	public EvenementUtilisateur getById(EvenementUtilisateurKey evenementUtilisateurKey) {
		return evenementUtilisateurRepository.findById(evenementUtilisateurKey).orElseThrow(() -> {
			throw new EvenementUtilisateurException("evenementutilisateur inconnu");
		});
	}

	public List<EvenementUtilisateur> getAll() {
		return evenementUtilisateurRepository.findAll();
	}

	private void checkData(EvenementUtilisateur evenementUtilisateur) {
		if (!validator.validate(evenementUtilisateur).isEmpty()) {
			throw new EvenementUtilisateurException("erreur de validation");
		}
		if (evenementUtilisateur.getDateDebut() != null && evenementUtilisateur.getDateFin() != null) {
			if (evenementUtilisateur.getDateDebut().isAfter(evenementUtilisateur.getDateFin())) {
				throw new EvenementUtilisateurException("dateDebut>dateFin");
			}
		}
	}

	public EvenementUtilisateur createOrUpdate(EvenementUtilisateur evenementUtilisateur) {
		if (evenementUtilisateur == null) {
			throw new EvenementUtilisateurException("evenementutilisateur non saisi");
		}
		checkData(evenementUtilisateur);
		EvenementUtilisateur evenementUtilisateurEnBase = new EvenementUtilisateur();
		try {
			evenementUtilisateurEnBase = this.getById(evenementUtilisateur.getId());
			evenementUtilisateurEnBase.setDateDebut(evenementUtilisateur.getDateDebut());
			evenementUtilisateurEnBase.setDateFin(evenementUtilisateur.getDateFin());
			return evenementUtilisateurRepository.save(evenementUtilisateurEnBase);
		} catch (EvenementUtilisateurException e) {
			return evenementUtilisateurRepository.save(evenementUtilisateur);
		}
	}

	public void delete(EvenementUtilisateur evenementUtilisateur) {
		if (evenementUtilisateur == null) {
			throw new EvenementUtilisateurException("evenementutilisateur non saisi");
		}
		if (evenementUtilisateur.getId().getEvenement().getId() == null
				|| evenementUtilisateur.getId().getUtilisateur().getId() == null) {
			throw new EvenementUtilisateurException("suppression d'un evenementutilisateur invalide");
		}
		EvenementUtilisateur evenementUtilisateurEnBase = getById(evenementUtilisateur.getId());
		evenementUtilisateurRepository.delete(evenementUtilisateurEnBase);
	}

	public void deleteById(EvenementUtilisateurKey evenementUtilisateurKey) {
		delete(getById(evenementUtilisateurKey));
	}

}
