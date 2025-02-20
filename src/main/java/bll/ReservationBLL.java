package bll;

import java.time.LocalDateTime;
import java.util.List;

import bo.Reservation;
import bo.Restaurant;
import bo.Utilisateur;
import dal.ReservationDAO;
import exceptions.ReservationException;

public class ReservationBLL {
	private ReservationDAO dao;
	
	public ReservationBLL() {
		dao = new ReservationDAO();
	}
	
	public List<Reservation> select() {
		return dao.select();
	}
	
	public List<Reservation> selectByUtilisateur(int idUtilisateur) {
		return dao.selectByUtilisateur(idUtilisateur);
	}
	
	public void insert(Restaurant restaurant, Utilisateur utilisateur, LocalDateTime horaireReservation, int nbPersonne,
			String statut) throws ReservationException {
		Reservation reservation = new Reservation();
		reservation.setRestaurant(restaurant);
		reservation.setUtilisateur(utilisateur);
		reservation.setHoraireReservation(horaireReservation);
		reservation.setNbPersonne(nbPersonne);
		reservation.setStatut("En attente");
		
		checkReservation(reservation);

		dao.insert(reservation);
		
	}

	private void checkReservation(Reservation reservation) throws ReservationException{

	}
}
