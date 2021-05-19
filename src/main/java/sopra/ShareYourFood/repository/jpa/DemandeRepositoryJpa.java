package sopra.ShareYourFood.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.model.Demande;
import sopra.ShareYourFood.repository.IDemandeRepository;



public class DemandeRepositoryJpa implements IDemandeRepository {

	@Override
	public List<Demande> findAll() {
		List<Demande> demandes = new ArrayList<Demande>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Demande> query = em.createQuery("select de from Demande de", Demande.class);

			demandes = query.getResultList();

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

		return demandes;
	}

	@Override
	public Demande findById(Long id) {
		Demande demande = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			demande = em.find(Demande.class, id);

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

		return demande;
	}

}
