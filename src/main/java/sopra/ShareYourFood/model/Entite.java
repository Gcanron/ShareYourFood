package sopra.ShareYourFood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Entite")
public class Entite {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "nom", length = 255)
	private String nom;
	@Column(name = "donneur", length = 255)
	private boolean donneur;
	@Column(name = "beneficiaire", length = 255)
	private boolean beneficiaire;
	
	public Entite() {
		super();
	}
	public Entite(String nom, boolean donneur, boolean beneficiaire) {
		super();
		this.nom = nom;
		this.donneur = donneur;
		this.beneficiaire = beneficiaire;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean isDonneur() {
		return donneur;
	}
	public void setDonneur(boolean donneur) {
		this.donneur = donneur;
	}
	public boolean isBeneficiaire() {
		return beneficiaire;
	}
	public void setBeneficiaire(boolean beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	

	@Override
	public String toString() {
		return "Entite [id=" + id + ", nom=" + nom + ", donneur=" + donneur + ", beneficiaire=" + beneficiaire + "]";
	}
	

}
