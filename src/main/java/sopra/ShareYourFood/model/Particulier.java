package sopra.ShareYourFood.model;

public class Particulier extends Entite {

	private String prenom;
	private Integer age;

	public Particulier() {
		super();
	}

	public Particulier(String prenom, Integer age) {
		super();
		this.prenom = prenom;
		this.age = age;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
