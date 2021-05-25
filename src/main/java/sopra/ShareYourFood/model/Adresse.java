package sopra.ShareYourFood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity

public class Adresse {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "rue", length = 255)
	private String rue;
	@Column(name = "complement", length = 255)
	private String complement;
	@Column(name = "codePostal", length = 10)
	private String codePostal;
	@Column(name = "ville", length = 255)
	private String ville;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entite_id")
	private Entite entite;
	
	@OneToOne(mappedBy = "adresse")
	private Don don;
	
	public Adresse() {
		super();
	}	
	
	public Adresse(String rue, String complement, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.complement = complement;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	public Don getDon() {
		return don;
	}

	public void setDon(Don don) {
		this.don = don;
	}

	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	


	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", complement=" + complement + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}
	
	

}
