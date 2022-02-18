package projet.AppliSport.services;

import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.InteretException;
import projet.AppliSport.model.Interet;
import projet.AppliSport.repositories.InteretRepository;


@Service
public class InteretService {

	@Autowired
	private InteretRepository interetRepository;
	
	@Autowired
	private Validator validator;
	
	
	public List<Interet> getAll()
	{
		return interetRepository.findAll();
	}

	
	public Interet getById(Long id)
	{
		return interetRepository.findById(id).orElseThrow(() -> {
			throw new InteretException("interet inconnu");
		});
	}
	
	private void checkData(Interet interet)
	{
		if(!validator.validate(interet).isEmpty()) {
			throw new InteretException();
		}
	}
	
	public Interet createOrUpdate(Interet interet)
	{
		if (interet==null)
		{
			throw new InteretException("interet non saisi");
		}
		
		checkData(interet);
		
		Interet interetEnBase=new Interet();
		
		if (interet.getId()==null)
		{
			return interetRepository.save(interet);
		}
		
		else
		{
			interetEnBase=this.getById(interet.getId());
			interetEnBase.setUtilisateur(interet.getUtilisateur());
			interetEnBase.setSport(interet.getSport());
			
			return interetRepository.save(interetEnBase);
		}
	}
	
	public void delete (Interet interet)
	{
		if (interet==null)
		{
			throw new InteretException("interet non saisi");
		}
		
		if (interet.getId()==null)
		{
			throw new InteretException("interet sans id !!");
		}
		
		
		
		
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}


}
