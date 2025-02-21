package controller.utilisateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import bll.ReservationBLL;
import bo.Reservation;
import bo.Restaurant;
import bo.Utilisateur;

/**
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/profil")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ReservationBLL reservationBLL = new ReservationBLL();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur clientSession = (Utilisateur) request.getSession().getAttribute("utilisateur");
		
		List<Reservation> reservations = reservationBLL.selectByUtilisateur(clientSession.getId());
		request.setAttribute("listeReservations", reservations);
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp").forward(request, response);
	}

}
