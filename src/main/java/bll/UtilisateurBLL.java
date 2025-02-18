package bll;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.TypedQuery;

import bo.Role;
import bo.Utilisateur;
import dal.UtilisateurDAO;

public class UtilisateurBLL {
	
	private UtilisateurDAO dao;
	
	public UtilisateurBLL() {
		dao = new UtilisateurDAO();
	}
	
	public Utilisateur selectByEmailEtMdp(String email, String mdp) {
		//check if exists
		return dao.selectByEmailEtMdp(email, mdp);
	}
	
	public Utilisateur selectByLoginEtMdp(String login, String mdp) {
		//check if exists
		return dao.selectByEmailEtMdp(login, mdp);
	}
	
	public void insert(String nom, String prenom, String identifiant, String mdp, String telephone, String email ) {
				
		Utilisateur client = new Utilisateur();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setLogin(identifiant);
		client.setTelephone(telephone);
		client.setEmail(email);
		Role role = new Role("CLI", "Client");
		client.setRole(role);
		
		//checkUtilisateur(client);
		
		generateSalt(client);
		client.setMdp(hashMdp(mdp, client.getSalt()));
		
		dao.insert(client);
		
	}
	
	private void generateSalt(Utilisateur client) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		client.setSalt(salt);
	}
	
	private byte[] hashMdp(String mdp, byte[] salt) {
		KeySpec spec = new PBEKeySpec(mdp.toCharArray(), salt, 65536, 128);
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] hash = factory.generateSecret(spec).getEncoded();
			return hash;
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
