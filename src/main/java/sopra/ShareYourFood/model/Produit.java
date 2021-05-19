package sopra.ShareYourFood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Produit")
public class Produit {
	@Id
	@Column(name = "nom")
	private String nom;
	@Column(name = "type")
	private Type type;
	private ProduitLot produitLot;

	public Produit() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public ProduitLot getProduitLot() {
		return produitLot;
	}

	public void setProduitLot(ProduitLot produitLot) {
		this.produitLot = produitLot;
	}

}
