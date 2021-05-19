package sopra.ShareYourFood.model;

public class Utilisateur {
	
	private Long id;
	private String pseudo;
	private String mail;
	private String motDePasse;
	private Boolean messagerieActivation;
	private Role role;
	private Entite entite;
	
	public Utilisateur() {
		super();
	}
	
	public Utilisateur(String pseudo, String mail, String motDePasse, Boolean messagerieActivation) {
		super();
		this.pseudo = pseudo;
		this.mail = mail;
		this.motDePasse = motDePasse;
		this.messagerieActivation = messagerieActivation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Boolean getMessagerieActivation() {
		return messagerieActivation;
	}

	public void setMessagerieActivation(Boolean messagerieActivation) {
		this.messagerieActivation = messagerieActivation;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [id=");
		builder.append(id);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", mail=");
		builder.append(mail);
		builder.append(", motDePasse=");
		builder.append(motDePasse);
		builder.append(", messagerieActivation=");
		builder.append(messagerieActivation);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
