package bll;

import java.util.List;

import bo.Restaurant;
import dal.RestaurantDAO;

public class RestaurantBLL {
	private RestaurantDAO dao;
	
	public RestaurantBLL() {
		dao = new RestaurantDAO();
	}
	
	public List<Restaurant> select() {
		return dao.select();
	}
	
	public Restaurant selectById(int id) {
		return dao.selectById(id);
	}
}
