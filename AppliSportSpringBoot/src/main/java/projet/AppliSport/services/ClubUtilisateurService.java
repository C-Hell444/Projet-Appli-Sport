package projet.AppliSport.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.ClubUtilisateurException;
import projet.AppliSport.exception.EvenementUtilisateurException;
import projet.AppliSport.model.ClubUtilisateur;
import projet.AppliSport.model.ClubUtilisateurKey;
import projet.AppliSport.repositories.ClubUtilisateurRepository;

@Service
public class ClubUtilisateurService {

	@Autowired
	ClubUtilisateurRepository clubUtilisateurRepository;

	@Autowired
	private Validator validator;

	public ClubUtilisateur getById(ClubUtilisateurKey clubUtilisateurKey) {
		return clubUtilisateurRepository.findById(clubUtilisateurKey).orElseThrow(() -> {
			throw new ClubUtilisateurException("clubutilisateur inconnu");
		});
	}
	
	
	public List<ClubUtilisateur> getAll() {
		return clubUtilisateurRepository.findAll();
	}

	private void checkData(ClubUtilisateur clubUtilisateur) {
		if (!validator.validate(clubUtilisateur).isEmpty()) {
			throw new ClubUtilisateurException("erreur de validation");
		}
		if (clubUtilisateur.getDateDebut() != null && clubUtilisateur.getDateFin() != null) {
			if (clubUtilisateur.getDateDebut().isAfter(clubUtilisateur.getDateFin())) {
				throw new ClubUtilisateurException("dateDebut>dateFin");
			}
		}
	}

	public ClubUtilisateur createOrUpdate(ClubUtilisateur clubUtilisateur) {
		if (clubUtilisateur == null) {
			throw new ClubUtilisateurException("clubutilisateur non saisi");
		}
		checkData(clubUtilisateur);
		ClubUtilisateur clubUtilisateurEnBase = new ClubUtilisateur();
		try {
			clubUtilisateurEnBase = this.getById(clubUtilisateur.getClubUtilisateurKey());
			clubUtilisateurEnBase.setDateDebut(clubUtilisateur.getDateDebut());
			clubUtilisateurEnBase.setDateFin(clubUtilisateur.getDateFin());
			return clubUtilisateurRepository.save(clubUtilisateurEnBase);
		} catch (ClubUtilisateurException e) {
			return clubUtilisateurRepository.save(clubUtilisateur);
		}
	}

	public void delete(ClubUtilisateur clubUtilisateur) {
		if (clubUtilisateur == null) {
			throw new ClubUtilisateurException("clubutilisateur non saisi");
		}
		if (clubUtilisateur.getClubUtilisateurKey().getClub().getId() == null
				|| clubUtilisateur.getClubUtilisateurKey().getUtilisateur().getId() == null) {
			throw new ClubUtilisateurException("suppression d'un clubutilisateur invalide");
		}
		ClubUtilisateur clubUtilisateurEnBase = getById(clubUtilisateur.getClubUtilisateurKey());
		clubUtilisateurRepository.delete(clubUtilisateurEnBase);
	}

	public void deleteById(ClubUtilisateurKey clubUtilisateurKey) {
		delete(getById(clubUtilisateurKey));
	}

	

}
