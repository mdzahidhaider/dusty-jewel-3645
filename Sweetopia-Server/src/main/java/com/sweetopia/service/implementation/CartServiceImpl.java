package com.sweetopia.service.implementation;

import java.util.ArrayList;
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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository CartRepository;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;
	


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Cart updateCart(Cart cart) throws ProductException {
		if(cart.getCartId()!=null){
			Cart cart1 = showAllCarts(cart.getCartId());
			List<ProductDTO> list =cart1.getListProduct();
			cart1.setListProduct(new ArrayList<>());
			cart1.setTotal(0.0);
			cart1.setProductCount(0);
			cart1.setGrandTotal(0.0);
			CartRepository.save(cart1);

			for(ProductDTO productDTO:cart.getListProduct()){
				try{
					addProductToCart(cart.getCustomer().getId(),productDTO.getProductId(), productDTO.getQuantity());
				}catch(ProductException ex){

				}
			}
			for(ProductDTO productDTO:list){
				Product product = productService.getProductById(productDTO.getProductId());
				product.setAvailable(product.getAvailable()+productDTO.getQuantity());
				productService.updateProduct(product);
			}
		}else{
			throw new CartNotFoundException("Cart id cannot be null");
		}

		return showAllCarts(cart.getCartId());


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
	@Transactional(propagation = Propagation.REQUIRED)
	public Cart addProductToCart(Long customerId, Long ProductId, Integer quantity) throws ProductException {
		Customer customer=customerService.getCustomerById(customerId);
		Product product=productService.getProductById(ProductId);
		if(product.getAvailable()<quantity)throw new ProductException("Product only has "+product.getAvailable()+" stock");
		product.setAvailable(product.getAvailable()-quantity);
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
			productDTO.setPhotoPath(product.getPhotoPath());
			cart.getListProduct().add(productDTO);
		}else{
			cart.getListProduct().get(i).setQuantity(cart.getListProduct().get(i).getQuantity()+quantity);
		}




			productService.updateProduct(product);

			cart.setProductCount(cart.getProductCount()+quantity);
			cart.setTotal(cart.getTotal()+(int)(product.getPrice()*quantity));
			cart.setGrandTotal(cart.getTotal());



		return CartRepository.save(cart);
	}


}
