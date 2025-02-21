package dal;

import java.util.List;

import bo.Reservation;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TransactionRequiredException;

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
