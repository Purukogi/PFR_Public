package bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "tables_restaurant")
public class TableRestaurant {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int nb_places;
	private int numero_table;
	
	public TableRestaurant(int id, int nb_places, int numero_table) {
		this.id = id;
		this.nb_places = nb_places;
		this.numero_table = numero_table;
	}

	public TableRestaurant(int nb_places, int numero_table) {
		this.nb_places = nb_places;
		this.numero_table = numero_table;
	}

	public TableRestaurant() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNb_places() {
		return nb_places;
	}

	public void setNb_places(int nb_places) {
		this.nb_places = nb_places;
	}

	public int getNumero_table() {
		return numero_table;
	}

	public void setNumero_table(int numero_table) {
		this.numero_table = numero_table;
	}
	
	
}
