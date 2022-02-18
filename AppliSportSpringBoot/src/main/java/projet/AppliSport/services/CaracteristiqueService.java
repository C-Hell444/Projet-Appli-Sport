package projet.AppliSport.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.CaracteristiqueException;
import projet.AppliSport.model.Caracteristique;
import projet.AppliSport.repositories.CaracteristiqueRepository;


@Service
public class CaracteristiqueService {

	@Autowired
	private CaracteristiqueRepository caracteristiqueRepository;
	
	@Autowired
	private Validator validator;
	
	
	public List<Caracteristique> getAll()
	{
		return caracteristiqueRepository.findAll();
	}

	
	public Caracteristique getById(Long id)
	{
		return caracteristiqueRepository.findById(id).orElseThrow(() -> {
			throw new CaracteristiqueException("caracteristique inconnu");
		});
	}
	
	private void checkData(Caracteristique caracteristique)
	{
		if(!validator.validate(caracteristique).isEmpty()) {
			throw new CaracteristiqueException();
		}
	}
	
	public Caracteristique createOrUpdate(Caracteristique caracteristique)
	{
		if (caracteristique==null)
		{
			throw new CaracteristiqueException("caracteristique non saisi");
		}
		
		checkData(caracteristique);
		
		Caracteristique caracteristiqueEnBase=new Caracteristique();
		
		if (caracteristique.getId()==null)
		{
			return caracteristiqueRepository.save(caracteristique);
		}
		
		else
		{
			caracteristiqueEnBase=this.getById(caracteristique.getId());
			caracteristiqueEnBase.setCollectif(caracteristique.getCollectif());
			caracteristiqueEnBase.setCreativite(caracteristique.getCreativite());
			caracteristiqueEnBase.setDetermination(caracteristique.getDetermination());
			caracteristiqueEnBase.setPatience(caracteristique.getPatience());
			caracteristiqueEnBase.setDetente(caracteristique.getDetente());
			caracteristiqueEnBase.setAgilite(caracteristique.getAgilite());
			caracteristiqueEnBase.setPuissance(caracteristique.getPuissance());
			caracteristiqueEnBase.setVitesse(caracteristique.getVitesse());
			caracteristiqueEnBase.setEndurance(caracteristique.getEndurance());
			caracteristiqueEnBase.setProfil(caracteristique.getProfil());
			
			return caracteristiqueRepository.save(caracteristiqueEnBase);
		}
	}
	
	public void delete (Caracteristique caracteristique)
	{
		if (caracteristique==null)
		{
			throw new CaracteristiqueException("caracteristique non saisi");
		}
		
		if (caracteristique.getId()==null)
		{
			throw new CaracteristiqueException("caracteristique sans id !!");
		}
		
		
	
		
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}


}
