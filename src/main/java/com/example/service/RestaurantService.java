package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.domain.Restaurant;
import com.example.repository.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
	public RestaurantRepository restaurantRepository;
	
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
		
		
        return restaurantRepository.findById(rest_id);
    }
	
	 public List<Restaurant> cancelRegistration(int rest_id) {
	        restaurantRepository.deleteById(rest_id);
	        List<Restaurant> restaurants = new ArrayList<>();
			restaurantRepository.findAll().forEach(restaurants :: add);
			return restaurants;
	    }
 
}
