package bll;

import java.time.LocalDateTime;
import java.util.List;

import bo.Reservation;
import bo.Restaurant;
import bo.TableRestaurant;
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
	
	public void insert(Restaurant restaurant, Utilisateur utilisateur, TableRestaurant table, LocalDateTime horaireReservation, int nbPersonne,
			String statut) throws ReservationException {
		Reservation reservation = new Reservation();
		reservation.setRestaurant(restaurant);
		reservation.setUtilisateur(utilisateur);
		reservation.setTable(table);
		reservation.setHoraireReservation(horaireReservation);
		reservation.setNbPersonne(nbPersonne);
		reservation.setStatut("En attente");
		
		checkReservation(reservation);

		dao.insert(reservation);
		
	}

	private void checkReservation(Reservation reservation) throws ReservationException{

		ReservationException exception = new ReservationException();
		
		if(reservation.getHoraireReservation().isBefore(LocalDateTime.now())) {
			exception.addMessage("Vous ne pouvez pas réserver pour une date dans le passé");
		}
		
		if(reservation.getNbPersonne() <= 0) {
			exception.addMessage("Vous devez réserver pour au moins une personne");
		}
		
		if(reservation.getNbPersonne() > 8) {
			exception.addMessage("Pour toute réservation de plus de 8 personnes, contactez le restaurant par téléphone ou via le formulaire dédié");
		}
		
		if (exception.getMessages().size() > 0) {
			throw exception;
		}
	}
}
