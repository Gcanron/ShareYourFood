import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.model.Adresse;
import sopra.ShareYourFood.model.Destinataire;
import sopra.ShareYourFood.model.Don;
import sopra.ShareYourFood.model.Entite;
import sopra.ShareYourFood.repository.IAdresseRepository;
import sopra.ShareYourFood.repository.IDonRepository;
import sopra.ShareYourFood.repository.IEntiteRepository;

public class TestSarah {
	
	@Test
	public void entiteCreate() throws ParseException {	
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();
		Entite entite1 = new Entite("Leclerc",true,false);
		
		entite1 = entiteRepo.save(entite1);
		
		Entite entiteFind = entiteRepo.findById(entite1.getId());
		Assert.assertEquals("Leclerc", entiteFind.getNom());
		Assert.assertEquals(true, entiteFind.isDonneur());
		Assert.assertEquals(false, entiteFind.isBeneficiaire());
		
		entiteRepo.delete(entite1);		
	}
	
	
	@Test
	public void entiteUpdate() throws ParseException {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
			
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();
		Entite entite1 = new Entite("Leclerc",true,false);
		
		entite1 = entiteRepo.save(entite1);
		
		Entite entiteFind = entiteRepo.findById(entite1.getId());
		entite1.setNom("Leclerc");
		Assert.assertEquals("Leclerc", entiteFind.getNom());
		entite1.setDonneur(false);
		Assert.assertEquals(true, entiteFind.isDonneur());
		entite1.setBeneficiaire(true);
		Assert.assertEquals(false, entiteFind.isBeneficiaire());
		
		entiteRepo.delete(entite1);	
		
	}	
	
	@Test
	public void adresseCreate() throws ParseException {	
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		
		IAdresseRepository adresseRepo = Application.getInstance().getAdresseRepo();
		Adresse adrLeclerc = new Adresse("50 avenue Gutemberg", "Zone commerciale Soleil", "33700", "Mérignac");
		
		adrLeclerc = adresseRepo.save(adrLeclerc);
		
		Adresse adrfind = adresseRepo.findById(adrLeclerc.getId());
		Assert.assertEquals("50 avenue Gutemberg", adrfind.getRue());
		Assert.assertEquals("Zone commerciale Soleil", adrfind.getComplement());
		Assert.assertEquals("33700", adrfind.getCodePostal());
		Assert.assertEquals("Mérignac", adrfind.getVille());
		
		adresseRepo.delete(adrLeclerc);		
	}
	
	
	@Test
	public void adresseUpdate() throws ParseException {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");

		IAdresseRepository adresseRepo = Application.getInstance().getAdresseRepo();
		Adresse adrLeclerc = new Adresse("50 avenue Gutemberg", "Zone commerciale Soleil", "33700", "Mérignac");
		
		adrLeclerc = adresseRepo.save(adrLeclerc);
		
		Adresse adrfind = adresseRepo.findById(adrLeclerc.getId());
		
		adrLeclerc.setRue("52 avenue Gutemberg");		
		adrLeclerc.setComplement("Zone commerciale Soleil");		
		adrLeclerc.setCodePostal("33150");		
		adrLeclerc.setVille("Cenon");
		
		adrLeclerc = adresseRepo.save(adrLeclerc);
		adrfind = adresseRepo.findById(adrLeclerc.getId());
				
		Assert.assertEquals("52 avenue Gutemberg", adrfind.getRue());
		Assert.assertEquals("Zone commerciale Soleil", adrfind.getComplement());
		Assert.assertEquals("33150", adrfind.getCodePostal());
		Assert.assertEquals("Cenon", adrfind.getVille());
		
		adresseRepo.delete(adrLeclerc);			
	}	


	@Test
	public void donCreate() throws ParseException {	
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		IDonRepository donRepo = Application.getInstance().getDonRepo();
		Don donLeclerc = new Don(sdf.parse("24/05/2021"),"de 13h à 15h","DLC à peine passée, mais encore en bon état",Destinataire.ASSOCIATION);
		
		donLeclerc = donRepo.save(donLeclerc);
		
		Don donfind = donRepo.findById(donLeclerc.getId());
		
		Assert.assertEquals(sdf.parse("24/05/2021"), donfind.getDateDeMiseEnLigne());
		Assert.assertEquals("de 13h à 15h", donfind.getCreneau());
		Assert.assertEquals("DLC à peine passée, mais encore en bon état", donfind.getCommentaire());
		Assert.assertEquals(Destinataire.ASSOCIATION, donfind.getDestinataire());
		
		donRepo.delete(donLeclerc);		
	}
	
	
	@Test
	public void donUpdate() throws ParseException {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:application-context.xml");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		IDonRepository donRepo = Application.getInstance().getDonRepo();
		Don donLeclerc = new Don(sdf.parse("24/05/2021"),"de 13h à 15h","DLC à peine passée, mais encore en bon état",Destinataire.ASSOCIATION);
		
		donLeclerc = donRepo.save(donLeclerc);		
		Don donfind = donRepo.findById(donLeclerc.getId());
		
		donLeclerc.setDateDeMiseEnLigne(sdf.parse("24/05/2021"));	
		donLeclerc.setCreneau("de 14h à 15h");
		donLeclerc.setCommentaire("DLC à peine passée, mais encore en bon état");		
		donLeclerc.setDestinataire(Destinataire.ASSOCIATION);	
		
		donLeclerc = donRepo.save(donLeclerc);		
		donfind = donRepo.findById(donLeclerc.getId());
		
		Assert.assertEquals(sdf.parse("24/05/2021"), donfind.getDateDeMiseEnLigne());
		Assert.assertEquals("de 14h à 15h", donfind.getCreneau());
		Assert.assertEquals("DLC à peine passée, mais encore en bon état", donfind.getCommentaire());
		Assert.assertEquals(Destinataire.ASSOCIATION, donfind.getDestinataire());
		
		donRepo.delete(donLeclerc);			
	}

}
