package com.sweetopia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String userName;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "Eight characters long and at least one upper and one lower")
	private String userPassword;
	@Pattern(regexp = "^(admin|customer)$", message = "Type can only be admin or customer")
	private String userType;
	

}
