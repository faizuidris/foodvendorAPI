package com.byteworks;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FoodService {
	private List<Food> foodItemsList = Arrays.asList(
		new Food("1", 
				"Bacon Ranch Salad with Buttermilk Crispy Chicken", 
				470, 
				"Our Buttermilk Crispy Chicken made with all white "
				+ "meat chicken fillet sits atop crisp chopped "
				+ "romaine, baby spinach, baby kale, red leaf "
				+ "lettuce, ribbon-cut carrots and grape tomatoes. "
				+ "Add jack and cheddar cheeses, Applewood smoked "
				+ "bacon and Newman’s Own® Ranch Dressing for the "
				+ "finishing touch on a salad with crispy chicken "
				+ "full of fresh flavors"),
		
		new Food("2", 
				"Southwest Grilled Chicken Salad", 
				330, 
				"Artisan grilled chicken made with all white meat "
				+ "chicken fillet with no artificial preservatives, "
				+ "flavors or colors – grilled and seasoned to "
				+ "perfection with ingredients like salt, garlic "
				+ "powder and parsley. Layered with savory black "
				+ "beans, roasted corn and tomatoes, and poblano "
				+ "peppers. Sprinkled with cheddar and jack "
				+ "cheeses, chili-lime tortilla strips and cilantro. "
				+ "All atop crisp chopped romaine, baby spinach, "
				+ "baby kale, red leaf lettuce and ribbon cut "
				+ "carrots and served with Newman's Own® Southwest "
				+ "Dressing."),
		
		new Food("3", 
				"Double Bacon BBQ Burger", 
				920, 
				"Our Double Bacon BBQ Burger is part of an "
				+ "easy, delicious dinner and a great way to "
				+ "savor the season. It’s made with two ¼ lb* "
				+ "patties of 100% fresh beef** that are hot, "
				+ "deliciously juicy and cooked when you order, "
				+ "topped with Applewood smoked bacon, bourbon "
				+ "BBQ sauce and crispy fried onion strings, "
				+ "served on an artisan roll. Only available "
				+ "for a limited time.\n" + 
				""),
		
		new Food("4", "Food Item 4", 100, "Some description goes here"),
		new Food("5", "Food Item 5", 100, "Some description goes here"),
		new Food("6", "Food Item 6", 100, "Some description goes here"),
		new Food("7", "Food Item 7", 100, "Some description goes here"),
		new Food("8", "Food Item 8", 100, "Some description goes here"),
		new Food("9", "Food Item 9", 100, "Some description goes here"),
		new Food("10", "Food Item 10", 100, "Some description goes here")
	);

	public List<Food> getFoodItemsList() {
		return foodItemsList;
	}

	public Food getFoodItem(String id) {
		return foodItemsList.stream()
				.filter(t -> t.getId().equals(id))
				.findFirst()
				.get();
	}
	
	
}
