package com.sweetopia.service.implementation;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.sweetopia.dto.ProductDTO;
import com.sweetopia.entity.Customer;
import com.sweetopia.entity.Product;
import com.sweetopia.exception.ProductException;
import com.sweetopia.service.CustomerService;
import com.sweetopia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import com.sweetopia.entity.Cart;
import com.sweetopia.exception.CartNotFoundException;
import com.sweetopia.exception.InvalidCartException;
import com.sweetopia.repository.CartRepository;
import com.sweetopia.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository CartRepository;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;
	


	@Override
	public Cart updateCart(Cart cart) {
		
		if(!CartRepository.existsById(cart.getCartId())) {
			throw new CartNotFoundException("Cart not found with ID :"+cart.getCartId());
		}

		return CartRepository.save(cart);
	}


	@Override
	public List<Cart> showAllCarts() {
		
		return CartRepository.findAll();
	}

	@Override
	public Cart showAllCarts(Long cartId) {
		Cart cart = CartRepository.findById(cartId).orElseThrow(()-> new CartNotFoundException("Cart not found with ID: "+cartId));
		return cart;
		
	}

	@Override
	public Cart addProductToCart(Long customerId, Long ProductId, Integer quantity) throws ProductException {
		Customer customer=customerService.getCustomerById(customerId);
		Product product=productService.getProductById(ProductId);
		Cart cart = showAllCarts(customer.getCart().getCartId());
		boolean flag=false;
		int i=0;
		for(ProductDTO productDTO:cart.getListProduct()){
			if(productDTO.getProductId()==ProductId){
				flag=true;
				break;
			}
			i++;
		}
		if(!flag){
			ProductDTO productDTO=new ProductDTO();
			productDTO.setProductId(product.getProductId());
			productDTO.setPrice(product.getPrice());
			productDTO.setCategoryName(product.getCategory().getCategoryName());
			productDTO.setDescription(product.getDescription());
			productDTO.setQuantity(quantity);
			productDTO.setName(product.getName());
			cart.getListProduct().add(productDTO);
			System.out.println(productDTO);
		}else{
			cart.getListProduct().get(i).setQuantity(cart.getListProduct().get(i).getQuantity()+quantity);
		}






			cart.setProductCount(cart.getProductCount()+quantity);
			cart.setTotal(cart.getTotal()+(int)(product.getPrice()*quantity));
			cart.setGrandTotal(cart.getTotal());



		return CartRepository.save(cart);
	}


}
