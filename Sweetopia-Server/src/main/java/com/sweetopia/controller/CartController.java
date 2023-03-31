package com.sweetopia.controller;

import java.util.List;

import com.sweetopia.exception.ProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	

	@PostMapping
	public ResponseEntity<Cart> addProductToCart(@RequestParam("customerId") Long cutomerId,@RequestParam("productId") Long productId,@RequestParam("quantity") Integer quantity) throws ProductException {
		Cart cart=cartService.addProductToCart(cutomerId,productId,quantity);
		return new ResponseEntity<>(cart,HttpStatus.ACCEPTED);
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

			Cart carts = cartService.showAllCarts(cartId);
			return new ResponseEntity<>(carts,HttpStatus.OK);

	}
	
}
