package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import bo.Utilisateur;

public class UtilisateurDAO {

	private EntityManagerFactory emf;

	public UtilisateurDAO() {
		emf = Persistence.createEntityManagerFactory("SQLServer");
	}
	
	public Utilisateur selectByEmailEtMdp(String email, String mdp) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Utilisateur> query = em.createNamedQuery("selectByEmailEtMdp", Utilisateur.class);
		
		return query.setParameter("email", email)
					.setParameter("mdp", mdp)
					.getSingleResult();
	}
	
	public Utilisateur selectByLoginEtMdp(String login, String mdp) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Utilisateur> query = em.createNamedQuery("selectByLoginEtMdp", Utilisateur.class);
		
		return query.setParameter("email", login)
					.setParameter("mdp", mdp)
					.getSingleResult();
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
	
	public void updateToken(Utilisateur client) {
		
		EntityManager em = emf.createEntityManager();
		TypedQuery<Utilisateur> query = em.createNamedQuery("updateToken", Utilisateur.class);
		
		query.setParameter("token", client.getToken())
			 .setParameter("id", client.getId())
			 .getSingleResult();
		
		query.executeUpdate();
		
	}
	
}
