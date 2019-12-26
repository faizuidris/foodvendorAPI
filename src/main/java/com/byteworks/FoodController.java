package com.byteworks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
	
	@Autowired
	FoodService foodService;
	
	@RequestMapping({"/"})
	public String welcome() {
		return "Welcome to Byteworks Food Vendor. " +
				"Visit /foodItems to see the list of available food";
	}
	
	@RequestMapping("/foodItems")
	public List<Food> getFoodItems() {
		return foodService.getFoodItemsList();
	}
	
	@RequestMapping("/foodItem/{id}")
	public Food getFoodItem(@PathVariable String id) {
		return foodService.getFoodItem(id);
	}

}
