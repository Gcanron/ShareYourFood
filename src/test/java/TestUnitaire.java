
import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.model.Lot;
import sopra.ShareYourFood.model.Produit;
import sopra.ShareYourFood.model.ProduitLot;
import sopra.ShareYourFood.model.Type;



public class TestUnitaire {

	@Test
	public void testProduitFindById() {
		Produit yaourt = new Produit();
		yaourt.setNom("yaourt");
		yaourt.setType(Type.valueOf("FRAIS"));
		
		yaourt = Application.getInstance().getProduitRepo().save(yaourt);
		Produit yaourtATester = Application.getInstance().getProduitRepo().findById(yaourt.getNom());
		
		Assert.assertEquals("yaourt", yaourtATester.getNom());
		
		Application.getInstance().getProduitRepo().delete(yaourt);
		
	}
	@Test
	public void testProduitFindAll() {
		Produit yaourt = new Produit();
		yaourt.setNom("yaourt");
		yaourt.setType(Type.valueOf("FRAIS"));
		
		Produit croissant = new Produit();
		croissant.setNom("pain");
		croissant.setType(Type.valueOf("PAIN_PATISSERIE"));

		yaourt = Application.getInstance().getProduitRepo().save(yaourt);
		croissant = Application.getInstance().getProduitRepo().save(croissant);
		
		List<Produit> produits = Application.getInstance().getProduitRepo().findAll();
		
		Assert.assertEquals(2L,produits.size());
		
		Application.getInstance().getProduitRepo().delete(yaourt);
		Application.getInstance().getProduitRepo().delete(croissant);
		
	}
	@Test
	public void testProduitLotFindById() {
		ProduitLot yaourt_lot1 = new ProduitLot();
		yaourt_lot1.setQuantite(1000L);
		
		yaourt_lot1 = Application.getInstance().getProduitLotRepo().save(yaourt_lot1);
		ProduitLot produitLotATester = Application.getInstance().getProduitLotRepo().findById(yaourt_lot1.getId());
		
		Long a = 1000L;
		Long b = produitLotATester.getQuantite();
		Assert.assertEquals(a, b);
		
		
		Application.getInstance().getProduitLotRepo().delete(yaourt_lot1);
		
	}
	@Test
	public void testProduitLotFindAll() {
		ProduitLot yaourt_lot1 = new ProduitLot();
		yaourt_lot1.setQuantite(1000L);

		
		ProduitLot yaourt_lot2 = new ProduitLot();
		yaourt_lot2.setQuantite(2000L);

		yaourt_lot1 = Application.getInstance().getProduitLotRepo().save(yaourt_lot1);
		yaourt_lot2 = Application.getInstance().getProduitLotRepo().save(yaourt_lot2);
		
		List<ProduitLot> produitLots = Application.getInstance().getProduitLotRepo().findAll();
		
		System.out.println(yaourt_lot1.getId());
		System.out.println(produitLots);
		Long a = 2L;
		Long b = (long) produitLots.size();
		
		Assert.assertEquals(a,b);
		
		Application.getInstance().getProduitLotRepo().delete(yaourt_lot1);
		Application.getInstance().getProduitLotRepo().delete(yaourt_lot2);
		
	}	
	@Test
	public void testLotFindById() {
		Lot lotNumber1 = new Lot();
		lotNumber1.setNom("Yaourt à gogo");
		lotNumber1.setVolume(400L);
		lotNumber1.setPhoto("C:/mesPhotos");
		
		lotNumber1 = Application.getInstance().getLotRepo().save(lotNumber1);
		Lot lotATester = Application.getInstance().getLotRepo().findById(lotNumber1.getId());
		
		Assert.assertEquals("Yaourt à gogo", lotATester.getNom());
		
		Application.getInstance().getLotRepo().delete(lotNumber1);
		
	}
	@Test
	public void testLotFindAll() {
		Lot lotNumber1 = new Lot();
		lotNumber1.setNom("Yaourt à gogo");
		lotNumber1.setVolume(400L);
		lotNumber1.setPhoto("C:/mesPhotos");
		
		Lot lotNumber2 = new Lot();
		lotNumber2.setNom("Yaourt à gogo");
		lotNumber2.setVolume(400L);
		lotNumber2.setPhoto("C:/mesPhotos");

		lotNumber1 = Application.getInstance().getLotRepo().save(lotNumber1);
		lotNumber2 = Application.getInstance().getLotRepo().save(lotNumber2);
		
		List<Lot> lots = Application.getInstance().getLotRepo().findAll();
		
		Assert.assertEquals(2L,lots.size());
		
		Application.getInstance().getLotRepo().delete(lotNumber1);
		Application.getInstance().getLotRepo().delete(lotNumber2);
		
	}
}
