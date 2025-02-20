package controller.restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bll.RestaurantBLL;
import bo.Restaurant;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL restaurantBLL = new RestaurantBLL();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		Restaurant restaurant = restaurantBLL.selectById(id);
		request.setAttribute("restaurant", restaurant);
		
        if (request.getSession().getAttribute("messageSent") != null) {
            request.setAttribute("messageSent", true);
            request.getSession().removeAttribute("messageSent");
        }
		
    	request.getRequestDispatcher("/WEB-INF/jsp/contact.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String utilisateur = request.getParameter("utilisateur");
        String message = request.getParameter("message");
        String idRestaurant = request.getParameter("idRestaurant");
        
        System.out.println("Message reçu de " + utilisateur);
        System.out.println("Message: " + message);
        System.out.println("Pour le restaurant ID: " + idRestaurant);
        
        boolean messageEnvoye = true;
        
        if (messageEnvoye) {
            request.getSession().setAttribute("messageSent", true);
        }
        
        response.sendRedirect("contact?id=" + idRestaurant);
	}
}
