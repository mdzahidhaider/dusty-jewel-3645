package com.sweetopia.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	private Double grandTotal;
	private Integer productCount;
	private Double total;

	@ElementCollection
	private List<Product> listProduct;

	@OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
	private Customer customer;


}