package sopra.ShareYourFood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.ShareYourFood.model.Lot;

public interface ILotRepository extends JpaRepository<Lot, Long> {
	
	@Query("select l from Lot l where l.statut <> sopra.ShareYourFood.model.Statut.DONNE and l.don.entite.id = :idEntite")
	List<Lot> findAllNonDonneByEntiteById(@Param("idEntite") Long idEntite);
	
	@Query("select l from Lot l where l.statut = sopra.ShareYourFood.model.Statut.DONNE and l.don.entite.id = :idEntite")
	List<Lot> findAllDonneByEntiteById(@Param("idEntite") Long idEntite);

//	@Query("select d.lot from Don d where d.entite.id=:idEntite")
//	List<Lot> findAllByDemande(@Param("idEntite") Long idEntite);
}
