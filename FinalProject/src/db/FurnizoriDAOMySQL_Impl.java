package db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Interfaces.DAO;
import model.Furnizori;

public class FurnizoriDAOMySQL_Impl implements DAO<Furnizori> {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinalProject");
	private EntityManager em = emf.createEntityManager();

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinalProject");
		EntityManager em = emf.createEntityManager();
		return em;
	}

	@Override
	public void add(Furnizori obj) {
		// TODO Auto-generated method stub
		// nu am nevoie de adaugare furnizori
	}

	@Override
	public boolean update(Furnizori obj) {
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		return false;
	}

	@Override
	public void delete(Furnizori obj) {
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
	}

	@Override
	public Furnizori findById(int id) {
		return em.find(Furnizori.class, id);
	}

	@Override
	public List<Furnizori> getAll() {
		return this.getEntityManager().createQuery("SELECT f FROM model.Furnizori f", Furnizori.class).getResultList();
	}
}
