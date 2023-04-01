package com.sweetopia.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Customer{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String userName;

	//	@Pattern(regexp = "^(?=.[a-z])(?=.[A-Z]).{8,}$", message = "Eight characters long and at least one upper and one lower")
	private String userPassword;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private List<Order> orders=new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Address> addresses = new ArrayList<>();
	
	
	
}