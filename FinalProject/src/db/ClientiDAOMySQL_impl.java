package db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.DAO;
import model.Clienti;

public class ClientiDAOMySQL_impl implements DAO<Clienti> {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinalProject");
	private EntityManager em = emf.createEntityManager();

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FinalProject");
		EntityManager em = emf.createEntityManager();
		return em;
	}

//	public ClientiDAOMySQL_impl() {
//		if (entityManager == null) {
//			EntityManagerFactory factory = Persistence.createEntityManagerFactory("FinalProject");
//			entityManager = factory.createEntityManager();
//		}
//	}

	@Override
	public void add(Clienti obj) {
		System.out.println("adaugare");
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	@Override
	public boolean update(Clienti obj) {
		System.out.println("update clienti");
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		return false;
	}

	@Override
	public void delete(Clienti obj) {
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
	}

	@Override
	public Clienti findById(int id) {
		return em.find(Clienti.class, id);
	}

	@Override
	public List<Clienti> getAll() {
		return this.getEntityManager().createQuery("SELECT c FROM model.Clienti c", Clienti.class).getResultList();
	}
}
