package projet.AppliSport.services;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.ProfilException;
import projet.AppliSport.model.Profil;
import projet.AppliSport.model.Sexe;
import projet.AppliSport.repositories.ProfilRepository;
import projet.AppliSport.repositories.UtilisateurRepository;


@Service
public class ProfilService {

	@Autowired
	private ProfilRepository profilRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private Validator validator;
	
	
	public List<Profil> getAll()
	{
		return profilRepository.findAll();
	}
	
	public List<Profil> getByPoids(double poids)
	{
		return profilRepository.findByPoids(poids);
	}
	public List<Profil> getByPoidsGreaterThan(double poids)
	{
		return profilRepository.findByPoidsGreaterThanEqual(poids);
	}
	public List<Profil> getByPoidsLesserThan(double poids)
	{
		return profilRepository.findByPoidsLessThan(poids);
	}
	
	public List<Profil> getByTaille(double taille)
	{
		return profilRepository.findByTaille(taille);
	}
	public List<Profil> getByTailleGreaterThan(double taille)
	{
		return profilRepository.findByTailleGreaterThanEqual(taille);
	}
	public List<Profil> getByTailleLesserThan(double taille)
	{
		return profilRepository.findByTailleLessThan(taille);
	}
	
	public List<Profil> getByDateNaissance(LocalDate dateNaissance)
	{
		return profilRepository.findByDateNaissance(dateNaissance);
	}
	public List<Profil> getByDateNaissanceGreaterThan(LocalDate dateNaissance)
	{
		return profilRepository.findByDateNaissanceGreaterThanEqual(dateNaissance);
	}
	public List<Profil> getByDateNaissanceLesserThan(LocalDate dateNaissance)
	{
		return profilRepository.findByDateNaissanceLessThan(dateNaissance);
	}
	
	public List<Profil> getBySexe(Sexe sexe){
		return profilRepository.findBySexe(sexe);
	}

	

	
	public Profil getById(Long id)
	{
		return profilRepository.findById(id).orElseThrow(() -> {
			throw new ProfilException("profil inconnu");
		});
	}
	

	public Profil getByIdWithUtilisateur(Long id) {
		return profilRepository.findByIdWithUtilisateur(id).orElseThrow(ProfilException::new);
	}
	
	
	private void checkData(Profil profil)
	{
		if(!validator.validate(profil).isEmpty()) {
			throw new ProfilException();
		}
	}
	
	public Profil createOrUpdate(Profil profil)
	{
		if (profil==null)
		{
			throw new ProfilException("profil non saisi");
		}
		
		checkData(profil);
		
		Profil profilEnBase=new Profil();
		
		if (profil.getId()==null)
		{
			return profilRepository.save(profil);
		}
		
		else
		{
			profilEnBase=this.getById(profil.getId());
			profilEnBase.setPoids(profil.getPoids());
			profilEnBase.setTaille(profil.getTaille());
			profilEnBase.setDateNaissance(profil.getDateNaissance());
			profilEnBase.setSexe(profil.getSexe());
			profilEnBase.setCaracteristique(profil.getCaracteristique());
			profilEnBase.setUtilisateur(profil.getUtilisateur());
			
			return profilRepository.save(profilEnBase);
		}
	}
	
	public void delete (Profil profil)
	{
		if (profil==null)
		{
			throw new ProfilException("profil non saisi");
		}
		
		if (profil.getId()==null)
		{
			throw new ProfilException("profil sans id !!");
		}
		
		Profil profilEnBase=profilRepository.findById(profil.getId()).orElseThrow(ProfilException::new);	
		utilisateurRepository.setProfilToNull(profilEnBase);
		profilRepository.delete(profilEnBase);
		
	
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}




	
}
