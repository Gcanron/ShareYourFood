package sopra.ShareYourFood.model;

public class Entreprise {

	private String siret;
	private Categorie categorie;

	public Entreprise() {
		super();
	}

	public Entreprise(String siret, Categorie categorie) {
		super();
		this.siret = siret;
		this.categorie = categorie;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
