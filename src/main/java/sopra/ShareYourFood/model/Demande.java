package sopra.ShareYourFood.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demande {
	
	private Long id;
	private Date dtDemande;
	private StatutNotif statutNotif;
	private Entite entite;
	private Lot lot;
	private List<Message> message = new ArrayList<Message>();
	
	public Demande() {
		super();
	}
	
	public Demande(Date dtDemande, StatutNotif statutNotif, Entite entite, Lot lot, List<Message> message) {
		super();
		this.dtDemande = dtDemande;
		this.statutNotif = statutNotif;
		this.entite = entite;
		this.lot = lot;
		this.message = message;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Demande [id=");
		builder.append(id);
		builder.append(", dtDemande=");
		builder.append(dtDemande);
		builder.append(", statutNotif=");
		builder.append(statutNotif);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	

}
