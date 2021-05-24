import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.model.Adresse;
import sopra.ShareYourFood.model.Association;
import sopra.ShareYourFood.model.Categorie;
import sopra.ShareYourFood.model.Demande;
import sopra.ShareYourFood.model.Destinataire;
import sopra.ShareYourFood.model.Don;
import sopra.ShareYourFood.model.Entreprise;
import sopra.ShareYourFood.model.Particulier;
import sopra.ShareYourFood.model.Utilisateur;
import sopra.ShareYourFood.repository.IEntiteRepository;

public class TestAube {

	@Test
	public void CreateParticulier() {
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();

		Particulier aubeEntite = new Particulier("aubeline", 28);
		aubeEntite.setNom("PECQUE");
		aubeEntite.setDonneur(true);
		aubeEntite.setBeneficiaire(false);
		aubeEntite = (Particulier) entiteRepo.save(aubeEntite);

		Particulier aubeEntiteFind = (Particulier) entiteRepo.findById(aubeEntite.getId());
		Assert.assertEquals("aubeline", aubeEntiteFind.getPrenom());
		Assert.assertEquals("PECQUE", aubeEntiteFind.getNom());
		Assert.assertEquals(true, aubeEntiteFind.isDonneur());
		Assert.assertEquals(false, aubeEntiteFind.isBeneficiaire());

		entiteRepo.delete(aubeEntiteFind);

		Particulier aubeEntite2 = new Particulier("PECQUE", true, false, "Aubeline", 28);
		aubeEntite2 = (Particulier) entiteRepo.save(aubeEntite2);

		entiteRepo.delete(aubeEntite2);

	}

	@Test
	public void CreateAssociation() {
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();

		Association croixRougeEntite = new Association("FR123456789", "justificatif1");
		croixRougeEntite.setNom("La Croix Rouge");
		croixRougeEntite.setDonneur(true);
		croixRougeEntite.setBeneficiaire(true);
		croixRougeEntite = (Association) entiteRepo.save(croixRougeEntite);

		Association croixRougeEntiteFind = (Association) entiteRepo.findById(croixRougeEntite.getId());
		Assert.assertEquals("La Croix Rouge", croixRougeEntiteFind.getNom());
		Assert.assertEquals("FR123456789", croixRougeEntiteFind.getNumeroAssociation());
		Assert.assertEquals("justificatif1", croixRougeEntiteFind.getJustificatif());
		Assert.assertEquals(true, croixRougeEntiteFind.isDonneur());
		Assert.assertEquals(true, croixRougeEntiteFind.isBeneficiaire());

		entiteRepo.delete(croixRougeEntiteFind);

	}

	@Test
	public void CreateEntreprise() {
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();

		Entreprise leclerc = new Entreprise("5486935JH14S", Categorie.GRANDE_SURFACE);
		leclerc.setNom("Leclerc");
		leclerc.setDonneur(true);
		leclerc.setBeneficiaire(false);
		leclerc = (Entreprise) entiteRepo.save(leclerc);

		Entreprise leclercFind = (Entreprise) entiteRepo.findById(leclerc.getId());
		Assert.assertEquals("5486935JH14S", leclercFind.getSiret());
		Assert.assertEquals(Categorie.GRANDE_SURFACE, leclercFind.getCategorie());
		Assert.assertEquals("Leclerc", leclercFind.getNom());
		Assert.assertEquals(true, leclercFind.isDonneur());
		Assert.assertEquals(false, leclercFind.isBeneficiaire());

		entiteRepo.delete(leclercFind);
	}

	@Test
	public void updateParticulier() {
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();

		Particulier aubeEntite = new Particulier("aubeline", 28);
		aubeEntite.setNom("PECQUE");
		aubeEntite.setDonneur(true);
		aubeEntite.setBeneficiaire(false);
		aubeEntite = (Particulier) entiteRepo.save(aubeEntite);

		Particulier aubeEntite2 = (Particulier) entiteRepo.findById(aubeEntite.getId());
		aubeEntite2.setPrenom("aubeliiiiine");
		aubeEntite2 = (Particulier) entiteRepo.save(aubeEntite2);

		Assert.assertEquals("aubeliiiiine", aubeEntite2.getPrenom());

		entiteRepo.delete(aubeEntite2);
	}

	@Test
	public void addAdresseEntite() {
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();

		Particulier aubeEntite = new Particulier("aubeline", 28);
		aubeEntite.setNom("PECQUE");
		aubeEntite.setDonneur(true);
		aubeEntite.setBeneficiaire(false);

		Adresse adrAube = new Adresse("500 impasse Olympie", "Batiment A", "64000", "Pau");
		aubeEntite.addAdresse(adrAube);
		Particulier aubeEntite2 = (Particulier) entiteRepo.save(aubeEntite);

		entiteRepo.delete(aubeEntite2);

	}

	@Test
	public void addDonEntite() throws ParseException {
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Particulier aubeEntite = new Particulier("aubeline", 28);
		aubeEntite.setNom("PECQUE");
		aubeEntite.setDonneur(true);
		aubeEntite.setBeneficiaire(false);

		Adresse adrAube = new Adresse("1 impasse Olympie", "Batiment A", "64000", "Pau");

		aubeEntite.addAdresse(adrAube);

		Don donAubeline = new Don();
		donAubeline.setDateDeMiseEnLigne(sdf.parse("24/05/2021"));
		donAubeline.setCreneau("Entre 12h et 14h");
		donAubeline.setCommentaire("Pas d'urgence");
		donAubeline.setDestinataire(Destinataire.PARTICULIER);
		donAubeline.setAdresse(adrAube);

		aubeEntite.addDon(donAubeline);

		Particulier aubeEntite2 = (Particulier) entiteRepo.save(aubeEntite);

		entiteRepo.delete(aubeEntite2);
	}

	@Test
	public void addDemandeEntite() throws ParseException {
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Particulier aubeEntite = new Particulier("aubeline", 28);
		aubeEntite.setNom("PECQUE");
		aubeEntite.setDonneur(true);
		aubeEntite.setBeneficiaire(false);

		Adresse adrAube = new Adresse("999 impasse Olympie", "Batiment A", "64000", "Pau");

		aubeEntite.addAdresse(adrAube);

		Demande jeVeuxDesPates = new Demande();
		jeVeuxDesPates.setDtDemande(sdf.parse("24/05/2021"));

		aubeEntite.addDemande(jeVeuxDesPates);

		Particulier aubeEntite2 = (Particulier) entiteRepo.save(aubeEntite);

		entiteRepo.delete(aubeEntite2);
	}

	@Test
	public void addUtilisateurEntite() {
		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();

		Association croixRougeEntite = new Association("FR123456789", "justificatif1");
		croixRougeEntite.setNom("La Croix Rouge");
		croixRougeEntite.setDonneur(true);
		croixRougeEntite.setBeneficiaire(true);
		croixRougeEntite = (Association) entiteRepo.save(croixRougeEntite);

		Adresse adrCroixRouge = new Adresse("9 avenue Gambetta", null, "13001", "Marseille");
		croixRougeEntite.addAdresse(adrCroixRouge);

		Utilisateur benevoleCroixRouge1 = new Utilisateur();
		benevoleCroixRouge1.setPseudo("Toto65");
		benevoleCroixRouge1.setMotDePasse("azerty123");
		benevoleCroixRouge1.setMail("toto65@gmail.com");
		benevoleCroixRouge1.setMessagerieActivation(true);

		croixRougeEntite.addUtilisateur(benevoleCroixRouge1);

		Association croixRougeEntite2 = (Association) entiteRepo.save(croixRougeEntite);

		entiteRepo.delete(croixRougeEntite2);
	}

//	@Test
//	public void EntiteGetAdresse() {
//		
//		IEntiteRepository entiteRepo = Application.getInstance().getEntiteRepo();
//
//		Particulier aubeEntite = new Particulier("aubeline", 28);
//		aubeEntite.setNom("pecque");
//		
//		Adresse adrAube = new Adresse("01 impasse Olympie", "Batiment A", "64000", "Pau");
//		aubeEntite.addAdresse(adrAube);
//		
//		aubeEntite = (Particulier) entiteRepo.save(aubeEntite);
//		
//		Particulier aubeEntiteFind = (Particulier) entiteRepo.findByNom("pecque");
//		for (Adresse adr : aubeEntiteFind.getAdresses()) {
//			if () {
//				
//			}
//		}
//		
//	}

}