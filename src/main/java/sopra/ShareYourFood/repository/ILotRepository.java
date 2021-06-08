package sopra.ShareYourFood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.ShareYourFood.model.Lot;

public interface ILotRepository extends JpaRepository<Lot, Long> {

	@Query("select l from Lot l where l.don.destinataire == sopra.ShareYourFood.model.Destinataire.PARTICULIER")
	public List<Lot> findAllPourParticulier();
	
	@Query("select l from Lot l where l.don.destinataire == sopra.ShareYourFood.model.Destinataire.ASSOCIATION")
	public List<Lot> findAllPourAssociation();
	
	
	@Query("select distinct d.lot from Demande where d.lot.statut <> sopra.ShareYourFood.model.Statut.DONNE and (d.statutNotif == sopra.ShareYourFood.model.StatutNotif.ACCEPTER || d.statutNotif == sopra.ShareYourFood.model.StatutNotif.PAS_ENCORE_REPONDUE ) and d.entite.id = :id")
	public List<Lot> findAllNonDonneEtDemandeAccepterOuNonRepondue(@Param("id") Long id );
}
