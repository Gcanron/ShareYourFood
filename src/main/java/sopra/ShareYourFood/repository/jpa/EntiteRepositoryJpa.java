package sopra.ShareYourFood.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.model.Entite;
import sopra.ShareYourFood.repository.IEntiteRepository;

public class EntiteRepositoryJpa implements IEntiteRepository {

	@Override
	public List<Entite> findAll() {
		List<Entite> entites = new ArrayList<Entite>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Entite> query = em.createQuery("select e from Entite e", Entite.class);

			entites = query.getResultList();

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

		return entites;		
	}

	@Override
	public Entite findById(Long id) {
		Entite entite = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			entite = em.find(Entite.class, id);

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

		return entite;
	}

	@Override
	public Entite findByNom(String nom) {
		Entite entite = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			entite = em.find(Entite.class, nom);

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

		return entite;
	}

}
