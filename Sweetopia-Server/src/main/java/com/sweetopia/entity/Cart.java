package com.sweetopia.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@NotNull
	private double grandTotal;
	
	@NotNull
	private int productCount;
	
	@NotNull
	private double total;
	
	@OneToMany
	private List<Product> listProduct;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Cart() {
		super();
	}

	public Cart(double grandTotal, int productCount, double total, List<Product> listProduct, Customer customer) {
		super();
		this.grandTotal = grandTotal;
		this.productCount = productCount;
		this.total = total;
		this.listProduct = listProduct;
		this.customer = customer;
	}

	public Cart(int cartId, double grandTotal, int productCount, double total, List<Product> listProduct,
			Customer customer) {
		super();
		this.cartId = cartId;
		this.grandTotal = grandTotal;
		this.productCount = productCount;
		this.total = total;
		this.listProduct = listProduct;
		this.customer = customer;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
