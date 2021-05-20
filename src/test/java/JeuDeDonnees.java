import java.text.ParseException;
import java.text.SimpleDateFormat;

import sopra.ShareYourFood.model.Adresse;
import sopra.ShareYourFood.model.Association;
import sopra.ShareYourFood.model.Categorie;
import sopra.ShareYourFood.model.Entreprise;
import sopra.ShareYourFood.model.Lot;
import sopra.ShareYourFood.model.Particulier;
import sopra.ShareYourFood.model.Produit;
import sopra.ShareYourFood.model.ProduitLot;
import sopra.ShareYourFood.model.Type;
import sopra.ShareYourFood.model.Utilisateur;

public class JeuDeDonnees {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		Particulier aubeline = new Particulier("aubeline", 28);
		aubeline.setNom("PECQUE");
		aubeline.setDonneur(true);
		aubeline.setBeneficiaire(false);

		Particulier sarah = new Particulier("sarah", 25);
		sarah.setNom("CAZE");
		sarah.setDonneur(true);
		sarah.setBeneficiaire(false);

		Association CroixRouge = new Association("FR123456789", "justificatif1");
		CroixRouge.setNom("La Croix Rouge");
		CroixRouge.setDonneur(true);
		CroixRouge.setBeneficiaire(true);

		Association DonPourTous = new Association("FR987654321", "justificatif2");
		DonPourTous.setNom("Dons pour tous");
		DonPourTous.setDonneur(false);
		DonPourTous.setBeneficiaire(true);

		Entreprise Leclerc = new Entreprise("5486935JH14S", Categorie.GRANDE_SURFACE);
		Leclerc.setNom("Leclerc");
		Leclerc.setDonneur(true);
		Leclerc.setBeneficiaire(false);

		Utilisateur cocoDu06 = new Utilisateur();
		cocoDu06.setPseudo("Coco_du_06");
		cocoDu06.setMotDePasse("azerty");
		cocoDu06.setMail("cocodu06@gmail.com");
		cocoDu06.setMessagerieActivation(true);
		cocoDu06.setEntite(Leclerc);

		Utilisateur toto65 = new Utilisateur();
		toto65.setPseudo("Toto65");
		toto65.setMotDePasse("azerty123");
		toto65.setMail("toto65@gmail.com");
		toto65.setMessagerieActivation(true);
		toto65.setEntite(CroixRouge);

		Utilisateur aube = new Utilisateur();
		aube.setPseudo("Aube");
		aube.setMotDePasse("azerty1234");
		aube.setMail("aubeline.pecque@hotmail.com");
		aube.setMessagerieActivation(true);
		aube.setEntite(aubeline);

		Utilisateur sarahCze = new Utilisateur();
		sarahCze.setPseudo("SarahCZE");
		sarahCze.setMotDePasse("azerty12345");
		sarahCze.setMail("sarah.caze@hotmail.com");
		sarahCze.setMessagerieActivation(true);
		sarahCze.setEntite(sarah);

		Adresse adrAube = new Adresse("2 impasse Olympie", "Batiment A", "64000", "Pau");
		
		Produit pain = new Produit();
		pain.setNom("pain");
		pain.setType(Type.valueOf("PAIN_PATISSERIE"));

		Produit yaourt = new Produit();
		yaourt.setNom("yaourt");
		yaourt.setType(Type.valueOf("FRAIS"));
		
		Lot lotNumber1 = new Lot();
		lotNumber1.setNom("Yaourt à gogo");
		lotNumber1.setVolume(400L);
		lotNumber1.setPhoto("C:/mesPhotos");
		
		ProduitLot yaourt_lot1 = new ProduitLot();
		yaourt_lot1.setLot(lotNumber1);
		yaourt_lot1.setProduit(yaourt);
		yaourt_lot1.setQuantite(1000L);
		try {
			yaourt_lot1.setDtPeremption(sdf.parse("22/05/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
	}

}
