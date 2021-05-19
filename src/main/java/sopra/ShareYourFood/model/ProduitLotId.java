package sopra.ShareYourFood.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Embeddable
public class ProduitLotId implements Serializable {

	private static final long serialVersionUID = 1L;
//	@Column(name = "produit")
	private Produit produit;
	
//	@Column(name = "lot")
	private Lot lot;

	public ProduitLotId() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lot == null) ? 0 : lot.hashCode());
		result = prime * result + ((produit == null) ? 0 : produit.hashCode());
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
		ProduitLotId other = (ProduitLotId) obj;
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
		return true;
	}
	
}
