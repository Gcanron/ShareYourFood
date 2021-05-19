package sopra.ShareYourFood;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.ShareYourFood.Application;

public class Application {
	
	private static Application instance = null;
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp-revue-jpa");
	
	
	
	
	
	
	private Application() {

	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

}
