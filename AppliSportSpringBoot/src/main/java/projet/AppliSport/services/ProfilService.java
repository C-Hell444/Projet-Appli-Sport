package projet.AppliSport.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.ProfilException;
import projet.AppliSport.model.Profil;
import projet.AppliSport.repositories.ProfilRepository;


@Service
public class ProfilService {

	@Autowired
	private ProfilRepository profilRepository;
	
	@Autowired
	private Validator validator;
	
	
	public List<Profil> getAll()
	{
		return profilRepository.findAll();
	}

	
	public Profil getById(Long id)
	{
		return profilRepository.findById(id).orElseThrow(() -> {
			throw new ProfilException("profil inconnu");
		});
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
		profilRepository.deleteProfilByUtilisateur(profilEnBase.getUtilisateur());
		
//		profilRepository.delete(profilEnBase);
		
	
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}

}
