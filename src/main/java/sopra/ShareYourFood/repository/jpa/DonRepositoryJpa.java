package sopra.ShareYourFood.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.model.Don;
import sopra.ShareYourFood.repository.IDonRepository;


public class DonRepositoryJpa implements IDonRepository {

	@Override
	public List<Don> findAll() {
		
		List<Don> dons = new ArrayList<Don>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Don> query = em.createQuery("select d from Don d", Don.class);

			dons = query.getResultList();

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

		return dons;		
	}

	@Override
	public Don findById(Long id) {
		Don don = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			don = em.find(Don.class, id);

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

		return don;
	}
	
	@Override
	public List<Don> findAllJeRecois(String ville) {
		
		List<Don> dons = new ArrayList<Don>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<Don> query = em.createQuery("select d from Don d where d.adresse.ville = :ville", Don.class);
			
			query.setParameter("ville", ville);
//			query.setParameter("entite", entite);

			dons = query.getResultList();

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

		return dons;	
		
	}
	
}
