package sopra.ShareYourFood.repository;

import java.util.List;

import sopra.ShareYourFood.model.Don;
import sopra.ShareYourFood.model.Entite;

public interface IDonRepository extends JpaRepository<Don, Long> {

	//List<Don> findAllJeRecois(String ville);

}
