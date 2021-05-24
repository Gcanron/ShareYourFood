import java.text.ParseException;
import java.text.SimpleDateFormat;

import sopra.ShareYourFood.Application;
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
import sopra.ShareYourFood.model.StatutReservation;
import sopra.ShareYourFood.model.Utilisateur;
import sopra.ShareYourFood.repository.IAdresseRepository;
import sopra.ShareYourFood.repository.IDemandeRepository;
import sopra.ShareYourFood.repository.IDonRepository;
import sopra.ShareYourFood.repository.IEntiteRepository;
import sopra.ShareYourFood.repository.ILotRepository;
import sopra.ShareYourFood.repository.IMessageRepository;
import sopra.ShareYourFood.repository.IProduitRepository;
import sopra.ShareYourFood.repository.IUtilisateurRepository;

public class TestJpaWithDao {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		IAdresseRepository adresseRepo = Application.getInstance().getAdresseRepo();
		IDemandeRepository demandeRepo = Application.getInstance().getDemandeRepo();
		IDonRepository donRepo = Application.getInstance().getDonRepo();
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();
		ILotRepository lotRepo = Application.getInstance().getLotRepo();
		IMessageRepository messageRepo = Application.getInstance().getMessageRepo();
		IProduitRepository produitRepo = Application.getInstance().getProduitRepo();
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		
		
		//////CREATION OBJETS////////////////////////////////////////////
		
		//ENTITES
		Particulier aubeline = new Particulier("aubeline", 28);
		aubeline.setNom("PECQUE");
		aubeline.setDonneur(true);
		aubeline.setBeneficiaire(false);
		
		Particulier sarah = new Particulier("sarah", 25);
		sarah.setNom("CAZE");
		sarah.setDonneur(true);
		sarah.setBeneficiaire(false);
		
		Particulier regis = new Particulier("regis", 37);
		regis.setNom("SIMON");
		regis.setDonneur(false);
		regis.setBeneficiaire(true);
		
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
		
		
		//UTILISATEURS
		Utilisateur cocoDu06 = new Utilisateur();
		cocoDu06.setPseudo("Coco_du_06");
		cocoDu06.setMotDePasse("azerty");
		cocoDu06.setMail("cocodu06@gmail.com");
		cocoDu06.setMessagerieActivation(true);

		Utilisateur toto65 = new Utilisateur();
		toto65.setPseudo("Toto65");
		toto65.setMotDePasse("azerty123");
		toto65.setMail("toto65@gmail.com");
		toto65.setMessagerieActivation(true);

		Utilisateur aube = new Utilisateur();
		aube.setPseudo("Aube");
		aube.setMotDePasse("azerty1234");
		aube.setMail("aubeline.pecque@hotmail.com");
		aube.setMessagerieActivation(true);

		Utilisateur sarahCze = new Utilisateur();
		sarahCze.setPseudo("SarahCZE");
		sarahCze.setMotDePasse("azerty12345");
		sarahCze.setMail("sarah.caze@hotmail.com");
		sarahCze.setMessagerieActivation(true);
		
		Utilisateur regisSimon = new Utilisateur();
		regisSimon.setPseudo("ReSi");
		regisSimon.setMotDePasse("qsdfgh");
		regisSimon.setMail("regis.simon@hotmail.com");
		regisSimon.setMessagerieActivation(true);
		
		//ADRESSES
		Adresse adrAube = new Adresse("2 impasse Olympie", "Batiment A", "64000", "Pau");
		Adresse adrSarahCze = new Adresse("75 rue d'Athènes", "bis", "33000", "Bordeaux");
		Adresse adrCroixRouge = new Adresse("9 avenue Gambetta", null, "13001", "Marseille");
		Adresse adrDonPourTous = new Adresse("277 boulevard Leon Blum", "Bâtiment C", "75004", "Paris");
		Adresse adrLeclerc = new Adresse("50 avenue Gutemberg", "Zone commerciale Soleil", "33700", "Mérignac");
		Adresse adrRegis = new Adresse("3 avenue Molière", null, "33000", "Bordeaux");
		
		//DONS
		Don donLeclerc = new Don();
		try {
			donLeclerc.setDateDeMiseEnLigne(sdf.parse("02/09/2020"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		donLeclerc.setCreneau("13h à 15h");
		donLeclerc.setCommentaire("DLC à peine passée, mais encore en bon état");
		donLeclerc.setDestinataire(Destinataire.ASSOCIATION);

	
		
		//LOTS
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
		
		Lot pain = new Lot();
		pain.setNom("Pain");
		try {
			pain.setDtPeremptionLot(sdf.parse("20/05/2023"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pain.setPhoto("cqdcvi/fsfsf");
		pain.setVolume((long) 25);
		pain.setStatut(Statut.DISPONIBLE);
		
		
		//DEMANDES
		Demande demandeDonPourTous = new Demande();
		try {
			demandeDonPourTous.setDtDemande(sdf.parse("22/05/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		demandeDonPourTous.setStatutNotif(StatutNotif.ACCEPTER);
		
		Demande demandeRegis = new Demande();
		try {
			demandeRegis.setDtDemande(sdf.parse("01/06/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		demandeRegis.setStatutNotif(StatutNotif.ACCEPTER);
		
	
		
		//MESSAGES
		sopra.ShareYourFood.model.Message messageDonPourTousLeclerc = new sopra.ShareYourFood.model.Message();
		messageDonPourTousLeclerc.setContenu("Bonjour, Don Pour Tous souhaiterai bénéficier de ce don. Nous vous remercions par avance.");
		messageDonPourTousLeclerc.setDonneur(false);
		
		sopra.ShareYourFood.model.Message messageLeclercDonPourTous = new sopra.ShareYourFood.model.Message();
		messageLeclercDonPourTous.setContenu("Bien volontiers");
		messageLeclercDonPourTous.setDonneur(true);
		
		
		sopra.ShareYourFood.model.Message messageRegis = new sopra.ShareYourFood.model.Message();
		messageRegis.setContenu("Bonjour, est-il possible de disposer de chocolat ? Bien à vous");
		messageRegis.setDonneur(false);
		
		sopra.ShareYourFood.model.Message messageLeclercRegis = new sopra.ShareYourFood.model.Message();
		messageLeclercRegis.setContenu("Bien sur");
		messageLeclercRegis.setDonneur(true);
		
	
		//////CREATION BDD////////////////////////////////////////////
		
		//UTILISATEURS
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		toto65 = utilisateurRepo.save(toto65);
		aube = utilisateurRepo.save(aube);
		sarahCze = utilisateurRepo.save(sarahCze);
		regisSimon = utilisateurRepo.save(regisSimon);
		
		//ENTITES
		aubeline = (Particulier) entiteRepo.save(aubeline);
		sarah = (Particulier) entiteRepo.save(sarah);
		CroixRouge = (Association) entiteRepo.save(CroixRouge);
		Leclerc = (Entreprise) entiteRepo.save(Leclerc);
		regis = (Particulier) entiteRepo.save(regis);
		DonPourTous = (Association) entiteRepo.save(DonPourTous);
		
		//LIENS UTILISATEURS ENTITES
		cocoDu06.setEntite(Leclerc);
		aube.setEntite(aubeline);
		sarahCze.setEntite(sarah);
		toto65.setEntite(CroixRouge);
		regisSimon.setEntite(regis);
		
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		toto65 = utilisateurRepo.save(toto65);
		aube = utilisateurRepo.save(aube);
		sarahCze = utilisateurRepo.save(sarahCze);
		regisSimon = utilisateurRepo.save(regisSimon);
		
		//MESSAGES
		messageDonPourTousLeclerc = messageRepo.save(messageDonPourTousLeclerc);
		messageLeclercDonPourTous = messageRepo.save(messageLeclercDonPourTous);
		messageRegis = messageRepo.save(messageRegis);
		messageLeclercRegis = messageRepo.save(messageLeclercRegis);
		
		//DEMANDES
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		demandeRegis = demandeRepo.save(demandeRegis);
		
		//LIEN MESSAGES DEMANDES
		messageDonPourTousLeclerc.setDemande(demandeDonPourTous);
		messageLeclercDonPourTous.setDemande(demandeDonPourTous);
		messageRegis.setDemande(demandeRegis);
		messageLeclercRegis.setDemande(demandeRegis);
		
		messageDonPourTousLeclerc = messageRepo.save(messageDonPourTousLeclerc);
		messageLeclercDonPourTous = messageRepo.save(messageLeclercDonPourTous);
		messageRegis = messageRepo.save(messageRegis);
		messageLeclercRegis = messageRepo.save(messageLeclercRegis);
		
		//LIEN DEMANDES ENTITES
		demandeDonPourTous.setEntite(DonPourTous);
		demandeRegis.setEntite(regis);
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		demandeRegis = demandeRepo.save(demandeRegis);
		
		//DONS
		donLeclerc = donRepo.save(donLeclerc);
		
		//ADRESSES
		adrAube = adresseRepo.save(adrAube);
		adrSarahCze = adresseRepo.save(adrSarahCze);
		adrCroixRouge = adresseRepo.save(adrCroixRouge);
		adrDonPourTous = adresseRepo.save(adrDonPourTous);
		adrLeclerc = adresseRepo.save(adrLeclerc);
		adrRegis = adresseRepo.save(adrRegis);
		
		aubeline=(Particulier) entiteRepo.save(aubeline);
		sarah = (Particulier) entiteRepo.save(sarah);
		regis = (Particulier) entiteRepo.save(regis);
		CroixRouge = (Association) entiteRepo.save(CroixRouge);
		DonPourTous = (Association) entiteRepo.save(DonPourTous);
		Leclerc = (Entreprise) entiteRepo.save(Leclerc);
		
		//LIEN ADRESSES ENTITES
		adrAube.setEntite(aubeline);
		adrSarahCze.setEntite(sarah);
		adrCroixRouge.setEntite(CroixRouge);
		adrDonPourTous.setEntite(DonPourTous);
		adrLeclerc.setEntite(Leclerc);
		adrRegis.setEntite(regis);
		
		adrAube = adresseRepo.save(adrAube);
		adrSarahCze = adresseRepo.save(adrSarahCze);
		adrCroixRouge = adresseRepo.save(adrCroixRouge);
		adrDonPourTous = adresseRepo.save(adrDonPourTous);
		adrLeclerc = adresseRepo.save(adrLeclerc);
		adrRegis = adresseRepo.save(adrRegis);
		
		//LIEN DONS ADRESSES 
		donLeclerc.setAdresse(adrLeclerc);
		
		adrLeclerc = adresseRepo.save(adrLeclerc);
		donLeclerc = donRepo.save(donLeclerc);
		
		//LIEN DON ENTITE
		donLeclerc.setEntite(Leclerc);
		
		donLeclerc = donRepo.save(donLeclerc);
		
		//LOT
		chocolat = lotRepo.save(chocolat);
		pain = lotRepo.save(pain);
		
		//LIEN LOTS DONS
		chocolat.setDon(donLeclerc);
		pain.setDon(donLeclerc);
		
		chocolat = lotRepo.save(chocolat);
		pain = lotRepo.save(pain);
		
		//LIEN DEMANDE LOTS
		
		demandeDonPourTous.setLot(pain);
		demandeDonPourTous.setEntite(DonPourTous);
		demandeRegis.setLot(chocolat);
		demandeRegis.setEntite(regis);
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		demandeRegis = demandeRepo.save(demandeRegis);

	}

}
