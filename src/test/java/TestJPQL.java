import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.repository.IAdresseRepository;
import sopra.ShareYourFood.repository.IDemandeRepository;
import sopra.ShareYourFood.repository.IDonRepository;
import sopra.ShareYourFood.repository.IEntiteRepository;
import sopra.ShareYourFood.repository.ILotRepository;
import sopra.ShareYourFood.repository.IMessageRepository;
import sopra.ShareYourFood.repository.IProduitLotRepository;
import sopra.ShareYourFood.repository.IProduitRepository;
import sopra.ShareYourFood.repository.IUtilisateurRepository;

public class TestJPQL {

	public static void main(String[] args) {
		
		IAdresseRepository adresseRepo = Application.getInstance().getAdresseRepo();
		IDemandeRepository demandeRepo = Application.getInstance().getDemandeRepo();
		IDonRepository donRepo = Application.getInstance().getDonRepo();
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();
		ILotRepository lotRepo = Application.getInstance().getLotRepo();
		IMessageRepository messageRepo = Application.getInstance().getMessageRepo();
		IProduitRepository produitRepo = Application.getInstance().getProduitRepo();
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		
		
		
		
	}

}
