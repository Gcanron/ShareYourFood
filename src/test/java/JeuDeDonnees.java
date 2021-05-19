import sopra.ShareYourFood.model.Association;
import sopra.ShareYourFood.model.Particulier;

public class JeuDeDonnees {

	public static void main(String[] args) {

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

		Association DonPourTous = new Association("FR987654321", "justificatif2");

	}

}
