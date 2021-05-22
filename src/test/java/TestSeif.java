import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.model.Demande;
import sopra.ShareYourFood.model.Role;
import sopra.ShareYourFood.model.StatutNotif;
import sopra.ShareYourFood.model.Utilisateur;
import sopra.ShareYourFood.repository.IDemandeRepository;
import sopra.ShareYourFood.repository.IMessageRepository;
import sopra.ShareYourFood.repository.IUtilisateurRepository;

public class TestSeif {
	
	@Test
	public void utilisateurCreate() {
		
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		
		
		Utilisateur cocoDu06 = new Utilisateur("Coco_du_06", "cocodu06@gmail.com","azerty", true);
		cocoDu06.setRole(Role.MEMBRE);
//		cocoDu06.setEntite(Leclerc);

		Utilisateur toto65 = new Utilisateur();
		toto65.setPseudo("Toto65");
		toto65.setMotDePasse("azerty123");
		toto65.setMail("toto65@gmail.com");
		toto65.setMessagerieActivation(true);
		toto65.setRole(Role.ADMINISTRATEUR);
//		toto65.setEntite(CroixRouge);

		Utilisateur aube = new Utilisateur();
		aube.setPseudo("Aube");
		aube.setMotDePasse("azerty1234");
		aube.setMail("aubeline.pecque@hotmail.com");
		aube.setMessagerieActivation(true);
//		aube.setEntite(aubeline);

		Utilisateur sarahCze = new Utilisateur();
		sarahCze.setPseudo("SarahCZE");
		sarahCze.setMotDePasse("azerty12345");
		sarahCze.setMail("sarah.caze@hotmail.com");
		sarahCze.setMessagerieActivation(true);
//		sarahCze.setEntite(sarah);
		
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

	}
	
	@Test
	public void utilisateurUpdate() {
		
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		
		
		Utilisateur cocoDu06 = new Utilisateur();
		cocoDu06.setPseudo("Coco_du_06");
		cocoDu06.setMotDePasse("azerty");
		cocoDu06.setMail("cocodu06@gmail.com");
		cocoDu06.setMessagerieActivation(true);
		cocoDu06.setRole(Role.MEMBRE);
//		cocoDu06.setEntite(Leclerc);
		
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		cocoDu06 = utilisateurRepo.findById(cocoDu06.getId());
		
		cocoDu06.setPseudo("co_60");
		cocoDu06.setMotDePasse("ytreza");
		cocoDu06.setMail("co@hotmail.com");
		cocoDu06.setMessagerieActivation(false);
		cocoDu06.setRole(Role.ADMINISTRATEUR);
		
		
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		cocoDu06 = utilisateurRepo.findById(cocoDu06.getId());
		
		Assert.assertEquals("co_60", cocoDu06.getPseudo());
		Assert.assertEquals("ytreza", cocoDu06.getMotDePasse());
		Assert.assertEquals("co@hotmail.com", cocoDu06.getMail());
		Assert.assertEquals(false, cocoDu06.getMessagerieActivation());
		Assert.assertEquals(Role.ADMINISTRATEUR, cocoDu06.getRole());
		
		utilisateurRepo.delete(cocoDu06);
		
	}
	
	@Test
	public void utilisateurFindAll() {
		
		IUtilisateurRepository utilisateurRepo = Application.getInstance().getUtilisateurRepo();
		
		Utilisateur cocoDu06 = new Utilisateur();
		cocoDu06.setPseudo("Coco_du_06");
		cocoDu06.setMotDePasse("azerty");
		cocoDu06.setMail("cocodu06@gmail.com");
		cocoDu06.setMessagerieActivation(true);
//		cocoDu06.setEntite(Leclerc);

		Utilisateur toto65 = new Utilisateur();
		toto65.setPseudo("Toto65");
		toto65.setMotDePasse("azerty123");
		toto65.setMail("toto65@gmail.com");
		toto65.setMessagerieActivation(true);
//		toto65.setEntite(CroixRouge);

		Utilisateur aube = new Utilisateur();
		aube.setPseudo("Aube");
		aube.setMotDePasse("azerty1234");
		aube.setMail("aubeline.pecque@hotmail.com");
		aube.setMessagerieActivation(true);
//		aube.setEntite(aubeline);

		Utilisateur sarahCze = new Utilisateur();
		sarahCze.setPseudo("SarahCZE");
		sarahCze.setMotDePasse("azerty12345");
		sarahCze.setMail("sarah.caze@hotmail.com");
		sarahCze.setMessagerieActivation(true);
//		sarahCze.setEntite(sarah);
		
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
		
	}
	
	@Test
	public void demandeCreate() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IDemandeRepository demandeRepo = Application.getInstance().getDemandeRepo();
		
		Demande demandeDonPourTous = new Demande();
		try {
			demandeDonPourTous.setDtDemande(sdf.parse("22/05/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		demandeDonPourTous.setLot(pain);
		demandeDonPourTous.setStatutNotif(StatutNotif.ACCEPTER);
//		demandeDonPourTous.setEntite(DonPourTous);
		
		
		Demande demandeRegis = new Demande();
		try {
			demandeRegis.setDtDemande(sdf.parse("01/06/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		demandeRegis.setLot(chocolat);
		demandeRegis.setStatutNotif(StatutNotif.ACCEPTER);
//		demandeRegis.setEntite(regis);
		
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
		
	}
	
	@Test
	public void demandeUpdate() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IDemandeRepository demandeRepo = Application.getInstance().getDemandeRepo();
		
		Demande demandeDonPourTous = new Demande();
		try {
			demandeDonPourTous.setDtDemande(sdf.parse("22/05/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		demandeDonPourTous.setLot(pain);
		demandeDonPourTous.setStatutNotif(StatutNotif.ACCEPTER);
//		demandeDonPourTous.setEntite(DonPourTous);
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		demandeDonPourTous = demandeRepo.findById(demandeDonPourTous.getId());
		
		
		Demande demandeRegis = new Demande();
		try {
			demandeRegis.setDtDemande(sdf.parse("01/06/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		demandeRegis.setLot(chocolat);
		demandeRegis.setStatutNotif(StatutNotif.ACCEPTER);
//		demandeRegis.setEntite(regis);
		
		demandeRegis = demandeRepo.save(demandeRegis);
		demandeRegis = demandeRepo.findById(demandeRegis.getId());
		
		
		try {
			demandeDonPourTous.setDtDemande(sdf.parse("26/12/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		demandeDonPourTous.setStatutNotif(StatutNotif.ARCHIVER);
		
		try {
			demandeRegis.setDtDemande(sdf.parse("10/07/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		demandeRegis.setStatutNotif(StatutNotif.REFUSER);
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		demandeRegis = demandeRepo.save(demandeRegis);
		demandeDonPourTous = demandeRepo.findById(demandeDonPourTous.getId());
		demandeRegis = demandeRepo.findById(demandeRegis.getId());
		
		
		
		try {
			Assert.assertEquals(sdf.parse("26/12/2021"), demandeDonPourTous.getDtDemande());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(StatutNotif.ARCHIVER, demandeDonPourTous.getStatutNotif());
		
		try {
			Assert.assertEquals(sdf.parse("10/07/2021"), demandeRegis.getDtDemande());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(StatutNotif.REFUSER, demandeRegis.getStatutNotif());
		
		
		List<Demande> demandes = demandeRepo.findAll();
		Assert.assertEquals(2, demandes.size());
		
		demandeRepo.delete(demandeDonPourTous);
		demandeRepo.delete(demandeRegis);
		
	}
	
	
	@Test
	public void demandeFindAll() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IDemandeRepository demandeRepo = Application.getInstance().getDemandeRepo();
		
		Demande demandeDonPourTous = new Demande();
		try {
			demandeDonPourTous.setDtDemande(sdf.parse("22/05/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		demandeDonPourTous.setLot(pain);
		demandeDonPourTous.setStatutNotif(StatutNotif.ACCEPTER);
//		demandeDonPourTous.setEntite(DonPourTous);
		
		demandeDonPourTous = demandeRepo.save(demandeDonPourTous);
		demandeDonPourTous = demandeRepo.findById(demandeDonPourTous.getId());
		
		
		Demande demandeRegis = new Demande();
		try {
			demandeRegis.setDtDemande(sdf.parse("01/06/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		demandeRegis.setLot(chocolat);
		demandeRegis.setStatutNotif(StatutNotif.ACCEPTER);
//		demandeRegis.setEntite(regis);
		
		demandeRegis = demandeRepo.save(demandeRegis);
		demandeRegis = demandeRepo.findById(demandeRegis.getId());
		
		List<Demande> demandes = demandeRepo.findAll();
		Assert.assertEquals(2, demandes.size());
		
		demandeRepo.delete(demandeDonPourTous);
		demandeRepo.delete(demandeRegis);
		
		
	}

}
