package controller.restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import bll.RestaurantBLL;
import bo.Restaurant;

/**
 * Servlet implementation class ListerRestaurantsServlet
 */
@WebServlet("/lister-restaurants")
public class ListerRestaurantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RestaurantBLL restaurantBLL = new RestaurantBLL();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Restaurant> restaurants = restaurantBLL.select();
		request.setAttribute("listeRestaurants", restaurants);
		
		request.getRequestDispatcher("/WEB-INF/jsp/liste_restaurants.jsp").forward(request, response);
		
	}

	

}
