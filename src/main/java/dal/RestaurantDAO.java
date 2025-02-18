package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.Restaurant;

public class RestaurantDAO {
	private EntityManagerFactory emf;
	
	public RestaurantDAO() {
		emf = Persistence.createEntityManagerFactory("SQLServer");
	}
	
	public List<Restaurant> select() {
		EntityManager em = emf.createEntityManager();
		List<Restaurant> resultat = em.createQuery("from Restaurant", Restaurant.class).getResultList();
		em.close();
		return resultat;
	}
	
	public Restaurant selectById(int id) {
		EntityManager em = emf.createEntityManager();
		Restaurant resultat = em.find(Restaurant.class, id);
		em.close();
		return resultat;
	}
}
