package sopra.ShareYourFood.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
//
//@Entity
//@Table(name = "Produit_lot")
public class ProduitLot {
	private Produit produit;
	private Lot lot;
	
	private Date dtPeremption;
	private Long quantite;
	
	
	
	
	public ProduitLot() {
		super();
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Lot getLot() {
		return lot;
	}
	public void setLot(Lot lot) {
		this.lot = lot;
	}
	public Date getDtPeremption() {
		return dtPeremption;
	}
	public void setDtPeremption(Date dtPeremption) {
		this.dtPeremption = dtPeremption;
	}
	public Long getQuantite() {
		return quantite;
	}
	public void setQuantite(Long quantite) {
		this.quantite = quantite;
	}
	
}
