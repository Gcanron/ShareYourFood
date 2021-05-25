package sopra.ShareYourFood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.ShareYourFood.model.Lot;

public interface ILotRepository extends JpaRepository<Lot, Long> {

}
