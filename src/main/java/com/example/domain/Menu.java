package com.example.domain;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity

public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int menuId;
	private String mealName;
	
	@OneToOne(mappedBy = "rest_menu")
	 private Restaurant restaurant;
	
	@OneToMany(mappedBy="menu")
	private List<MenuItem> menuitem = new ArrayList<> ();

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<MenuItem> getMenuitem() {
		return menuitem;
	}

	public void setMenuitem(List<MenuItem> menuitem) {
		this.menuitem = menuitem;
	}

	public Menu(int menuId, String mealName) {
		super();
		this.menuId = menuId;
		this.mealName = mealName;
	}
	
	public Menu  () {
		
		
	}
	
}
