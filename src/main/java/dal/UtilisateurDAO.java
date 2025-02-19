package dal;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;

import bo.Utilisateur;

public class UtilisateurDAO {

	private EntityManagerFactory emf;

	public UtilisateurDAO() {
		emf = Persistence.createEntityManagerFactory("SQLServer");
	}
	
	
	public void insert(Utilisateur client) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		try {
			em.persist(client);
			em.getTransaction().commit();
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
	
}
