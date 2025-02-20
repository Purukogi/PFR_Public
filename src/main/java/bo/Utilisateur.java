package bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="utilisateurs")

@NamedQueries({
	@NamedQuery (name = "selectByToken",
		 	 	 query="SELECT u FROM Utilisateur u WHERE u.token= :token"),
	@NamedQuery (name = "selectByLogin",
			 	 query="SELECT u FROM Utilisateur u WHERE u.login= :login"),
	@NamedQuery (name = "selectByEmail",
	 			 query="SELECT u FROM Utilisateur u WHERE u.email= :email"),
	@NamedQuery (name = "selectByEmailEtMdp",
				 query="SELECT u FROM Utilisateur u WHERE u.email= :email AND u.mdp= :mdp"),
	@NamedQuery (name = "selectByLoginEtMdp",
	 			 query="SELECT u FROM Utilisateur u WHERE u.login= :login AND u.mdp= :mdp")
})

public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String prenom;
	private String login;
	private String telephone;
	private String email;
	private byte[] mdp;
	private byte[] salt;
	private String token;
	
	@ManyToOne
	@JoinColumn(name = "id_role")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "id_restaurant")
	private Restaurant restaurant;
	
	public Utilisateur() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getMdp() {
		return mdp;
	}

	public void setMdp(byte[] mdp) {
		this.mdp = mdp;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", telephone="
				+ telephone + ", email=" + email + ", role=" + role + "]";
	}	
	
}
