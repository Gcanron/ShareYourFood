package sopra.ShareYourFood.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Don")
public class Don {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "date_de_mise_en_ligne", length = 255)
	private Date dateDeMiseEnLigne ;
	@Column(name = "créneau", length = 255)
	private String creneau;
	@Column(name = "commentaire", length = 255)
	private String commentaire;
	@Column(name = "destinataire", length = 255)
	private Destinataire destinataire;
	
	@ManyToOne
	@JoinColumn(name = "entite_id")
	private Entite entite;
	
	@OneToMany(mappedBy = "don")
	private List<Lot> lot = new ArrayList<Lot>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adresse_id")
	private Adresse adresse;
	
	public Don() {
		super();
	}

	public Don(Date dateDeMiseEnLigne, String creneau, String commentaire, Destinataire destinataire) {
		super();
		this.dateDeMiseEnLigne = dateDeMiseEnLigne;
		this.creneau = creneau;
		this.commentaire = commentaire;
		this.destinataire = destinataire;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateDeMiseEnLigne() {
		return dateDeMiseEnLigne;
	}
	public void setDateDeMiseEnLigne(Date dateDeMiseEnLigne) {
		this.dateDeMiseEnLigne = dateDeMiseEnLigne;
	}
	public String getCreneau() {
		return creneau;
	}
	public void setCreneau(String creneau) {
		this.creneau = creneau;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Destinataire getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(Destinataire destinataire) {
		this.destinataire = destinataire;
	}

	@Override
	public String toString() {
		return "Don [id=" + id + ", dateDeMiseEnLigne=" + dateDeMiseEnLigne + ", creneau=" + creneau + ", commentaire="
				+ commentaire + ", destinataire=" + destinataire + "]";
	}
}
