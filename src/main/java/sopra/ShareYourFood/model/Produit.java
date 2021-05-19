package sopra.ShareYourFood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Produit")

public class Produit {
	@Id
	@Column(name = "nom")
	private String nom;
	@Column(name = "type")
	private Type type;
	@OneToMany(mappedBy = "produit")
	private List<ProduitLot> produitLots = new ArrayList<ProduitLot>();

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

	public List<ProduitLot> getProduitLots() {
		return produitLots;
	}

	public void setProduitLots(List<ProduitLot> produitLots) {
		this.produitLots = produitLots;
	}


}
