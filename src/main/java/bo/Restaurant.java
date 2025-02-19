package bo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity @Table(name = "restaurants")
public class Restaurant {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String adresse;
	private String url_image;
	
	@ManyToOne
	@JoinColumn(name = "id_carte")
	private Carte carte;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_restaurant")
	private List<TableRestaurant> tables;
	
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "id_restaurant")
	private List<Horaire> horaires;

	public Restaurant(int id, String nom, String adresse, String url_image, Carte carte, List<TableRestaurant> tables,
			List<Horaire> horaires) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.url_image = url_image;
		this.carte = carte;
		this.tables = tables;
		this.horaires = horaires;
	}

	public Restaurant(String nom, String adresse, String url_image, Carte carte, List<TableRestaurant> tables,
			List<Horaire> horaires) {
		this.nom = nom;
		this.adresse = adresse;
		this.url_image = url_image;
		this.carte = carte;
		this.tables = tables;
		this.horaires = horaires;
	}

	public Restaurant() {}

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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public List<TableRestaurant> getTables() {
		return tables;
	}

	public void setTables(List<TableRestaurant> tables) {
		this.tables = tables;
	}

	public List<Horaire> getHoraires() {
		return horaires;
	}

	public void setHoraires(List<Horaire> horaires) {
		this.horaires = horaires;
	}
	
	
}
