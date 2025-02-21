package bll;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Pattern;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import bo.Role;
import bo.Utilisateur;
import dal.UtilisateurDAO;
import exceptions.UtilisateurException;

public class UtilisateurBLL {
	
	private UtilisateurDAO dao;
	
	private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe
	
	public UtilisateurBLL() {
		dao = new UtilisateurDAO();
	}
	
	public Utilisateur selectById(int id) {
		return dao.selectById(id);
	}
	
	public Utilisateur selectByToken(String token) {
		return dao.selectByToken(token);
	}
	
	public Utilisateur selectByLogin(String login) {
		return dao.selectByLogin(login);
	}
	
	public Utilisateur selectByEmail(String email) {
		return dao.selectByEmail(email);
	}
	
	public Utilisateur selectByEmailEtMdp(String email, String mdp) {
		
		Utilisateur client = selectByEmail(email);
		
		if (client != null) {
			byte[] hashedMdp = hashMdp(mdp, client.getSalt());
			if (Arrays.equals(hashedMdp, client.getMdp())) {
				return client;
			} else {
				return null;
			}
		}
		
		return client;
	}
	
	public Utilisateur selectByLoginEtMdp(String login, String mdp) {
		
		Utilisateur client = selectByLogin(login);
		
		if (client != null) {
			byte[] hashedMdp = hashMdp(mdp, client.getSalt());
			if (Arrays.equals(hashedMdp, client.getMdp())) {
				return client;
			} else {
				return null;
			}
		}
		
		return client;
	}
	

	public void insert(String nom, String prenom, String identifiant, String mdp, String telephone, String email ) throws UtilisateurException {

				
		Utilisateur client = new Utilisateur();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setLogin(identifiant);
		client.setTelephone(telephone);
		client.setEmail(email);
		Role role = new Role("CLI", "Client");
		client.setRole(role);
		
		checkUtilisateur(client);
		
		generateSalt(client);
		client.setMdp(hashMdp(mdp, client.getSalt()));
		
		dao.insert(client);
		
	}
	
	public void delete(Utilisateur client) {
		dao.delete(client);
	}
	
	public void update(Utilisateur client) throws UtilisateurException {
		checkUtilisateur(client);
		
		dao.update(client);
	}
	
	private void generateSalt(Utilisateur client) {
		
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		client.setSalt(salt);
	}
	
	public byte[] hashMdp(String mdp, byte[] salt) {
		
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
	

	public String generateToken(Utilisateur client) {
		byte[] randomBytes = new byte[24];
	    secureRandom.nextBytes(randomBytes);
	    String token = base64Encoder.encodeToString(randomBytes);
	    client.setToken(token);
	    dao.update(client);
		return token;
	}

	public void checkUtilisateur(Utilisateur client) throws UtilisateurException {
		
		UtilisateurException exception = new UtilisateurException();
		
		if (client.getNom().isBlank()) {
			exception.addMessage("Le nom ne peut pas être laissé vide !");
		}
		
		if (client.getPrenom().isBlank()) {
			exception.addMessage("Le prénom ne peut pas être laissé vide !");
		}
		
		if (client.getEmail().isBlank()) {
			exception.addMessage("L'e-mail ne peut pas être laissé vide !");
		}
		
		if (client.getNom().length() > 30) {
			exception.addMessage("Le nom ne peut pas faire plus de 30 caractères !");
		}
		
		if (client.getPrenom().length() > 30) {
			exception.addMessage("Le prénom ne peut pas faire plus de 30 caractères !");
		}
		
		if (client.getLogin().length() > 30) {
			exception.addMessage("L'identifiant ne peut pas faire plus de 30 caractères !");
		}
		
		if (client.getEmail().length() > 60) {
			exception.addMessage("L'e-mail ne peut pas faire plus de 60 caractères !");
		}
		
		if(!checkEmail(client.getEmail())) {
			exception.addMessage("L'adresse e-mail n'est pas valide !");
		}
		
		if (client.getTelephone().length() > 20) {
			exception.addMessage("Le numéro de téléphone ne peut pas faire plus de 20 caractères !");
		}
		
		if (exception.getMessages().size() > 0) {
			throw exception;
		}
		
	}
	
	public boolean checkEmail(String email) {
		//^[A-Za-z0-9_-] begins with a block of any letter, number _ or -
		//+(\\.[A-Za-z0-9_-]+)* add any number of blocks ".String" (where String contains any letter, number, _ or -)
		//[^-] can't start after @ with -
		//[A-Za-z0-9-] first block is any letter, number or -
		//+(\\.[A-Za-z0-9-]+)* then we add any number of blocks ".String" (where String contains any letter, number or -)
		//(\\.[A-Za-z]{2,})$ then we end with a bloc ".String" (where String contains any letter and is at least 2 characters long)
		return Pattern.compile("^[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
			      .matcher(email)
			      .matches();
	}

}
