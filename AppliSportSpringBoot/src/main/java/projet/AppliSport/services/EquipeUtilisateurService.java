package projet.AppliSport.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.EquipeUtilisateurException;
import projet.AppliSport.exception.EvenementUtilisateurException;
import projet.AppliSport.model.EquipeUtilisateur;
import projet.AppliSport.model.EquipeUtilisateurKey;
import projet.AppliSport.repositories.EquipeUtilisateurRepository;

@Service
public class EquipeUtilisateurService {

	@Autowired
	EquipeUtilisateurRepository equipeUtilisateurRepository;

	@Autowired
	private Validator validator;

	public EquipeUtilisateur getById(EquipeUtilisateurKey equipeUtilisateurKey) {
		return equipeUtilisateurRepository.findById(equipeUtilisateurKey).orElseThrow(() -> {
			throw new EquipeUtilisateurException("equipeutilisateur inconnu");
		});
	}
	
	public List<EquipeUtilisateur> getByEquipeId(Long id) {
		return equipeUtilisateurRepository.findByEquipeId(id);
	}


	public List<EquipeUtilisateur> getAll() {
		return equipeUtilisateurRepository.findAll();
	}
	

	private void checkData(EquipeUtilisateur equipeUtilisateur) {
		if (!validator.validate(equipeUtilisateur).isEmpty()) {
			throw new EquipeUtilisateurException("erreur de validation");
		}
		if (equipeUtilisateur.getDateDebut() != null && equipeUtilisateur.getDateFin() != null) {
			if (equipeUtilisateur.getDateDebut().isAfter(equipeUtilisateur.getDateFin())) {
				throw new EquipeUtilisateurException("dateDebut>dateFin");
			}

		}
	}

	public EquipeUtilisateur createOrUpdate(EquipeUtilisateur equipeUtilisateur) {
		if (equipeUtilisateur == null) {
			throw new EquipeUtilisateurException("equipeutilisateur non saisi");
		}
		checkData(equipeUtilisateur);
		EquipeUtilisateur equipeUtilisateurEnBase = new EquipeUtilisateur();
		try {
			equipeUtilisateurEnBase = this.getById(equipeUtilisateur.getEquipeUtilisateurKey());
			equipeUtilisateurEnBase.setDateDebut(equipeUtilisateur.getDateDebut());
			equipeUtilisateurEnBase.setDateFin(equipeUtilisateur.getDateFin());
			return equipeUtilisateurRepository.save(equipeUtilisateurEnBase);
		} catch (EquipeUtilisateurException e) {
			return equipeUtilisateurRepository.save(equipeUtilisateur);
		}
	}

	public void delete(EquipeUtilisateur equipeUtilisateur) {
		if (equipeUtilisateur == null) {
			throw new EquipeUtilisateurException("equipeutilisateur non saisi");
		}
		if (equipeUtilisateur.getEquipeUtilisateurKey().getEquipe().getId() == null
				|| equipeUtilisateur.getEquipeUtilisateurKey().getUtilisateur().getId() == null) {
			throw new EquipeUtilisateurException("suppression d'un equipeutilisateur invalide");
		}
		EquipeUtilisateur equipeUtilisateurEnBase = getById(equipeUtilisateur.getEquipeUtilisateurKey());
		equipeUtilisateurRepository.delete(equipeUtilisateurEnBase);
	}

	public void deleteById(EquipeUtilisateurKey equipeUtilisateurKey) {
		delete(getById(equipeUtilisateurKey));
	}


	

}
