package AppliSport.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Context {
	private static EntityManagerFactory emf = null;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("bdd_sport");
		}
		return emf;
	}

	public static void destroy() {
		if (emf != null) {
			emf.close();
			emf = null;
		}
	}
}
