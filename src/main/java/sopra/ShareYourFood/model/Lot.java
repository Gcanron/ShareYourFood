package sopra.ShareYourFood.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Lot")
public class Lot {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private Long volume;
	private Date dtPeremptionLot;
	private String photo;
	private Statut statut;
	
}
