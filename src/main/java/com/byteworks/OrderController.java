package com.byteworks;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/order")
	public Order getOrder(HttpServletRequest request) {
		MyUser user = (MyUser) request.getSession()
				.getAttribute("user");
		
		return user.getOrder();
		
	}
	
	@RequestMapping("/cart")
	public List<Food> getCart(HttpServletRequest request) {
		//foodService.getFoodItem(foodId);
		MyUser user = (MyUser) request.getSession()
				.getAttribute("user");
		
		return user.getCart();
		
	}
	
	@RequestMapping("/cart/add/{foodId}")
	public String addOrder(@PathVariable String foodId, HttpServletRequest request) {
		Food food = foodService.getFoodItem(foodId);
		MyUser user = (MyUser) request.getSession()
				.getAttribute("user");
		
		user.addToCart(food);
		request.getSession().setAttribute("user", user);
				
		return "Item added to your cart. Please choose a delivery type";
	}
	
	@RequestMapping("/order/deliverytype/{deliveryType}")
	public String setDeliveryType(@PathVariable String deliveryType, HttpServletRequest request) {
		MyUser user = (MyUser) request.getSession()
				.getAttribute("user");
		
		user.setDeliveryType(deliveryType);
		request.getSession().setAttribute("user", user);
		
		if(deliveryType.equals("office")) {
			return "Delivery type set. Let us know your distance in miles";
		} else {
			return "Delivery type set. Please choose payment option";
		}
		
	}
	
	@RequestMapping("/order/deliverymiles/{deliveryMiles}")
	public String setDeliveryMiles(@PathVariable String deliveryMiles, HttpServletRequest request) {
		MyUser user = (MyUser) request.getSession()
				.getAttribute("user");
		
		user.setDeliveryMiles(Integer.parseInt(deliveryMiles));
		request.getSession().setAttribute("user", user);
		 
		return "Delivery miles set. Please choose a payment option";
	}
	
	@RequestMapping("/order/payment/{paymentOption}")
	public String setPaymentOption(@PathVariable String paymentOption, HttpServletRequest request) {
		 
		MyUser user = (MyUser) request.getSession()
				.getAttribute("user");
		
		user.setPaymentOption(paymentOption);
		request.getSession().setAttribute("user", user);
		
		return "Payment option set. Visit /checkout to see our order details";
	}
	
	
	@RequestMapping("order/checkout")
	public Order checkout(HttpServletRequest request) {
		MyUser user = (MyUser) request.getSession()
				.getAttribute("user");
		
		user.getOrder().calculateCost();
		return user.getOrder();
	}
	
	@RequestMapping("order/process")
	public String processOrder(HttpServletRequest request) {
		MyUser user = (MyUser) request.getSession()
				.getAttribute("user");
		
		user.setOrder(new Order());
		request.getSession().setAttribute("user", user);
		
		return "Your order is being processed. Thank you";
	}
	
	@RequestMapping("orders")
	public List<Order> allOrder(HttpServletRequest request) {
		List<Order> orders = new ArrayList<>();
		
		for(MyUser user : userService.getAllUsers().values() ) {
			if(user.getOrder().getCart().size() > 0) {
				orders.add(user.getOrder());
			}
			 
		}
		
		return orders;
		
	}
	
	

}
