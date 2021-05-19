package sopra.ShareYourFood.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.model.Message;
import sopra.ShareYourFood.repository.IMessageRepository;

public class MessageRepositoryJpa implements IMessageRepository {

	@Override
	public List<Message> findAll() {
		List<Message> messages = new ArrayList<Message>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Message> query = em.createQuery("select m from Message m", Message.class);

			messages = query.getResultList();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return messages;
	}

	@Override
	public Message findById(Long id) {
		Message message = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			message = em.find(Message.class, id);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

		} finally {
			if (em != null) {
				em.close();
			}
		}

		return message;
	}

}
