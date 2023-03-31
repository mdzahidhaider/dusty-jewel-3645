package com.sweetopia.service;

import java.util.List;

import com.sweetopia.entity.Cart;
import com.sweetopia.exception.ProductException;


public interface CartService {


	public Cart updateCart(Cart cart);
	public List<Cart> showAllCarts();
	public Cart showAllCarts(Long cartId);
	public Cart addProductToCart(Long customerId,Long ProductId,Integer quantity) throws ProductException;
}
