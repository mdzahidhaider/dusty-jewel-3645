package com.sweetopia.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sweetopia.dto.ProductDTO;
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
	private Double grandTotal=0.0;
	private Integer productCount=0;
	private Double total=0.0;

	@Embedded
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "cart_Product", joinColumns = @JoinColumn(name = "cart_id"))
	private List<ProductDTO> listProduct=new ArrayList<>();

	@OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)

	@JsonIgnore
	private Customer customer;


}