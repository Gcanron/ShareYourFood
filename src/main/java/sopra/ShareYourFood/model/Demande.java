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
@Table(name="demande")
public class Demande {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="dt_demande")
	private Date dtDemande;
	@Column(name="statut_notif")
	private StatutNotif statutNotif;
	@ManyToOne
	@JoinColumn(name = "entite_id")
	private Entite entite;
	@ManyToOne
	@JoinColumn(name = "lot_id")
	private Lot lot;
	@OneToMany(mappedBy = "demande")
	private List<Message> message = new ArrayList<Message>();
	
	public Demande() {
		super();
	}
	
	public Demande(Date dtDemande, StatutNotif statutNotif, Entite entite, Lot lot) {
		super();
		this.dtDemande = dtDemande;
		this.statutNotif = statutNotif;
		this.entite = entite;
		this.lot = lot;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDtDemande() {
		return dtDemande;
	}

	public void setDtDemande(Date dtDemande) {
		this.dtDemande = dtDemande;
	}

	public StatutNotif getStatutNotif() {
		return statutNotif;
	}

	public void setStatutNotif(StatutNotif statutNotif) {
		this.statutNotif = statutNotif;
	}

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	

	
	
	
	
	

}
