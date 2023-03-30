package com.sweetopia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweetopia.entity.Cart;
import com.sweetopia.exception.CartNotFoundException;
import com.sweetopia.exception.InvalidCartException;
import com.sweetopia.service.CartService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/cart")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart){
		
		try {
			Cart savesCart = cartService.addCart(cart);
			return new ResponseEntity<>(savesCart, HttpStatus.CREATED);
			
		}
		catch(InvalidCartException e) {
			return new ResponseEntity<Cart>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{cartId}")
	public ResponseEntity<Cart> updateCart(@PathVariable Long cartId, @RequestBody Cart cart){
		
		try {
			cart.setCartId(cartId);
			Cart updatedCart = cartService.updateCart(cart);
			return new ResponseEntity<Cart>(updatedCart,HttpStatus.OK);
			
		}
		catch(CartNotFoundException e) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Cart>> showAllCarts(){
		
		List<Cart> carts = cartService.showAllCarts();
		return new ResponseEntity<List<Cart>>(carts,HttpStatus.OK);
	}
	
	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> showCartById(@PathVariable Long cartId){
		try {
			List<Cart> carts = cartService.showAllCarts(cartId);
			return new ResponseEntity<Cart>(HttpStatus.OK);
		}catch(CartNotFoundException e) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
	}
	
}
