package bo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity @Table(name = "reservations")

@NamedQuery(
	    name = "selectByUtilisateur",
	    query = "SELECT r FROM Reservation r WHERE r.utilisateur.id = :idUtilisateur"
	)
public class Reservation {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_restaurant")
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;
	
    @ManyToOne
    @JoinColumn(name = "id_table", nullable = true)
	private TableRestaurant table;

	@Column(name = "horaire_reservation")
	private LocalDateTime horaireReservation;
	
	@Column(name = "nombre_personnes")
	private int nbPersonne;
	private String statut;

	public Reservation() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public TableRestaurant getTable() {
		return table;
	}

	public void setTable(TableRestaurant table) {
		this.table = table;
	}
	
	public LocalDateTime getHoraireReservation() {
		return horaireReservation;
	}

	public void setHoraireReservation(LocalDateTime horaireReservation) {
		this.horaireReservation = horaireReservation;
	}

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
}
