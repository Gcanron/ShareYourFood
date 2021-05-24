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
import sopra.ShareYourFood.model.StatutNotif;
import sopra.ShareYourFood.model.StatutReservation;
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
		
		
		Particulier aubeline = new Particulier("aubeline", 28);
		aubeline.setNom("PECQUE");
		aubeline.setDonneur(true);
		aubeline.setBeneficiaire(false);
		entiteRepo.save(aubeline);
	

		Particulier sarah = new Particulier("sarah", 25);
		sarah.setNom("CAZE");
		sarah.setDonneur(true);
		sarah.setBeneficiaire(false);
		entiteRepo.save(sarah);
		
		Particulier regis = new Particulier("regis", 25);
		regis.setNom("SIMON");
		regis.setDonneur(false);
		regis.setBeneficiaire(true);
		entiteRepo.save(regis);
		

		Association CroixRouge = new Association("FR123456789", "justificatif1");
		CroixRouge.setNom("La Croix Rouge");
		CroixRouge.setDonneur(true);
		CroixRouge.setBeneficiaire(true);
		entiteRepo.save(CroixRouge);

		Association DonPourTous = new Association("FR987654321", "justificatif2");
		DonPourTous.setNom("Dons pour tous");
		DonPourTous.setDonneur(false);
		DonPourTous.setBeneficiaire(true);
		entiteRepo.save(DonPourTous);

		Entreprise Leclerc = new Entreprise("5486935JH14S", Categorie.GRANDE_SURFACE);
		Leclerc.setNom("Leclerc");
		Leclerc.setDonneur(true);
		Leclerc.setBeneficiaire(false);
		entiteRepo.save(Leclerc);
		
		
		Adresse adrSarahCze = new Adresse("75 rue d'Athènes", "bis", "33000", "Bordeaux");
		Adresse adrCroixRouge = new Adresse("9 avenue Gambetta", null, "13001", "Marseille");
		Adresse adrDonPourTous = new Adresse("277 boulevard Leon Blum", "Bâtiment C", "75004", "Paris");
		Adresse adrLeclerc = new Adresse("50 avenue Gutemberg", "Zone commerciale Soleil", "33700", "Mérignac");
		Adresse adrRegis = new Adresse("3 avenue Molière", null, "33000", "Bordeaux");
		
		adresseRepo.save(adrSarahCze);
		adresseRepo.save(adrCroixRouge);
		adresseRepo.save(adrDonPourTous);
		adresseRepo.save(adrLeclerc);
		adresseRepo.save(adrRegis);
		
		adrSarahCze.setEntite(sarah);
		adrCroixRouge.setEntite(CroixRouge);
		adrDonPourTous.setEntite(DonPourTous);
		adrLeclerc.setEntite(Leclerc);
		adrRegis.setEntite(regis);
		
		sarah = (Particulier) entiteRepo.save(sarah);
		regis = (Particulier) entiteRepo.save(regis);
		CroixRouge = (Association) entiteRepo.save(CroixRouge);
		DonPourTous = (Association) entiteRepo.save(DonPourTous);
		Leclerc = (Entreprise) entiteRepo.save(Leclerc);
		
		
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
		
		donRepo.save(donLeclerc); 
		
		
		Lot chocolat = new Lot();
		chocolat.setNom("Chocolat");
		try {
			chocolat.setDtPeremptionLot(sdf.parse("05/07/2022"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		chocolat.setPhoto("djvbv/didz/yugi");
		chocolat.setVolume((long) 50);
		chocolat.setStatut(StatutReservation.DISPONIBLE);
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
		pain.setStatut(StatutReservation.DISPONIBLE);
		pain.setDon(donLeclerc);
		
		lotRepo.save(pain);
		lotRepo.save(chocolat);
		
		
		Demande demandeDonPourTous = new Demande();
		try {
			demandeDonPourTous.setDtDemande(sdf.parse("22/05/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		demandeDonPourTous.setLot(pain);
		demandeDonPourTous.setStatutNotif(StatutNotif.ACCEPTER);
		demandeDonPourTous.setEntite(DonPourTous);
		
		Demande demandeRegis = new Demande();
		try {
			demandeRegis.setDtDemande(sdf.parse("01/06/2021"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		demandeRegis.setLot(chocolat);
		demandeRegis.setStatutNotif(StatutNotif.ACCEPTER);
		demandeRegis.setEntite(regis);
		
		demandeRepo.save(demandeRegis);
		demandeRepo.save(demandeDonPourTous);
		
		sopra.ShareYourFood.model.Message messageDonPourTousLeclerc = new sopra.ShareYourFood.model.Message();
		messageDonPourTousLeclerc.setContenu("Bonjour, Don Pour Tous souhaiterai bénéficier de ce don. Nous vous remercions par avance.");
		messageDonPourTousLeclerc.setDemande(demandeDonPourTous);
		messageDonPourTousLeclerc.setDonneur(false);
		
		sopra.ShareYourFood.model.Message messageLeclercDonPourTous = new sopra.ShareYourFood.model.Message();
		messageLeclercDonPourTous.setContenu("Bien volontiers");
		messageLeclercDonPourTous.setDemande(demandeDonPourTous);
		messageLeclercDonPourTous.setDonneur(true);
		
		
		sopra.ShareYourFood.model.Message messageRegis = new sopra.ShareYourFood.model.Message();
		messageRegis.setContenu("Bonjour, est-il possible de disposer de chocolat ? Bien à vous");
		messageRegis.setDemande(demandeRegis);
		messageRegis.setDonneur(false);
		
		sopra.ShareYourFood.model.Message messageLeclercRegis = new sopra.ShareYourFood.model.Message();
		messageLeclercRegis.setContenu("Bien sur");
		messageLeclercRegis.setDemande(demandeRegis);
		messageLeclercRegis.setDonneur(true);
		
		messageRepo.save(messageDonPourTousLeclerc);
		messageRepo.save(messageLeclercDonPourTous);
		messageRepo.save(messageRegis);
		messageRepo.save(messageLeclercRegis);
		
		messageDonPourTousLeclerc.setDemande(demandeDonPourTous);
		messageLeclercDonPourTous.setDemande(demandeDonPourTous);
		messageRegis.setDemande(demandeRegis);
		messageLeclercRegis.setDemande(demandeRegis);
		

	}

}
