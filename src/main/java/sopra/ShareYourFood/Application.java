package sopra.ShareYourFood;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.repository.IAdresseRepository;
import sopra.ShareYourFood.repository.IDemandeRepository;
import sopra.ShareYourFood.repository.IDonRepository;
import sopra.ShareYourFood.repository.IEntiteRepository;
import sopra.ShareYourFood.repository.ILotRepository;
import sopra.ShareYourFood.repository.IMessageRepository;
import sopra.ShareYourFood.repository.IProduitRepository;
import sopra.ShareYourFood.repository.IUtilisateurRepository;
import sopra.ShareYourFood.repository.jpa.AdresseRepositoryJpa;
import sopra.ShareYourFood.repository.jpa.DemandeRepositoryJpa;
import sopra.ShareYourFood.repository.jpa.DonRepositoryJpa;
import sopra.ShareYourFood.repository.jpa.EntiteRepositoryJpa;
import sopra.ShareYourFood.repository.jpa.LotRepositoryJpa;
import sopra.ShareYourFood.repository.jpa.ProduitRepositoryJpa;
import sopra.ShareYourFood.repository.jpa.UtilisateurRepositoryJpa;

public class Application {
	
	private static Application instance = null;
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareYourFood-jpa");
	
	private final IDemandeRepository demandeRepo = new DemandeRepositoryJpa();
	private final IDonRepository donRepo = new DonRepositoryJpa();
	private final IEntiteRepository entiteRepo = new EntiteRepositoryJpa();
	private final ILotRepository lotRepo = new LotRepositoryJpa();
	private final IProduitRepository produitRepo = new ProduitRepositoryJpa();
	private final IUtilisateurRepository utilisateurRepo = new UtilisateurRepositoryJpa();
	private final IMessageRepository messageRepo = new MessageRepositoryJpa();
	private final IAdresseRepository adresseRepo = new AdresseRepositoryJpa();
	
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

	public IDemandeRepository getDemandeRepo() {
		return demandeRepo;
	}

	public IDonRepository getDonRepo() {
		return donRepo;
	}

	public IEntiteRepository getEntiteRepo() {
		return entiteRepo;
	}

	public ILotRepository getLotRepo() {
		return lotRepo;
	}

	public IProduitRepository getProduitRepo() {
		return produitRepo;
	}

	public IUtilisateurRepository getUtilisateurRepo() {
		return utilisateurRepo;
	}

	public static void setInstance(Application instance) {
		Application.instance = instance;
	}

	
	
	
	
}
