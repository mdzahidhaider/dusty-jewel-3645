package com.sweetopia.service.implementation;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweetopia.entity.Cart;
import com.sweetopia.exception.CartNotFoundException;
import com.sweetopia.exception.InvalidCartException;
import com.sweetopia.repository.CartRepository;
import com.sweetopia.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository CartRepository;
	
	@Override
	public Cart addCart(Cart cart) throws InvalidCartException{
		vlalidateCart(cart);
		return CartRepository.save(cart);
	}

	@Override
	public Cart updateCart(Cart cart) {
		
		if(!CartRepository.existsById(cart.getCartId())) {
			throw new CartNotFoundException("Cart not found with ID :"+cart.getCartId());
		}
		vlalidateCart(cart);
		return CartRepository.save(cart);
	}

	@Override
	public Cart cancelCart(Long cartId) {
		Cart cart = CartRepository.findById(cartId).orElseThrow(()-> new CartNotFoundException("Cart not found with ID :"+cartId));
		CartRepository.delete(cart);
		return cart;
	}

	@Override
	public List<Cart> showAllCarts() {
		
		return CartRepository.findAll();
	}

	@Override
	public List<Cart> showAllCarts(Long cartId) {
		Cart cart = CartRepository.findById(cartId).orElseThrow(()-> new CartNotFoundException("Cart not found with ID: "+cartId));
		return Collections.singletonList(cart);
		
	}

	private void vlalidateCart(Cart cart)throws InvalidCartException{
		
		if(cart.getProductCount()<= 0) {
			throw new InvalidCartException("Cart should have at least one product");
		}
	}
}
