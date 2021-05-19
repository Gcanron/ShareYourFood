package sopra.ShareYourFood;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.repository.IDemandeRepository;
import sopra.ShareYourFood.repository.IDonRepository;
import sopra.ShareYourFood.repository.IEntiteRepository;
import sopra.ShareYourFood.repository.ILotRepository;
import sopra.ShareYourFood.repository.IProduitRepository;
import sopra.ShareYourFood.repository.IUtilisateurRepository;
import sopra.ShareYourFood.repository.jpa.DemandeRepositoryJpa;
import sopra.ShareYourFood.repository.jpa.DonRepositoryJpa;

public class Application {
	
	private static Application instance = null;
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareYourFood-jpa");
	
	private final IDemandeRepository demandeRepo = new DemandeRepositoryJpa();
	private final IDonRepository donRepo = new DonRepositoryJpa();
	private final IEntiteRepository entiteRepo = new EntiteRepositoryJpa();
	private final ILotRepository lotRepo = new LotRepositoryJpa();
	private final IProduitRepository produitRepo = new ProduitRepositoryJpa();
	private final IUtilisateurRepository utilisateurRepo = new UtilisateurRepositoryJpa();
	
	
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
