//package com.sweetopia.controller;
//
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
//import com.sweetopia.entity.Admin;
//import com.sweetopia.exception.AdminNotFoundException;
//import com.sweetopia.service.AdminService;
//
//
//	@RestController
//	@RequestMapping("/sweetopia/admin")
//	@CrossOrigin(origins = "http://127.0.0.1:5500")
//	public class AdminController {
//		
//	//	
//		@Autowired
//		private AdminService adminService;
//		
//		
//		@PostMapping("/login")
//		public ResponseEntity<Admin> loginAdmin(@RequestBody AdminLoginDTO adminDTO) throws AdminNotFoundException{
//
//			Admin admin=adminService.adminLogin(adminDTO.getEmail(),adminDTO.getPassword());
//			return new ResponseEntity<>(admin,HttpStatus.ACCEPTED);
//		}
//}	
//
