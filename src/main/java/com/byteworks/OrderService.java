package com.byteworks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	private List<Order> ordersList = new ArrayList<>();
	
	public List<Order> getOrdersList() {
		return ordersList;
	}
	
	public List<Order> getOrdersByFood(String foodName) {
		List<Order> temp = new ArrayList<>();
		
		for(Order order : ordersList) {
			//if(order.getFood().getName().equals(foodName)) {
				temp.add(order);
			//}
		}
	
		return temp;
	}

}
