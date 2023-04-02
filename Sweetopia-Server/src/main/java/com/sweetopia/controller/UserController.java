//
////import org.springframework.stereotype.Controller;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.ModelAttribute;
////import org.springframework.web.bind.annotation.PostMapping;
//
//import com.sweetopia.entity.User;
//import com.sweetopia.service.UserService;
//
////import ch.qos.logback.core.model.Model;
//
////package com.sweetopia.controller;
////
////import java.util.List;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.CrossOrigin;
////import org.springframework.web.bind.annotation.DeleteMapping;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PatchMapping;
////import org.springframework.web.bind.annotation.PathVariable;
////import org.springframework.web.bind.annotation.PostMapping;
////import org.springframework.web.bind.annotation.PutMapping;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.web.bind.annotation.RequestMapping;
////import org.springframework.web.bind.annotation.RestController;
////
////import com.sweetopia.entity.Product;
////import com.sweetopia.entity.User;
////import com.sweetopia.exception.ProductException;
////import com.sweetopia.exception.AdminNotFoundException;
////import com.sweetopia.service.UserService;
////
////import jakarta.persistence.EntityManager;
////import jakarta.persistence.PersistenceContext;
////import jakarta.validation.Valid;
////
////@RestController
////@RequestMapping("/sweetopia")
////@CrossOrigin(origins = "http://127.0.0.1:5500")
//@Controller
//public class UserController {
//
//
////	    @Autowired
////	    private UserService userService;
////
////	    @GetMapping("/login")
////	    public String showLoginForm() {
////	        return "login";
////	    }
////
////	    @GetMapping("/signup")
////	    public String showSignupForm(Model model) {
////	        ((Object) model).addAttribute("user", new User());
////	        return "signup";
////	    }
////
////	    @PostMapping("/signup")
////	    public String registerUser(@ModelAttribute("user") User user) {
////	        userService.saveUser(user);
////	        return "redirect:/login";
////	    }
//	}
//
//}
////	
////	@Autowired
////	private UserService userService;
////	
//////	@PersistenceContext
//////    private EntityManager entityManager;
////	
////	
////	@PostMapping("/add")
////	public ResponseEntity<User> addUser(@Valid @RequestBody User user) throws AdminNotFoundException{
////		User addedUser = userService.addUser(user);
////		return new ResponseEntity<>(addedUser,HttpStatus.CREATED);
////	}
////	
////	@GetMapping("/users")
////	public ResponseEntity<List<User>> getAllUser() throws AdminNotFoundException{
////		List<User> allUsers = userService.getAllUser();
////		return new ResponseEntity<>(allUsers, HttpStatus.ACCEPTED);
////	}
////	
////	
////	
////
////	@PutMapping("/update/{id}")
////	public ResponseEntity<User> updateUserDetails(@Valid @RequestBody User user, @PathVariable Long id) throws AdminNotFoundException{
////		 
////		        user.setId(id);
////		        User updatedUser=userService.updateUserDetails(user);
////		        return new ResponseEntity<>(updatedUser,HttpStatus.ACCEPTED);
////		   
////		
////	}
////	
////
////	@DeleteMapping("delete/{id}")
////	public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws AdminNotFoundException{
////		String userDeleted = userService.deleteUser(id);
////		return new ResponseEntity<String>(""+ userDeleted, HttpStatus.OK);
////	}
////	
////	@DeleteMapping("deleteall")
////	public ResponseEntity<String> deleteAllUser() {
////		String allDeletedUser = userService.deleteAllUser();
//////		String userDeleted = userService.deleteUser(id);
////		return new ResponseEntity<String>("All users have been deletd "+ allDeletedUser, HttpStatus.OK);
////	}
////}	
