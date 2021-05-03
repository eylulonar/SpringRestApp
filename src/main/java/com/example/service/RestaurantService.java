package com.example.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Menu;
import com.example.domain.MenuItem;
import com.example.domain.Restaurant;
import com.example.repository.MenuRepository;
import com.example.repository.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
	public RestaurantRepository restaurantRepository;
	@Autowired
	public MenuRepository menuRepository;
	
	public List<Restaurant> getAllRestaurants(){
	 List<Restaurant> restaurants = new ArrayList<>();
		restaurantRepository.findAll().forEach(restaurants :: add);
		return restaurants;

	}
	
	public String addRestaurant(Restaurant restaurant) {
	restaurantRepository.save(restaurant);
    return "Hi " + restaurant.getRest_name() + " your Registration process successfully completed";
	
	}
	
	public Optional<Restaurant> findRestaurant(int rest_id) {
		
		Optional<Restaurant> r = restaurantRepository.findById(rest_id);
		List<MenuItem> ms =r.get().getRest_menu().getMenuitem();
		for (Iterator iterator = ms.iterator(); iterator.hasNext();) {
			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.println(menuItem.getItemName());
		}
		
        return restaurantRepository.findById(rest_id);
        
        
    }
	
	 public List<Restaurant> cancelRegistration(int rest_id) {
	        restaurantRepository.deleteById(rest_id);
	        List<Restaurant> restaurants = new ArrayList<>();
			restaurantRepository.findAll().forEach(restaurants :: add);
			return restaurants;
	    }

	public List<Restaurant> populatedata() {
		for (int i=1; i<=100; i++) {
		Menu m =new Menu(0, "meal for"+"testrest" + i);	
		Restaurant	r= new Restaurant(0, "testrest" + i, "adress"+i, "phone" +i, "mail"+i, "workhours"+i, m);
		menuRepository.save(m);
		restaurantRepository.save(r);
		
		}
		return null;
	}
 
}
