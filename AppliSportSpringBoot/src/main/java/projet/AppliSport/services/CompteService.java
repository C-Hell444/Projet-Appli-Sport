package projet.AppliSport.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.AppliSport.exception.CompteException;
import projet.AppliSport.model.Compte;
import projet.AppliSport.model.CompteRepository;



@Service
public class CompteService {
	@Autowired
	private  CompteRepository compteRepository ;
	public Compte getByIdentifiant(String identifiant)
	{
		return compteRepository.findByIdentifiant(identifiant).orElseThrow(()->{
			throw new CompteException("Login inconnu");
		});
	}

}
