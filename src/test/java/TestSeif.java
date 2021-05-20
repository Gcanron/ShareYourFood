import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.model.Utilisateur;
import sopra.ShareYourFood.repository.IUtilisateurRepository;

public class TestSeif {
	
	@Test
	public void utilisateurCreate() {
		
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
		
		Utilisateur uFind = utilisateurRepo.findById(cocoDu06.getId());
		Assert.assertEquals("Coco_du_06", uFind.getPseudo());
		Assert.assertEquals("azerty", uFind.getMotDePasse());
		Assert.assertEquals("cocodu06@gmail.com", uFind.getMail());
		Assert.assertEquals(true, uFind.getMessagerieActivation());
		
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
//		cocoDu06.setEntite(Leclerc);
		
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		cocoDu06 = utilisateurRepo.findById(cocoDu06.getId());
		
		cocoDu06.setPseudo("co_60");
		cocoDu06.setMotDePasse("ytreza");
		cocoDu06.setMail("co@hotmail.com");
		cocoDu06.setMessagerieActivation(false);
		
		
		cocoDu06 = utilisateurRepo.save(cocoDu06);
		cocoDu06 = utilisateurRepo.findById(cocoDu06.getId());
		
		Assert.assertEquals("co_60", cocoDu06.getPseudo());
		Assert.assertEquals("ytreza", cocoDu06.getMotDePasse());
		Assert.assertEquals("co@hotmail.com", cocoDu06.getMail());
		Assert.assertEquals(false, cocoDu06.getMessagerieActivation());
		
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
		
		Assert.assertEquals(3, utilisateurs.size());
		
		utilisateurRepo.delete(cocoDu06);
		utilisateurRepo.delete(sarahCze);
		utilisateurRepo.delete(aube);
		
	}

}
