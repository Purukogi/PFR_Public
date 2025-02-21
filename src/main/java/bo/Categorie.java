package bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name = "categories")
public class Categorie {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String libelle;

	public Categorie(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public Categorie(String libelle) {
		this.libelle = libelle;
	}

	public Categorie() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
