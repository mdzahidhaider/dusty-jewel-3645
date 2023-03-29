package com.sweetopia.service;

import java.util.List;

import com.sweetopia.entity.Cart;

public interface CartService {

	public Cart addCart(Cart cart);
	public Cart updateCart(Cart cart);
	public Cart cancelCart(int cartId);
	public List<Cart> showAllCarts();
	public List<Cart> showAllCarts(int cartId);
}
