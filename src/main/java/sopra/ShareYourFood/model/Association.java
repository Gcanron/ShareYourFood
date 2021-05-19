package sopra.ShareYourFood.model;

public class Association extends Entite {

	private String numeroAssociation;
	private String justificatif;

	public Association() {
		super();
	}

	public Association(String numeroAssociation, String justificatif) {
		super();
		this.numeroAssociation = numeroAssociation;
		this.justificatif = justificatif;
	}

	public String getNumeroAssociation() {
		return numeroAssociation;
	}

	public void setNumeroAssociation(String numeroAssociation) {
		this.numeroAssociation = numeroAssociation;
	}

	public String getJustificatif() {
		return justificatif;
	}

	public void setJustificatif(String justificatif) {
		this.justificatif = justificatif;
	}

}
