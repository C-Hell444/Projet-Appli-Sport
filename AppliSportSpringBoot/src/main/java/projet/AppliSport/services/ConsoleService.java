package projet.AppliSport.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Service;






@Service
public class ConsoleService implements CommandLineRunner {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ConsoleService.class);
	
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Run");
		
	}
	

	
	
	

}
