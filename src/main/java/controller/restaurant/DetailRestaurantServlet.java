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
 * Servlet implementation class DetailRestaurantServlet
 */
@WebServlet("/detail-restaurant")
public class DetailRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RestaurantBLL restaurantBLL = new RestaurantBLL();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		
		Restaurant restaurant = restaurantBLL.selectEtTrierPlatsParCategorie(id);
		request.setAttribute("restaurant", restaurant);
		request.getRequestDispatcher("/WEB-INF/jsp/detail_restaurant.jsp").forward(request, response);
	}

}
