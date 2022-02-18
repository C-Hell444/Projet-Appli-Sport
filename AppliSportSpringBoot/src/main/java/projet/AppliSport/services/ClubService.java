package projet.AppliSport.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.ClubException;
import projet.AppliSport.exception.UtilisateurException;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.repositories.ClubRepository;
import projet.AppliSport.repositories.ClubUtilisateurRepository;
import projet.AppliSport.repositories.EquipeRepository;
import projet.AppliSport.repositories.EquipeUtilisateurRepository;
import projet.AppliSport.repositories.EvenementRepository;
import projet.AppliSport.repositories.EvenementUtilisateurRepository;
import projet.AppliSport.repositories.UtilisateurRepository;


@Service
public class ClubService {
	@Autowired
	private Validator validator;
	
	@Autowired
	private ClubRepository clubRepository;
	
	@Autowired
	private ClubUtilisateurRepository clubUtilisateurRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	@Autowired
	private EvenementRepository evenementRepository;
	
	@Autowired
	private EquipeUtilisateurRepository equipeUtilisateurRepository;
	
	@Autowired
	private EvenementUtilisateurRepository evenementUtilisateurRepository;

	public Club getById(Long id) {
		return clubRepository.findById(id).orElseThrow(()->{
			throw new ClubException("club inconnu");
		});
	}
	public List<Club> getAll() {
		return clubRepository.findAll();
	}
	
	private void checkdata(Club club) {
		if (!validator.validate(club).isEmpty()) {
			throw new ClubException();
		}
	}
	
	public Club createOrUpdate(Club club) {
		if(club==null) {
			throw new ClubException("club non saisi");
		}
		checkdata(club);
		Club clubEnBase = new Club();
		if(club.getId()==null) {
			return clubRepository.save(club);
		}
		else {
			
			clubEnBase.setNumTel(club.getNumTel());
			clubEnBase.setClubNom(club.getClubNom());
			clubEnBase.setAdresse(club.getAdresse());
			clubEnBase.setSportClub(club.getSportClub());
			
			return clubRepository.save(clubEnBase);
		
		}
	}
	public void delete(Club club) {
		if (club==null) {
			throw new ClubException("Club non saisi");
		}
		if (club.getId()==null) {
			throw new UtilisateurException("Suppression d'un club sans id");
		}
		Club clubEnBase = this.getById(club.getId());
		clubUtilisateurRepository.deleteClubUtilisateurByClub(clubEnBase);
		evenementUtilisateurRepository.deleteEvenementUtilisateurByClub(clubEnBase);
		equipeUtilisateurRepository.deleteEquipeUtilisateurByClub(clubEnBase);
		utilisateurRepository.deleteUtilisateurByClub(clubEnBase);
		equipeRepository.deleteEquipeByClub(clubEnBase);
		evenementRepository.deleteEvenementByClub(clubEnBase);
		clubRepository.delete(clubEnBase);
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}

}