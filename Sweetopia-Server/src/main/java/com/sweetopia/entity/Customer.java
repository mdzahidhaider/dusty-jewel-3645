package com.sweetopia.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Customer extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@NotNull
	private String username;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private Set<Order> sweetOrders;
	
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
	private Cart cart;

	public Customer() {
		super();
	}

	public Customer(Long userId, @NotNull String username, Set<Order> sweetOrders, Cart cart) {
		super();
		this.userId = userId;
		this.username = username;
		this.sweetOrders = sweetOrders;
		this.cart = cart;
	}

	public Customer(@NotNull String username, Set<Order> sweetOrders, Cart cart) {
		super();
		this.username = username;
		this.sweetOrders = sweetOrders;
		this.cart = cart;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Order> getSweetOrders() {
		return sweetOrders;
	}

	public void setSweetOrders(Set<Order> sweetOrders) {
		this.sweetOrders = sweetOrders;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
	
	
}
