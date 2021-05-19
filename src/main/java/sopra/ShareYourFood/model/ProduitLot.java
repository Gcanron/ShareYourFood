package sopra.ShareYourFood.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "Produit_lot",uniqueConstraints = @UniqueConstraint(columnNames = { "produit_nom","lot_id"}))
public class ProduitLot {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "dtperemption")
	private Date dtPeremption;
	@Column(name = "quantite")
	private Long quantite;
	@ManyToOne
	@JoinColumn(name = "produit_nom")
	private Produit produit;
	@ManyToOne
	@JoinColumn(name = "lot_id")
	private Lot lot;
	

	
	
	
	
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
