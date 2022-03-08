package projet.AppliSport.services;

import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.ClubException;
import projet.AppliSport.exception.UtilisateurException;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Equipe;
import projet.AppliSport.model.Evenement;
import projet.AppliSport.model.Sport;
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
	private EquipeService equipeService;
	
	@Autowired
	private EvenementService evenementService;
	
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

	
	
	
	public List<Club> getAll() {
		return clubRepository.findAll();
	}
	public List<Club> getAllOrderByClubNom() {
		return clubRepository.findAllByOrderByClubNom();
	}
	public List<Club> getAllOrderBySportClub() {
		return clubRepository.findAllByOrderBySportClub();
	}
	public List<Club> getAllOrderByVille() {
		return clubRepository.findAllByOrderByVille();
	}
	public List<Club> getAllOrderByCodePostal() {
		return clubRepository.findAllByOrderByCodePostal();
	}
	
	
	
	public Club getById(Long id) {
		return clubRepository.findById(id).orElseThrow(()->{
			throw new ClubException("club inconnu");
		});
	}
	public List<Club> getByClubNom(String nom) {
		return clubRepository.findByClubNom(nom);
	}
	
	public List<Club> getBySportClub(Sport sport) {
		return clubRepository.findBySportClub(sport);
	}
	
	public List<Club> getBySportNom(String sport) {
		return clubRepository.findBySportNom(sport);
	}
	
	public List<Club> getByListeSport(List<Sport> sports) {
		List<Club>clubs = null;
		for (Sport s:sports) {
			clubs.addAll(getBySportClub(s));
		}
		return clubs;
	}
	
	
	public List<Club> getByVille(String ville) {
		return clubRepository.findByVille(ville);
	}
	public List<Club> getByCodePostal(String cp) {
		return clubRepository.findByCodePostal(cp);
	}
	
	
	
	
	
	
	public Club getByIdWithEquipe(Long id) {
		return clubRepository.findByIdWithEquipe(id).orElseThrow(ClubException::new);
	}
	
	public Club getByIdWithEvenement(Long id) {
		return clubRepository.findByIdWithEvenement(id).orElseThrow(ClubException::new);
	}
	
	public Club getByIdWithUtilisateur(Long id) {

		return clubRepository.findByIdWithUtilisateur(id).orElseThrow(ClubException::new);

	}
	

	public Club getByIdWithClubUtilisateurOrderByDateDebutAsc(Long id) {
		
		return clubRepository.findByIdWithClubUtilisateurOrderByDateDebutAsc(id).orElseThrow(ClubException::new);
	}

	public Club getByIdWithClubUtilisateurOrderByDateDebutDesc(Long id) {
		return clubRepository.findByIdWithClubUtilisateurOrderByDateDebutDesc(id).orElseThrow(ClubException::new);
	}
	
	public Club getByIdWithClubUtilisateurOrderByDateFinAsc(Long id) {
		return clubRepository.findByIdWithClubUtilisateurOrderByDateFinAsc(id).orElseThrow(ClubException::new);
	}

	public Club getByIdWithClubUtilisateurOrderByDateFinDesc(Long id) {
		return clubRepository.findByIdWithClubUtilisateurOrderByDateFinDesc(id).orElseThrow(ClubException::new);
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
			clubEnBase=this.getById(club.getId());
			clubEnBase.setIdentifiant(club.getIdentifiant());
			clubEnBase.setMdp(club.getMdp());
			clubEnBase.setMail(club.getMail());
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
		List<Equipe> equipes = equipeRepository.findByClub(club);
		//equipes.stream().map(equipeService)
		for (Equipe e:equipes) {
			equipeService.delete(e);
		}
		List<Evenement> evenements = evenementRepository.findByClub(club);
		for (Evenement ev:evenements) {
			evenementService.delete(ev);
		}
		
		clubRepository.delete(clubEnBase);
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}



}
