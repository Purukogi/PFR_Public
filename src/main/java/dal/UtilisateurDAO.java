package dal;


import bo.Utilisateur;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TransactionRequiredException;
import jakarta.persistence.TypedQuery;

public class UtilisateurDAO {

	private EntityManagerFactory emf;

	public UtilisateurDAO() {
		emf = Persistence.createEntityManagerFactory("SQLServer");
	}
	
	public Utilisateur selectById(int id) {
		EntityManager em = emf.createEntityManager();
		Utilisateur resultat = em.find(Utilisateur.class, id);
		em.close();
		return resultat;
	}
	
	public Utilisateur selectByToken(String token) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Utilisateur> query = em.createNamedQuery("selectByToken", Utilisateur.class);
		
		try {
			query.setParameter("token", token);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Utilisateur selectByLogin(String login) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Utilisateur> query = em.createNamedQuery("selectByLogin", Utilisateur.class);
		
		try {
			query.setParameter("login", login);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
	public Utilisateur selectByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Utilisateur> query = em.createNamedQuery("selectByEmail", Utilisateur.class);
		
		try {
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
	public Utilisateur selectByEmailEtMdp(String email, String mdp) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Utilisateur> query = em.createNamedQuery("selectByEmailEtMdp", Utilisateur.class);
		
		return query.setParameter("email", email)
					.setParameter("mdp", mdp)
					.getSingleResult();
	}
	
	public Utilisateur selectByLoginEtMdp(String login, byte[] hashedMdp) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Utilisateur> query = em.createNamedQuery("selectByLoginEtMdp", Utilisateur.class);
		
		return query.setParameter("login", login)
					.setParameter("mdp", hashedMdp)
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
	
	public void update(Utilisateur client) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		try {
			em.merge(client);
			em.getTransaction().commit();
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
	
	public void delete(Utilisateur client) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		try {
			em.remove(em.merge(client));
			em.getTransaction().commit();
		} catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
	
}
