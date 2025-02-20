package dal;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;

import bo.Reservation;

public class ReservationDAO {
	private EntityManagerFactory emf;
	
	public ReservationDAO() {
		emf = Persistence.createEntityManagerFactory("SQLServer");
	}
	
	public List<Reservation> select() {
		EntityManager em = emf.createEntityManager();
		List<Reservation> resultat = em.createQuery("from Reservation", Reservation.class).getResultList();
		em.close();
		return resultat;
	}
	
	public List<Reservation> selectByUtilisateur(int idUtilisateur) {
	    EntityManager em = emf.createEntityManager();
	    List<Reservation> reservations = null;

	    try {
	        reservations = em.createNamedQuery("selectByUtilisateur", Reservation.class)
	                         .setParameter("idUtilisateur", idUtilisateur)
	                         .getResultList();
	    } finally {
	        em.close();
	    }

	    return reservations;
	}
	
	public void insert(Reservation reservation) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		try {
			em.persist(reservation);
			em.getTransaction().commit();
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
}
