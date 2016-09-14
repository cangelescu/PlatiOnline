package db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Interfaces.DAO;
import model.Facturi;


public class FacturiDAOMySQL_Impl implements DAO<Facturi> {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinalProject");
	private EntityManager em = emf.createEntityManager();

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinalProject");
		EntityManager em = emf.createEntityManager();
		return em;
	}

	@Override
	public void add(Facturi obj) {
		System.out.println("adaugare facturi");
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	@Override
	public boolean update(Facturi obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		return false;
	}

	@Override
	public void delete(Facturi obj) {
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
	}

	@Override
	public Facturi findById(int id) {
		return em.find(Facturi.class, id);
	}

	@Override
	public List<Facturi> getAll() {
		return this.getEntityManager().createQuery("SELECT f FROM model.Facturi f", Facturi.class).getResultList();
	}
}
