package sopra.ShareYourFood.repository.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.ShareYourFood.Application;
import sopra.ShareYourFood.model.Lot;
import sopra.ShareYourFood.model.ProduitLot;
import sopra.ShareYourFood.repository.IProduitLotRepository;

public class ProduitLotRepositoryJpa implements IProduitLotRepository{

	@Override
	public List<ProduitLot> findAll() {
		List<ProduitLot> produitlots = new ArrayList<ProduitLot>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<ProduitLot> query = em.createQuery("select e from Produit_lot e ", ProduitLot.class);

			produitlots = query.getResultList();

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

		return produitlots;
	}

	@Override
	public ProduitLot findById(Long id) {
		ProduitLot produitLot = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			produitLot = em.find(ProduitLot.class, id);

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

		return produitLot;
	
	}
	}


