package sopra.ShareYourFood.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "Produit_lot")
@IdClass(ProduitLotId.class)
public class ProduitLot {
	@Id
	private Produit produit;
	@Id
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtPeremption == null) ? 0 : dtPeremption.hashCode());
		result = prime * result + ((lot == null) ? 0 : lot.hashCode());
		result = prime * result + ((produit == null) ? 0 : produit.hashCode());
		result = prime * result + ((quantite == null) ? 0 : quantite.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProduitLot other = (ProduitLot) obj;
		if (dtPeremption == null) {
			if (other.dtPeremption != null)
				return false;
		} else if (!dtPeremption.equals(other.dtPeremption))
			return false;
		if (lot == null) {
			if (other.lot != null)
				return false;
		} else if (!lot.equals(other.lot))
			return false;
		if (produit == null) {
			if (other.produit != null)
				return false;
		} else if (!produit.equals(other.produit))
			return false;
		if (quantite == null) {
			if (other.quantite != null)
				return false;
		} else if (!quantite.equals(other.quantite))
			return false;
		return true;
	}
	
}
