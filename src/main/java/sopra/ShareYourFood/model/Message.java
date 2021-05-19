package sopra.ShareYourFood.model;

public class Message {
	
	private Long id;
	private String contenu;
	private Boolean donneur;
	private Demande demande;
	
	public Message() {
		super();
	}
	
	public Message(String contenu, Boolean donneur, Demande demande) {
		super();
		this.contenu = contenu;
		this.donneur = donneur;
		this.demande = demande;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Boolean getDonneur() {
		return donneur;
	}

	public void setDonneur(Boolean donneur) {
		this.donneur = donneur;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [id=");
		builder.append(id);
		builder.append(", contenu=");
		builder.append(contenu);
		builder.append(", donneur=");
		builder.append(donneur);
		builder.append(", demande=");
		builder.append(demande);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
