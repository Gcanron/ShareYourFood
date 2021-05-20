
import org.junit.Test;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.model.Produit;
import sopra.ShareYourFood.model.Type;

import static org.junit.Assert.*;

import org.junit.Assert;



public class TestUnitaire {

	@Test
	public void testProduitFindById() {
		Produit yaourt = new Produit();
		yaourt.setNom("yaourt");
		yaourt.setType(Type.valueOf("FRAIS"));
		
		yaourt = Application.getInstance().getProduitRepo().save(yaourt);
		Produit yaourtATester = Application.getInstance().getProduitRepo().findById(yaourt.getNom());
		
		Assert.assertEquals("yaourt", yaourtATester.getNom());
		
		
		
	}
	@Test
	public void testProduitSave() {
		fail("Not yet implemented");
	}
	@Test
	public void testProduitdelete() {
		fail("Not yet implemented");
	}
	@Test
	public void testProduitFindAll() {
		fail("Not yet implemented");
	}

}
