package com.byteworks;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int id;
	private String deliveryType;
	private String paymentOption;
	private List<Food> cart = new ArrayList<>();
	private double totalCost = 0;
	private int distance = 0;
	
	public Order() {
		super();
		
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public double getTotalCost() {
		return totalCost;
	}

	public String getOrderType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public List<Food> getCart() {
		return cart;
	}

	public void addToCart(Food food) {
		totalCost += food.getPrice();
		this.cart.add(food);
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void calculateCost() {
		double discount = 0;
		double logistic = 10 * distance;
		
		if (paymentOption.equals("credit_card")) {
			discount = (totalCost / 100) * 2.5;
		}
		
		totalCost =  (totalCost - discount) + logistic;
	}
	
	

}
