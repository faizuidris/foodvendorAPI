package com.byteworks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyUser extends User {
	private Order order = new Order();

	public MyUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}
	
	public MyUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}

	public List<Food> getCart() {
		return order.getCart();
	}
	
	public void addToCart(Food food) {
		this.order.addToCart(food);
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public void setDeliveryType(String deliveryType) {
		this.order.setDeliveryType(deliveryType);
	}

	public void setPaymentOption(String paymentOption) {
		this.order.setPaymentOption(paymentOption);
	}
	
	public void setDeliveryMiles(int miles) {
		order.setDistance(miles);
	}
}
