package controller.restaurant;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import bll.ReservationBLL;
import bll.RestaurantBLL;
import bo.Restaurant;
import bo.TableRestaurant;
import bo.Utilisateur;
import exceptions.ReservationException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReservationBLL bll = new ReservationBLL();
    private RestaurantBLL restaurantBLL = new RestaurantBLL();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
    	
		Restaurant restaurant = restaurantBLL.selectById(id);
		request.setAttribute("restaurant", restaurant);
		
	    if (request.getSession().getAttribute("reservationSuccess") != null) {
	    	request.setAttribute("reservationSuccess", true);
	    	request.getSession().removeAttribute("reservationSuccess");
	    }
		
    	request.getRequestDispatcher("/WEB-INF/jsp/reservation.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");
        int idRestaurant = Integer.valueOf(request.getParameter("idRestaurant"));
        LocalDate date = LocalDate.parse(request.getParameter("date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String horaire = request.getParameter("horaire");
        int nombrePersonnes = Integer.parseInt(request.getParameter("nombre"));

        // Conversion en LocalDateTime
        LocalDateTime dateTimeReservation = LocalDateTime.parse(date + " " + horaire, FORMATTER);

		Restaurant restaurant = restaurantBLL.selectById(idRestaurant);
        TableRestaurant table = null;
        
        
        
        try {
            bll.insert(restaurant, utilisateur, table, dateTimeReservation, nombrePersonnes, "en attente");
        	
            boolean reservationEnvoyee = true;
            
            if (reservationEnvoyee) {
            	
            	request.getSession().setAttribute("reservationSuccess", true);
            }
            
            response.sendRedirect("reservation?id=" + idRestaurant);
        } catch (ReservationException e) {
            request.setAttribute("erreurs_reservation", e.getMessages());
            request.setAttribute("restaurant", restaurant);
            request.getRequestDispatcher("/WEB-INF/jsp/reservation.jsp").forward(request, response);
        }
    }
}
