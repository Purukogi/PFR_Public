package bll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import bo.Categorie;
import bo.Plat;
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
	
	public Restaurant selectEtTrierPlatsParCategorie(int id) {

	    Restaurant restaurant = dao.selectById(id);
	    
	    if (restaurant != null && restaurant.getCarte() != null) {
	    	Map<Categorie, List<Plat>> platsGroupedByCategory = regrouperEtTrierPlatsParCategorie(restaurant.getCarte().getPlats());
	        Map<Categorie, List<Plat>> sortedPlatsGroupedByCategory = new TreeMap<>(Comparator.comparingInt(categorie -> categorie.getId()));
	        sortedPlatsGroupedByCategory.putAll(platsGroupedByCategory);
	        restaurant.getCarte().setPlatsGroupedByCategory(sortedPlatsGroupedByCategory);
	    }
	    return restaurant;
	}
    
    private Map<Categorie, List<Plat>> regrouperEtTrierPlatsParCategorie(List<Plat> plats) {
        Map<Categorie, List<Plat>> platsGroupedByCategory = new HashMap<>();
  
        for (Plat plat : plats) {
            platsGroupedByCategory
                .computeIfAbsent(plat.getCategorie(), k -> new ArrayList<>())
                .add(plat);
        }
        
        for (List<Plat> platList : platsGroupedByCategory.values()) {
            platList.sort(Comparator.comparing(Plat::getNom)); 
        }
        return platsGroupedByCategory;
    }
}
