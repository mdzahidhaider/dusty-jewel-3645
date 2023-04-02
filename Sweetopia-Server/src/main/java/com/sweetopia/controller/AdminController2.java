//package com.sweetopia.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sweetopia.dto.AdminLoginDTO;
//import com.sweetopia.dto.CustomerLoginDTO;
//import com.sweetopia.entity.Admin;
//import com.sweetopia.entity.Customer;
//import com.sweetopia.service.AdminService;
//
////package com.sweetopia.controller;
////
////import java.util.List;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.CrossOrigin;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RestController;
////
////import com.sweetopia.dto.AdminLoginDTO;
////import com.sweetopia.entity.Admin;
////import com.sweetopia.entity.Category;
////import com.sweetopia.entity.Customer;
////import com.sweetopia.entity.Product;
////import com.sweetopia.exception.AdminNotFoundException;
////import com.sweetopia.exception.CategoryException;
////import com.sweetopia.exception.CustomerNotFoundException;
////import com.sweetopia.exception.ProductException;
////import com.sweetopia.service.AdminService;
////
//@RestController
//@RequestMapping("/sweetopia/admin")
//@CrossOrigin(origins = "http://127.0.0.1:5500")
//public class AdminController2 {
//	
////	
//	@Autowired
//	private AdminService adminService;
//	
//	
//	@PostMapping("/login")
//	public ResponseEntity<Admin> loginAdmin(@RequestBody AdminLoginDTO adminDTO){
//
//		Admin admin=adminService.adminLogin(adminDTO.getEmail(),adminDTO.getPassword());
//		return new ResponseEntity<>(admin,HttpStatus.ACCEPTED);
//	}
//}	
////	
////	@PostMapping("/login")
////	public ResponseEntity<Admin> loginAdmin(@RequestBody AdminLoginDTO adminDTO) throws AdminNotFoundException{
////
////		Admin admin=adminService.adminLogin(adminDTO.getEmail(),adminDTO.getAdminPassword());
////		return new ResponseEntity<>(admin,HttpStatus.ACCEPTED);
////	}
////	
//////	@GetMapping("/users")
//////	public ResponseEntity<List<User>> getListOfAllUsers() throws AdminNotFoundException{
//////		List<User> users = adminService.allUsers();
//////		return new ResponseEntity<>(users,HttpStatus.FOUND);
//////		
//////		
//////	}
//////	@GetMapping("/customers")
//////	public ResponseEntity<List<Customer>> getListOfAllCustomers() throws CustomerNotFoundException{
//////		List<Customer> customers = adminService.allCustomers();
//////		return new ResponseEntity<>(customers,HttpStatus.FOUND);
//////		
//////		
//////	}
//////	
//////	@GetMapping("/products")
//////	public ResponseEntity<List<Product>> getListOfAllProducts() throws ProductException{
//////		List<Product> products = adminService.allProducts();
//////		return new ResponseEntity<>(products,HttpStatus.FOUND);
//////		
//////		
//////	}
//////	
//////	@GetMapping("/categories")
//////	public ResponseEntity<List<Category>> getListOfAllCategories() throws CategoryException{
//////		List<Category> categories = adminService.allCategories();
//////		return new ResponseEntity<>(categories,HttpStatus.FOUND);
//////		
//////		
//////	}
////
////}
