package projet.AppliSport.services;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.EquipeException;
import projet.AppliSport.exception.EvenementException;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Equipe;
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

	
	public List<Evenement> getAll() {
		return evenementRepository.findAll();
	}
	public List<Evenement> getAllOrderById() {
		return evenementRepository.findAllByOrderById();
	}
	
	public List<Evenement> getAllOrderByNom() {
		return evenementRepository.findAllByOrderByNom();
	}
	public List<Evenement> getAllOrderByClub() {
		return evenementRepository.findAllByOrderByClub();
	}
	
	public List<Evenement> getAllOrderByDateDebut() {
		return evenementRepository.findAllByOrderByDateDebut();
	}
	public List<Evenement> getAllOrderByDateFin() {
		return evenementRepository.findAllByOrderByDateFin();
	}
	
	public List<Evenement> getByNom(String nom) {
		return evenementRepository.findByNom(nom);
	}
	public List<Evenement> getByClubNom(String nom) {
		return evenementRepository.findByClubNom(nom);
	}
	public List<Evenement> getByClub(Club club) {
		return evenementRepository.findByClub(club);
	}
	
	public List<Evenement> getByDateFutur(LocalDate date) {
		return evenementRepository.findByDateDebutGreaterThanEqual(date);
	}
	public List<Evenement> getByDatePasse(LocalDate date) {
		return evenementRepository.findByDateFinLessThanEqual(date);
	}
	
	
	public Evenement getById(Long id) {
		return evenementRepository.findById(id).orElseThrow(()->{
			throw new EvenementException("evenement inconnu");
		});
	}
	
	
	public Evenement getByIdWithUtilisateur(Long id) {
		return evenementRepository.findByIdWithUtilisateur(id).orElseThrow(EvenementException::new);
	}
	
	public Evenement getByIdWithEvenementUtilisateurOrderByDateDebutAsc(Long id) {
		return evenementRepository.findByIdWithEvenementUtilisateurOrderByDateDebutAsc(id).orElseThrow(EvenementException::new);
	}
	public Evenement getByIdWithEvenementUtilisateurOrderByDateDebutDesc(Long id) {
		return evenementRepository.findByIdWithEvenementUtilisateurOrderByDateDebutDesc(id).orElseThrow(EvenementException::new);
	}
	public Evenement getByIdWithEvenementUtilisateurOrderByDateFinAsc(Long id) {
		return evenementRepository.findByIdWithEvenementUtilisateurOrderByDateFinAsc(id).orElseThrow(EvenementException::new);
	}
	public Evenement getByIdWithEvenementUtilisateurOrderByDateFinDesc(Long id) {
		return evenementRepository.findByIdWithEvenementUtilisateurOrderByDateFinDesc(id).orElseThrow(EvenementException::new);
	}
	
	
	private void checkdata(Evenement evenement) {
		if (!validator.validate(evenement).isEmpty()) {
			throw new EvenementException();
		}
		if(evenement.getDateDebut().isAfter(evenement.getDateFin())&&evenement.getDateDebut()!=null&&evenement.getDateFin()!=null) {
			throw new EvenementException("dateDebut>dateFin");
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
			throw new EvenementException("Suppression d'une evenement sans id");
		}
		Evenement evenementEnBase = this.getById(evenement.getId());
		evenementUtilisateurRepository.deleteEvenementUtilisateurByEvenement(evenementEnBase);
		evenementRepository.delete(evenementEnBase);
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}
	




}
