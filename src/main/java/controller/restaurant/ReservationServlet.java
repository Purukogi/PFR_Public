package controller.restaurant;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import bll.ReservationBLL;
import bll.RestaurantBLL;
import bo.Restaurant;
import bo.Utilisateur;
import exceptions.ReservationException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
        request.getRequestDispatcher("/WEB-INF/jsp/reservation.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

        if (utilisateur == null) {
            response.sendRedirect("connexion.jsp");
            return;
        }

        try {
            int idRestaurant = Integer.parseInt(request.getParameter("idRestaurant"));
            LocalDate date = LocalDate.parse(request.getParameter("date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String horaire = request.getParameter("horaire");
            int nombrePersonnes = Integer.parseInt(request.getParameter("nombre"));

            // Conversion en LocalDateTime
            LocalDateTime dateTimeReservation = LocalDateTime.parse(date + " " + horaire, FORMATTER);

            Restaurant restaurant = restaurantBLL.selectById(idRestaurant);

            // Insertion de la réservation
            bll.insert(restaurant, utilisateur, dateTimeReservation, nombrePersonnes, "en attente");

            response.sendRedirect("accueil");
        } catch (NumberFormatException | DateTimeParseException | ReservationException e) {
            request.setAttribute("erreur", "Données invalides. Veuillez réessayer.");
            request.getRequestDispatcher("/WEB-INF/jsp/reservation.jsp").forward(request, response);
        }
    }
}
