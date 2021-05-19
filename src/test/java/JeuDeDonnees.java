import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Message;

import sopra.ShareYourFood.model.Adresse;
import sopra.ShareYourFood.model.Association;
import sopra.ShareYourFood.model.Categorie;
import sopra.ShareYourFood.model.Demande;
import sopra.ShareYourFood.model.Destinataire;
import sopra.ShareYourFood.model.Don;
import sopra.ShareYourFood.model.Entreprise;
import sopra.ShareYourFood.model.Lot;
import sopra.ShareYourFood.model.Particulier;
import sopra.ShareYourFood.model.Statut;
import sopra.ShareYourFood.model.StatutNotif;
import sopra.ShareYourFood.model.Utilisateur;


public class JeuDeDonnees {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		

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
		
		
		Adresse adrSarahCze = new Adresse("75 rue d'Athènes", "bis", "33000", "Bordeaux");
		Adresse adrCroixRouge = new Adresse("9 avenue Gambetta", null, "13001", "Marseille");
		Adresse adrDonPourTous = new Adresse("277 boulevard Leon Blum", "Bâtiment C", "75004", "Paris");
		Adresse adrLeclerc = new Adresse("50 avenue Gutemberg", "Zone commerciale Soleil", "33700", "Mérignac");
		
		
		
		Don donLeclerc = new Don();
		try {
			donLeclerc.setDateDeMiseEnLigne(sdf.parse("02/09/2020"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		donLeclerc.setCreneau("13h à 15h");
		donLeclerc.setCommentaire("DLC à peine passée, mais encore en bon état");
		donLeclerc.setDestinataire(Destinataire.ASSOCIATION);
		donLeclerc.setAdresse(adrLeclerc);
		
		
		Lot chocolat = new Lot();
		chocolat.setNom("Chocolat");
		try {
			chocolat.setDtPeremptionLot(sdf.parse("05/07/2022"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		chocolat.setPhoto("djvbv/didz/yugi");
		chocolat.setVolume((long) 50);
		chocolat.setStatut(Statut.DISPONIBLE);
		chocolat.setDon(donLeclerc);
		
		Lot pain = new Lot();
		chocolat.setNom("Pain");
		try {
			chocolat.setDtPeremptionLot(sdf.parse("20/05/2023"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pain.setPhoto("djvbv/didz/yugi");
		pain.setVolume((long) 25);
		pain.setStatut(Statut.DISPONIBLE);
		pain.setDon(donLeclerc);
		
		Demande demandeDonPourTous = new Demande();
		try {
			demandeDonPourTous.setDtDemande(sdf.parse("22/05/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		demandeDonPourTous.setLot(pain);
		demandeDonPourTous.setStatutNotif(StatutNotif.ACCEPTER);
		demandeDonPourTous.setEntite(DonPourTous);
		
		Demande demandeSarah = new Demande();
		try {
			demandeSarah.setDtDemande(sdf.parse("01/06/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		demandeSarah.setLot(chocolat);
		demandeSarah.setStatutNotif(StatutNotif.ACCEPTER);
		demandeSarah.setEntite(sarah);
		
		sopra.ShareYourFood.model.Message messageDonPourTousLeclerc = new sopra.ShareYourFood.model.Message();
		messageDonPourTousLeclerc.setContenu("Bonjour, Don Pour Tous souhaiterai bénéficier de ce don. Nous vous remercions par avance.");
		messageDonPourTousLeclerc.setDemande(demandeDonPourTous);
		messageDonPourTousLeclerc.setDonneur(false);
		
		sopra.ShareYourFood.model.Message messageLeclercDonPourTous = new sopra.ShareYourFood.model.Message();
		messageLeclercDonPourTous.setContenu("Bien volontiers");
		messageLeclercDonPourTous.setDemande(demandeDonPourTous);
		messageLeclercDonPourTous.setDonneur(true);
		
		
		sopra.ShareYourFood.model.Message messageSarah = new sopra.ShareYourFood.model.Message();
		messageSarah.setContenu("Bonjour, est-il possible de disposer de chocolat ? Bien à vous");
		messageSarah.setDemande(demandeSarah);
		messageSarah.setDonneur(false);
		
		sopra.ShareYourFood.model.Message messageLeclercSarah = new sopra.ShareYourFood.model.Message();
		messageLeclercSarah.setContenu("Bien sur");
		messageLeclercSarah.setDemande(demandeSarah);
		messageLeclercSarah.setDonneur(true);
		

	}

}
