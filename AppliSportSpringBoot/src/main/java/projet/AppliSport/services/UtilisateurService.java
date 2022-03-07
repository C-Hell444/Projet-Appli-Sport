package projet.AppliSport.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.UtilisateurException;
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
	
	
	public Utilisateur getById(Long id) {
		return utilisateurRepository.findById(id).orElseThrow(()->{
			throw new UtilisateurException("Utilisateur inconnu");
		});
	}
	
	public Utilisateur getByIdWithClubUtilisateur(Long id) {
		return utilisateurRepository.findByIdWithClubUtilisateur(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithEvenementUtilisateur(Long id) {
		return utilisateurRepository.findByIdWithEvenementUtilisateur(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithEquipeUtilisateur(Long id) {
		return utilisateurRepository.findByIdWithEquipeUtilisateur(id).orElseThrow(UtilisateurException::new);
	}
	
	public Utilisateur getByIdWithInteret(Long id) {
		return utilisateurRepository.findByIdWithInterets(id).orElseThrow(UtilisateurException::new);
	}
	
	public List<Utilisateur> getAll() {
		return utilisateurRepository.findAll();
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
