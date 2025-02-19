package bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name = "plats")
public class Plat {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private float prix;
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "id_categorie" )
	private Categorie categorie;

	public Plat(int id, String nom, float prix, String description, Categorie categorie) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.categorie = categorie;
	}

	public Plat(String nom, float prix, String description, Categorie categorie) {
		this.nom = nom;
		this.prix = prix;
		this.description = description;
		this.categorie = categorie;
	}

	public Plat() {}

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

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
}
