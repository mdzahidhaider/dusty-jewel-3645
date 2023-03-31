package com.sweetopia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "userType", discriminatorType = DiscriminatorType.STRING)
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String userName;

//	@Pattern(regexp = "^(?=.[a-z])(?=.[A-Z]).{8,}$", message = "Eight characters long and at least one upper and one lower")
	private String userPassword;

//	@Column(name = "userType", insertable = false, updatable = false)
	@Pattern(regexp = "^(admin|customer)$", message = "Type can only be admin or customer")
	private String userType;


	
}
