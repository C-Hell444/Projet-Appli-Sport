package projet.AppliSport.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.UtilisateurException;
import projet.AppliSport.model.Club;
import projet.AppliSport.model.Profil;
import projet.AppliSport.model.Sport;
import projet.AppliSport.model.Utilisateur;
import projet.AppliSport.repositories.ClubUtilisateurRepository;
import projet.AppliSport.repositories.EquipeUtilisateurRepository;
import projet.AppliSport.repositories.EvenementUtilisateurRepository;
import projet.AppliSport.repositories.InteretRepository;
import projet.AppliSport.repositories.ProfilRepository;
import projet.AppliSport.repositories.UtilisateurRepository;


@Service
public class UtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private ClubUtilisateurRepository clubUtilisateurRepository;
	
	@Autowired
	private EquipeUtilisateurRepository equipeUtilisateurRepository;
	
	@Autowired
	private EvenementUtilisateurRepository evenementUtilisateurRepository;
	
	@Autowired
	private InteretRepository interetRepository;
	
	@Autowired
	private ProfilRepository profilRepository;
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public List<Utilisateur> getAll() {
		return utilisateurRepository.findAll();
	}
	public List<Utilisateur> getAllOrderById() {
		return utilisateurRepository.findAllByOrderById();
	}
	public List<Utilisateur> getAllOrderByNom() {
		return utilisateurRepository.findAllByOrderByNom();
	}
	public List<Utilisateur> getAllOrderByPrenom() {
		return utilisateurRepository.findAllByOrderByPrenom();
	}
	public List<Utilisateur> getAllOrderByNumTel() {
		return utilisateurRepository.findAllByOrderByNumTel();
	}
	public List<Utilisateur> getAllOrderByVille() {
		return utilisateurRepository.findAllByOrderByVille();
	}
	public List<Utilisateur> getAllOrderByCodePostal() {
		return utilisateurRepository.findAllByOrderByCodePostal();
	}
	
	
	public List<Utilisateur> getByNom(String nom) {
		return utilisateurRepository.findByNom(nom);
	}
	public List<Utilisateur> getByPrenom(String prenom) {
		return utilisateurRepository.findByPrenom(prenom);
	}
	public List<Utilisateur> getByNumTel(String num) {
		return utilisateurRepository.findByNumTel(num);
	}
	public List<Utilisateur> getByVille(String ville) {
		return utilisateurRepository.findByVille(ville);
	}
	public List<Utilisateur> getByCodePostal(String cp) {
		return utilisateurRepository.findByCodePostal(cp);
	}
	
	public Utilisateur getByProfilUtilisateur(Profil profil) {
		return utilisateurRepository.findByProfilUtilisateur(profil).orElseThrow(UtilisateurException::new);
	}
	
	public List<Utilisateur> getByListeProfil(List<Profil> profils) {
		List<Utilisateur>clubs = new ArrayList<Utilisateur>();
		for (Profil s:profils) {
			clubs.add(getByProfilUtilisateur(s));
		}
		return clubs;
	}

	
	
	public Utilisateur getById(Long id) {
		return utilisateurRepository.findById(id).orElseThrow(()->{
			throw new UtilisateurException("Utilisateur inconnu");
		});
	}
	
	public Utilisateur getByIdWithClubUtilisateur(Long id) {
		return utilisateurRepository.findByIdWithClubUtilisateur(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithClubUtilisateurOrderByDateDebutAsc(Long id) {
		return utilisateurRepository.findByIdWithClubUtilisateurOrderByDateDebutAsc(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithClubUtilisateurOrderByDateDebutDesc(Long id) {
		return utilisateurRepository.findByIdWithClubUtilisateurOrderByDateDebutDesc(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithClubUtilisateurOrderByDateFinAsc(Long id) {
		return utilisateurRepository.findByIdWithClubUtilisateurOrderByDateFinAsc(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithClubUtilisateurOrderByDateFinDesc(Long id) {
		return utilisateurRepository.findByIdWithClubUtilisateurOrderByDateFinDesc(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithEvenementUtilisateur(Long id) {
		return utilisateurRepository.findByIdWithEvenementUtilisateur(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithEvenementUtilisateurOrderByDateDebutAsc(Long id) {
		return utilisateurRepository.findByIdWithEvenementUtilisateurOrderByDateDebutAsc(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithEvenementUtilisateurOrderByDateDebutDesc(Long id) {
		return utilisateurRepository.findByIdWithEvenementUtilisateurOrderByDateDebutDesc(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithEvenementUtilisateurOrderByDateFinAsc(Long id) {
		return utilisateurRepository.findByIdWithEvenementUtilisateurOrderByDateFinAsc(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithEvenementUtilisateurOrderByDateFinDesc(Long id) {
		return utilisateurRepository.findByIdWithEvenementUtilisateurOrderByDateFinDesc(id).orElseThrow(UtilisateurException::new);
	}
	
	
	public Utilisateur getByIdWithEquipeUtilisateur(Long id) {
		return utilisateurRepository.findByIdWithEquipeUtilisateur(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithEquipeUtilisateurOrderByDateDebutAsc(Long id) {
		return utilisateurRepository.findByIdWithEquipeUtilisateurOrderByDateDebutAsc(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithEquipeUtilisateurOrderByDateDebutDesc(Long id) {
		return utilisateurRepository.findByIdWithEquipeUtilisateurOrderByDateDebutDesc(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithEquipeUtilisateurOrderByDateFinAsc(Long id) {
		return utilisateurRepository.findByIdWithEquipeUtilisateurOrderByDateFinAsc(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithEquipeUtilisateurOrderByDateFinDesc(Long id) {
		return utilisateurRepository.findByIdWithEquipeUtilisateurOrderByDateFinDesc(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithInteret(Long id) {
		return utilisateurRepository.findByIdWithInterets(id).orElseThrow(UtilisateurException::new);
	}
	
	
	
	private void checkData(Utilisateur utilisateur) {
		if(!validator.validate(utilisateur).isEmpty()) {
			throw new UtilisateurException("erreur de validation");
		}
	}
	
	
	public Utilisateur createOrUpdate(Utilisateur utilisateur) {
		if(utilisateur==null) {
			throw new UtilisateurException("Utilisateur non saisi");
		}
		checkData(utilisateur);
		Utilisateur utilisateurEnBase = null;
		if(utilisateur.getId()==null) {
			return utilisateurRepository.save(utilisateur);
		}
		else {
			utilisateurEnBase=this.getById(utilisateur.getId());
			utilisateurEnBase.setNom(utilisateur.getNom());
			utilisateurEnBase.setPrenom(utilisateur.getPrenom());
			utilisateurEnBase.setAdresse(utilisateur.getAdresse());
			utilisateurEnBase.setIdentifiant(utilisateur.getIdentifiant());
			utilisateurEnBase.setMail(utilisateur.getMail());
			utilisateurEnBase.setNumTel(utilisateur.getNumTel());
			utilisateurEnBase.setProfilUtilisateur(utilisateur.getProfilUtilisateur());
			utilisateurEnBase.setEquipes(utilisateur.getEquipes());
			utilisateurEnBase.setEvenements(utilisateur.getEvenements());
			utilisateurEnBase.setInterets(utilisateur.getInterets());
			utilisateurEnBase.setClubs(utilisateur.getClubs());
			if(utilisateur.getMdp()!=passwordEncoder.encode("toto")) {
				utilisateurEnBase.setMdp(utilisateur.getMdp());
			}
			return utilisateurRepository.save(utilisateurEnBase);
		}
	}
	
	public Utilisateur updatePassword(Utilisateur utilisateur) {
		if(utilisateur==null || utilisateur.getId()==null) {
			throw new UtilisateurException("Utilisateur non saisi");
		}
		checkData(utilisateur);
		Utilisateur utilisateurEnBase = getById(utilisateur.getId());
		utilisateurEnBase.setMdp(utilisateur.getMdp());
		return utilisateurRepository.save(utilisateurEnBase);
	}
	
	public void delete(Utilisateur utilisateur) {
		if (utilisateur==null) {
			throw new UtilisateurException("Utilisateur non saisi");
		}
		if (utilisateur.getId()==null) {
			throw new UtilisateurException("Suppression d'un utilisateur sans id");
		}
		Utilisateur utilisateurEnBase = this.getById(utilisateur.getId());
		clubUtilisateurRepository.deleteClubUtilisateurByUtilisateur(utilisateurEnBase);
		evenementUtilisateurRepository.deleteEvenementUtilisateurByUtilisateur(utilisateurEnBase);
		equipeUtilisateurRepository.deleteEquipeUtilisateurByUtilisateur(utilisateurEnBase);
		interetRepository.deleteInteretByUtilisateur(utilisateurEnBase);
		profilRepository.deleteProfilByUtilisateur(utilisateurEnBase);
		utilisateurRepository.delete(utilisateurEnBase);
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}
	

}
