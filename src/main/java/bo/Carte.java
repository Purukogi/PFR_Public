package bo;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity @Table(name = "cartes")
public class Carte {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String description;
	
	@ManyToMany
	@JoinTable(
			name = "asso_cartes_plats",
			joinColumns = {@JoinColumn(name = "id_carte")},
			inverseJoinColumns = {@JoinColumn(name = "id_plat")}
	)
	private List<Plat> plats;
	
    @Transient  
    private Map<Categorie, List<Plat>> platsGroupedByCategory;

	public Carte(int id, String nom, String description, List<Plat> plats) {
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.plats = plats;
	}

	public Carte(String nom, String description, List<Plat> plats) {
		this.nom = nom;
		this.description = description;
		this.plats = plats;
	}

	public Carte() {}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Plat> getPlats() {
		return plats;
	}

	public void setPlats(List<Plat> plats) {
		this.plats = plats;
	}

	
    public Map<Categorie, List<Plat>> getPlatsGroupedByCategory() {
        return platsGroupedByCategory;
    }

    public void setPlatsGroupedByCategory(Map<Categorie, List<Plat>> platsGroupedByCategory) {
        this.platsGroupedByCategory = platsGroupedByCategory;
    }
	
	
	
}
