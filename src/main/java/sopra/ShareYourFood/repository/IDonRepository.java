package sopra.ShareYourFood.repository;

import java.util.List;

import sopra.ShareYourFood.model.Don;

public interface IDonRepository extends IRepository<Don, Long> {

	List<Don> findAllJeRecois(String ville);

}
