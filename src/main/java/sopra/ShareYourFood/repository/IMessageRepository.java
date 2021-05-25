package sopra.ShareYourFood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.ShareYourFood.model.Message;

public interface IMessageRepository extends JpaRepository <Message, Long>{

}
