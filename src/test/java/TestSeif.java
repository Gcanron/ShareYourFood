import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.model.Association;
import sopra.ShareYourFood.model.Categorie;
import sopra.ShareYourFood.model.Demande;
import sopra.ShareYourFood.model.Entreprise;
import sopra.ShareYourFood.model.Lot;
import sopra.ShareYourFood.model.Message;
import sopra.ShareYourFood.model.Particulier;
import sopra.ShareYourFood.model.Role;
import sopra.ShareYourFood.model.Statut;
import sopra.ShareYourFood.model.StatutNotif;
import sopra.ShareYourFood.model.Utilisateur;
import sopra.ShareYourFood.repository.IDemandeRepository;
import sopra.ShareYourFood.repository.IEntiteRepository;
import sopra.ShareYourFood.repository.ILotRepository;
import sopra.ShareYourFood.repository.IMessageRepository;
import sopra.ShareYourFood.repository.IUtilisateurRepository;

public class TestSeif {
	
	@Test
	public void utilisateurCreate() {
		
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();
		
		
		Utilisateur cocoDu06 = new Utilisateur("Coco_du_06", "cocodu06@gmail.com","azerty", true);
		cocoDu06.setRole(Role.MEMBRE);
		

		Utilisateur toto65 = new Utilisateur();
		toto65.setPseudo("Toto65");
		toto65.setMotDePasse("azerty123");
		toto65.setMail("toto65@gmail.com");
		toto65.setMessagerieActivation(true);
		toto65.setRole(Role.ADMINISTRATEUR);
		

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
		
		
		Particulier aubeline = new Particulier("aubeline", 28);
		aubeline.setNom("PECQUE");
		aubeline.setDonneur(true);
		aubeline.setBeneficiaire(false);
		
		

		Particulier sarah = new Particulier("sarah", 25);
		sarah.setNom("CAZE");
		sarah.setDonneur(true);
		sarah.setBeneficiaire(false);
		
		
		
		Particulier regis = new Particulier("regis", 25);
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
		
		
		
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		toto65 = utilisateurRepo.save(toto65);
		aube = utilisateurRepo.save(aube);
		sarahCze = utilisateurRepo.save(sarahCze);
		
		aubeline = (Particulier) entiteRepo.save(aubeline);
		sarah = (Particulier) entiteRepo.save(sarah);
		regis = (Particulier) entiteRepo.save(regis);
		CroixRouge = (Association) entiteRepo.save(CroixRouge);
		DonPourTous = (Association) entiteRepo.save(DonPourTous);
		Leclerc = (Entreprise) entiteRepo.save(Leclerc);
		
		aube.setEntite(aubeline);
		sarahCze.setEntite(sarah);
		toto65.setEntite(CroixRouge);
		cocoDu06.setEntite(Leclerc);
		
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		toto65 = utilisateurRepo.save(toto65);
		aube = utilisateurRepo.save(aube);
		sarahCze = utilisateurRepo.save(sarahCze);
		
		
		Utilisateur uFind = utilisateurRepo.findById(cocoDu06.getId());
		Assert.assertEquals("Coco_du_06", uFind.getPseudo());
		Assert.assertEquals("azerty", uFind.getMotDePasse());
		Assert.assertEquals("cocodu06@gmail.com", uFind.getMail());
		Assert.assertEquals(true, uFind.getMessagerieActivation());
		
		List<Utilisateur> utilisateurs = utilisateurRepo.findAll();
		Assert.assertEquals(4, utilisateurs.size());
		
		utilisateurRepo.delete(cocoDu06);
		utilisateurRepo.delete(toto65);
		utilisateurRepo.delete(aube);
		utilisateurRepo.delete(sarahCze);
		
		entiteRepo.delete(aubeline);
		entiteRepo.delete(sarah);
		entiteRepo.delete(Leclerc);
		entiteRepo.delete(DonPourTous);
		entiteRepo.delete(regis);
		entiteRepo.delete(CroixRouge);

	}
	
	@Test
	public void utilisateurUpdate() {
		
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();
		
		
		Utilisateur cocoDu06 = new Utilisateur();
		cocoDu06.setPseudo("Coco_du_06");
		cocoDu06.setMotDePasse("azerty");
		cocoDu06.setMail("cocodu06@gmail.com");
		cocoDu06.setMessagerieActivation(true);
		cocoDu06.setRole(Role.MEMBRE);
		
		Entreprise Leclerc = new Entreprise("5486935JH14S", Categorie.GRANDE_SURFACE);
		Leclerc.setNom("Leclerc");
		Leclerc.setDonneur(true);
		Leclerc.setBeneficiaire(false);
		
		
		Association CroixRouge = new Association("FR123456789", "justificatif1");
		CroixRouge.setNom("La Croix Rouge");
		CroixRouge.setDonneur(true);
		CroixRouge.setBeneficiaire(true);
		
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		Leclerc = (Entreprise) entiteRepo.save(Leclerc);
		cocoDu06.setEntite(Leclerc);
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		cocoDu06 = utilisateurRepo.findById(cocoDu06.getId());
		
		cocoDu06.setPseudo("co_60");
		cocoDu06.setMotDePasse("ytreza");
		cocoDu06.setMail("co@hotmail.com");
		cocoDu06.setMessagerieActivation(false);
		cocoDu06.setRole(Role.ADMINISTRATEUR);
		
		
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		CroixRouge = (Association) entiteRepo.save(CroixRouge);
		cocoDu06.setEntite(CroixRouge);
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		cocoDu06 = utilisateurRepo.findById(cocoDu06.getId());
		
		Assert.assertEquals("co_60", cocoDu06.getPseudo());
		Assert.assertEquals("ytreza", cocoDu06.getMotDePasse());
		Assert.assertEquals("co@hotmail.com", cocoDu06.getMail());
		Assert.assertEquals(false, cocoDu06.getMessagerieActivation());
		Assert.assertEquals(Role.ADMINISTRATEUR, cocoDu06.getRole());
		Assert.assertEquals(CroixRouge.getId(), cocoDu06.getEntite().getId());
		
		utilisateurRepo.delete(cocoDu06);
		entiteRepo.delete(Leclerc);
		entiteRepo.delete(CroixRouge);
		
		
	}
	
	@Test
	public void utilisateurFindAll() {
		
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();
		
		
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
	
		Entreprise Leclerc = new Entreprise("5486935JH14S", Categorie.GRANDE_SURFACE);
		Leclerc.setNom("Leclerc");
		Leclerc.setDonneur(true);
		Leclerc.setBeneficiaire(false);
		
		
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		toto65 = utilisateurRepo.save(toto65);
		aube = utilisateurRepo.save(aube);
		sarahCze = utilisateurRepo.save(sarahCze);
		
		aubeline = (Particulier) entiteRepo.save(aubeline);
		sarah = (Particulier) entiteRepo.save(sarah);
		CroixRouge = (Association) entiteRepo.save(CroixRouge);
		Leclerc = (Entreprise) entiteRepo.save(Leclerc);
		
		cocoDu06.setEntite(Leclerc);
		aube.setEntite(aubeline);
		sarahCze.setEntite(sarah);
		toto65.setEntite(CroixRouge);
		
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		toto65 = utilisateurRepo.save(toto65);
		aube = utilisateurRepo.save(aube);
		sarahCze = utilisateurRepo.save(sarahCze);
		
		List<Utilisateur> utilisateurs=utilisateurRepo.findAll();
		
		Assert.assertEquals(4, utilisateurs.size());
		
		utilisateurRepo.delete(toto65);
		
//		Assert.assertEquals(3, utilisateurs.size());
		
		utilisateurRepo.delete(cocoDu06);
		utilisateurRepo.delete(sarahCze);
		utilisateurRepo.delete(aube);
		
		entiteRepo.delete(aubeline);
		entiteRepo.delete(sarah);
		entiteRepo.delete(Leclerc);
		entiteRepo.delete(CroixRouge);
		
	}
	
	@Test
	public void demandeCreate() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IDemandeRepository demandeRepo = Application.getInstance().getDemandeRepo();
		ILotRepository lotRepo = Application.getInstance().getLotRepo();
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();
		
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
		pain.setPhoto("bkbkbk/dhvb/ihcv");
		pain.setVolume((long) 25);
		pain.setStatut(Statut.DISPONIBLE);
	
		
		Particulier regis = new Particulier("regis", 25);
		regis.setNom("SIMON");
		regis.setDonneur(false);
		regis.setBeneficiaire(true);
		
		Association DonPourTous = new Association("FR987654321", "justificatif2");
		DonPourTous.setNom("Dons pour tous");
		DonPourTous.setDonneur(false);
		DonPourTous.setBeneficiaire(true);
		
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		demandeRegis = demandeRepo.save(demandeRegis);
		
		chocolat = lotRepo.save(chocolat);
		pain = lotRepo.save(pain);
		DonPourTous =(Association) entiteRepo.save(DonPourTous);
		regis = (Particulier) entiteRepo.save(regis);
		
		demandeDonPourTous.setLot(pain);
		demandeDonPourTous.setEntite(DonPourTous);
		demandeRegis.setLot(chocolat);
		demandeRegis.setEntite(regis);
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		demandeRegis = demandeRepo.save(demandeRegis);
		
		Demande uFind = demandeRepo.findById(demandeDonPourTous.getId());
		try {
			Assert.assertEquals(sdf.parse("22/05/2021"), uFind.getDtDemande());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(StatutNotif.ACCEPTER, uFind.getStatutNotif());
		
		List<Demande> demandes = demandeRepo.findAll();
		Assert.assertEquals(2, demandes.size());
		
		demandeRepo.delete(demandeDonPourTous);
		demandeRepo.delete(demandeRegis);
		lotRepo.delete(pain);
		lotRepo.delete(chocolat);
		entiteRepo.delete(DonPourTous);
		entiteRepo.delete(regis);
		
		
	}
	
	@Test
	public void demandeUpdate() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IDemandeRepository demandeRepo = Application.getInstance().getDemandeRepo();
		ILotRepository lotRepo = Application.getInstance().getLotRepo();
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();
		
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
		pain.setPhoto("bkbkbk/dhvb/ihcv");
		pain.setVolume((long) 25);
		pain.setStatut(Statut.DISPONIBLE);
	
		
		Particulier regis = new Particulier("regis", 25);
		regis.setNom("SIMON");
		regis.setDonneur(false);
		regis.setBeneficiaire(true);
		
		Association DonPourTous = new Association("FR987654321", "justificatif2");
		DonPourTous.setNom("Dons pour tous");
		DonPourTous.setDonneur(false);
		DonPourTous.setBeneficiaire(true);
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		demandeRegis = demandeRepo.save(demandeRegis);

		
		chocolat = lotRepo.save(chocolat);
		pain = lotRepo.save(pain);
		DonPourTous = (Association) entiteRepo.save(DonPourTous);
		regis = (Particulier) entiteRepo.save(regis);
		
		demandeDonPourTous.setLot(pain);
		demandeDonPourTous.setEntite(DonPourTous);
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);

		
		
		try {
			demandeDonPourTous.setDtDemande(sdf.parse("26/12/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		demandeDonPourTous.setStatutNotif(StatutNotif.ARCHIVER);
		
		
		demandeDonPourTous.setLot(chocolat);
		demandeDonPourTous.setEntite(regis);
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);

		
		
		
		try {
			Assert.assertEquals(sdf.parse("26/12/2021"), demandeDonPourTous.getDtDemande());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(StatutNotif.ARCHIVER, demandeDonPourTous.getStatutNotif());
		Assert.assertEquals(chocolat, demandeDonPourTous.getLot());
		Assert.assertEquals(regis.getId(), demandeDonPourTous.getEntite().getId());
		
		
		List<Demande> demandes = demandeRepo.findAll();
		Assert.assertEquals(2, demandes.size());
		
		demandeRepo.delete(demandeRegis);
		demandeRepo.delete(demandeDonPourTous);
		lotRepo.delete(pain);
		lotRepo.delete(chocolat);
		entiteRepo.delete(DonPourTous);
		entiteRepo.delete(regis);
			
	}
	
	
	@Test
	public void demandeFindAll() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IDemandeRepository demandeRepo = Application.getInstance().getDemandeRepo();
		ILotRepository lotRepo = Application.getInstance().getLotRepo();
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();
		
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
		pain.setPhoto("bkbkbk/dhvb/ihcv");
		pain.setVolume((long) 25);
		pain.setStatut(Statut.DISPONIBLE);
	
		
		Particulier regis = new Particulier("regis", 25);
		regis.setNom("SIMON");
		regis.setDonneur(false);
		regis.setBeneficiaire(true);
		
		Association DonPourTous = new Association("FR987654321", "justificatif2");
		DonPourTous.setNom("Dons pour tous");
		DonPourTous.setDonneur(false);
		DonPourTous.setBeneficiaire(true);
		
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		demandeRegis = demandeRepo.save(demandeRegis);
		
		chocolat = lotRepo.save(chocolat);
		pain = lotRepo.save(pain);
		DonPourTous =(Association) entiteRepo.save(DonPourTous);
		regis = (Particulier) entiteRepo.save(regis);
		
		demandeDonPourTous.setLot(pain);
		demandeDonPourTous.setEntite(DonPourTous);
		demandeRegis.setLot(chocolat);
		demandeRegis.setEntite(regis);
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		demandeRegis = demandeRepo.save(demandeRegis);
		
		
		
		List<Demande> demandes = demandeRepo.findAll();
		Assert.assertEquals(2, demandes.size());
		
		demandeRepo.delete(demandeDonPourTous);
		demandeRepo.delete(demandeRegis);
		lotRepo.delete(pain);
		lotRepo.delete(chocolat);
		entiteRepo.delete(DonPourTous);
		entiteRepo.delete(regis);
	}
	
	
	@Test
	public void createMessage () {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IMessageRepository messageRepo = Application.getInstance().getMessageRepo();
		IDemandeRepository demandeRepo = Application.getInstance().getDemandeRepo();
		
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
		
		
		messageDonPourTousLeclerc = messageRepo.save(messageDonPourTousLeclerc);
		messageLeclercDonPourTous = messageRepo.save(messageLeclercDonPourTous);
		messageRegis = messageRepo.save(messageRegis);
		messageLeclercRegis = messageRepo.save(messageLeclercRegis);
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		demandeRegis = demandeRepo.save(demandeRegis);
		
		messageDonPourTousLeclerc.setDemande(demandeDonPourTous);
		messageLeclercDonPourTous.setDemande(demandeDonPourTous);
		messageRegis.setDemande(demandeRegis);
		messageLeclercRegis.setDemande(demandeRegis);
		
		messageDonPourTousLeclerc = messageRepo.save(messageDonPourTousLeclerc);
		messageLeclercDonPourTous = messageRepo.save(messageLeclercDonPourTous);
		messageRegis = messageRepo.save(messageRegis);
		messageLeclercRegis = messageRepo.save(messageLeclercRegis);
		
		messageDonPourTousLeclerc = messageRepo.findById(messageDonPourTousLeclerc.getId());
		messageLeclercDonPourTous = messageRepo.findById(messageLeclercDonPourTous.getId());
		messageRegis = messageRepo.findById(messageRegis.getId());
		messageLeclercRegis = messageRepo.findById(messageLeclercRegis.getId());
		
		
		sopra.ShareYourFood.model.Message uFind = messageRepo.findById(messageDonPourTousLeclerc.getId());
		Assert.assertEquals("Bonjour, Don Pour Tous souhaiterai bénéficier de ce don. Nous vous remercions par avance.", uFind.getContenu());
		Assert.assertEquals(false, uFind.getDonneur());
		Assert.assertEquals(demandeDonPourTous.getId(), uFind.getDemande().getId());
		
		sopra.ShareYourFood.model.Message uFind2 = messageRepo.findById(messageLeclercDonPourTous.getId());
		Assert.assertEquals("Bien volontiers", uFind2.getContenu());
		Assert.assertEquals(true, uFind2.getDonneur());
		Assert.assertEquals(demandeDonPourTous.getId(), uFind2.getDemande().getId());
		
		sopra.ShareYourFood.model.Message uFind3 = messageRepo.findById(messageRegis.getId());
		Assert.assertEquals("Bonjour, est-il possible de disposer de chocolat ? Bien à vous", uFind3.getContenu());
		Assert.assertEquals(false, uFind3.getDonneur());
		Assert.assertEquals(demandeRegis.getId(), uFind3.getDemande().getId());
		
		sopra.ShareYourFood.model.Message uFind4 = messageRepo.findById(messageLeclercRegis.getId());
		Assert.assertEquals("Bien sur", uFind4.getContenu());
		Assert.assertEquals(true, uFind4.getDonneur());
		Assert.assertEquals(demandeRegis.getId(), uFind4.getDemande().getId());
		
		messageRepo.delete(messageDonPourTousLeclerc);
		messageRepo.delete(messageLeclercDonPourTous);
		messageRepo.delete(messageRegis);
		messageRepo.delete(messageLeclercRegis);
		
		demandeRepo.delete(demandeDonPourTous);
		demandeRepo.delete(demandeRegis);
	}
	
	
	@Test
	public void updateMessage() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IMessageRepository messageRepo = Application.getInstance().getMessageRepo();
		IDemandeRepository demandeRepo = Application.getInstance().getDemandeRepo();
		
		sopra.ShareYourFood.model.Message messageRegis = new sopra.ShareYourFood.model.Message();
		messageRegis.setContenu("Bonjour, est-il possible de disposer de chocolat ? Bien à vous");
		messageRegis.setDonneur(false);

		
		Demande demandeRegis = new Demande();
		try {
			demandeRegis.setDtDemande(sdf.parse("01/06/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		demandeRegis.setStatutNotif(StatutNotif.ACCEPTER);
		
		Demande demandeDonPourTous = new Demande();
		try {
			demandeDonPourTous.setDtDemande(sdf.parse("22/05/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		demandeDonPourTous.setStatutNotif(StatutNotif.ACCEPTER);
		
		
		messageRegis = messageRepo.save(messageRegis);
		messageRegis = messageRepo.findById(messageRegis.getId());
		
		demandeRegis = demandeRepo.save(demandeRegis);
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		
		messageRegis.setDemande(demandeRegis);
		messageRegis = messageRepo.save(messageRegis);
		
		messageRegis.setContenu("Finalement, je vais faire un don à l'association Don Pour Tous");
		messageRegis.setDonneur(true);
		messageRegis.setDemande(demandeDonPourTous);
		
		messageRegis = messageRepo.save(messageRegis);
		messageRegis = messageRepo.findById(messageRegis.getId());
		
		
		sopra.ShareYourFood.model.Message uFind3 = messageRepo.findById(messageRegis.getId());
		Assert.assertEquals("Finalement, je vais faire un don à l'association Don Pour Tous", uFind3.getContenu());
		Assert.assertEquals(true, uFind3.getDonneur());
		Assert.assertEquals(demandeDonPourTous.getId(), uFind3.getDemande().getId());
		
		
		messageRepo.delete(messageRegis);
		demandeRepo.delete(demandeRegis);
		demandeRepo.delete(demandeDonPourTous);
		
	}
	
	@Test
	public void messageFindAll() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IMessageRepository messageRepo = Application.getInstance().getMessageRepo();
		IDemandeRepository demandeRepo = Application.getInstance().getDemandeRepo();
		
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
		
		
		messageDonPourTousLeclerc = messageRepo.save(messageDonPourTousLeclerc);
		messageLeclercDonPourTous = messageRepo.save(messageLeclercDonPourTous);
		messageRegis = messageRepo.save(messageRegis);
		messageLeclercRegis = messageRepo.save(messageLeclercRegis);
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		demandeRegis = demandeRepo.save(demandeRegis);
		
		messageDonPourTousLeclerc.setDemande(demandeDonPourTous);
		messageLeclercDonPourTous.setDemande(demandeDonPourTous);
		messageRegis.setDemande(demandeRegis);
		messageLeclercRegis.setDemande(demandeRegis);
		
		messageDonPourTousLeclerc = messageRepo.save(messageDonPourTousLeclerc);
		messageLeclercDonPourTous = messageRepo.save(messageLeclercDonPourTous);
		messageRegis = messageRepo.save(messageRegis);
		messageLeclercRegis = messageRepo.save(messageLeclercRegis);
		
		messageDonPourTousLeclerc = messageRepo.findById(messageDonPourTousLeclerc.getId());
		messageLeclercDonPourTous = messageRepo.findById(messageLeclercDonPourTous.getId());
		messageRegis = messageRepo.findById(messageRegis.getId());
		messageLeclercRegis = messageRepo.findById(messageLeclercRegis.getId());
		
		
		List<Message> messages = messageRepo.findAll();
		Assert.assertEquals(4, messages.size());
		
		messageRepo.delete(messageDonPourTousLeclerc);
		messageRepo.delete(messageLeclercDonPourTous);
		messageRepo.delete(messageRegis);
		messageRepo.delete(messageLeclercRegis);
		
		demandeRepo.delete(demandeDonPourTous);
		demandeRepo.delete(demandeRegis);
		
	}

}
