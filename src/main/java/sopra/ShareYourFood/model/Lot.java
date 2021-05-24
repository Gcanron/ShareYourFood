package sopra.ShareYourFood.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Lot")
public class Lot {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "volume")
	private Long volume;
	@Column(name = "dt_peremption_lot")
	private Date dtPeremptionLot;
	@Column(name = "photo")
	private String photo;
	@Column(name = "statut")
	private Statut statut;
	@ManyToOne
	@JoinColumn(name = "don_id")
	private Don don;
	@OneToMany(mappedBy = "lot")
	private List<Demande> demandes = new ArrayList<Demande>();
	@OneToMany(mappedBy = "lot")
	private List<ProduitLot> produitLots = new ArrayList<ProduitLot>();
	
	public Lot() {
		super();
	}

	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
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

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public Date getDtPeremptionLot() {
		return dtPeremptionLot;
	}

	public void setDtPeremptionLot(Date dtPeremptionLot) {
		this.dtPeremptionLot = dtPeremptionLot;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Don getDon() {
		return don;
	}

	public void setDon(Don don) {
		this.don = don;
	}

	public List<ProduitLot> getProduitLots() {
		return produitLots;
	}

	public void setProduitLots(List<ProduitLot> produitLots) {
		this.produitLots = produitLots;
	}



}
