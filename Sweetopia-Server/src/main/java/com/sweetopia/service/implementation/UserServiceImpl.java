//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sweetopia.entity.User;
//import com.sweetopia.exception.AdminNotFoundException;
//import com.sweetopia.repository.UserRepository;
//import com.sweetopia.service.UserService;
//
////package com.sweetopia.service.implementation;
//////package com.sweetopia.service.implementation;
//////
//////import java.util.List;
//////import java.util.Optional;
//////
//////import com.sweetopia.entity.Admin;
//////import com.sweetopia.entity.Customer;
//////import com.sweetopia.exception.CustomerNotFoundException;
//////import com.sweetopia.exception.UserNotFoundException;
//////
//
//@Service
//public class UserServiceImpl implements UserService {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	
//
//	@Override
//	public org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws AdminNotFoundException {
//		// TODO Auto-generated method stub
//		User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new AdminNotFoundException("Admin not found");
//        }
////        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
////		return null;
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
//	}
//
//
//
//	@Override
//	public User saveUser(User user) {
//		// TODO Auto-generated method stub
//		
//		User savedUser = userRepository.save(user);
////		
//		return savedUser;
//	}
//
//
//
//	
//	
//}	
////	public User addUser(User newUser) throws UserNotFoundException {
////		// TODO Auto-generated method stub
////		if(newUser.getId()!=null) {
////			Long id= newUser.getId();
////			if(userRepository.findById(id).isPresent()) {
////				throw new UserNotFoundException();
////			}
////		}
////		User savedUser = userRepository.save(newUser);
////		
////		return savedUser;
////	}
////
////	@Override
////	public List<User> getAllUser() throws UserNotFoundException {
////		// TODO Auto-generated method stub
////		List<User> users = userRepository.findAll();
////		if(users.isEmpty()) {
////			throw new UserNotFoundException("User Not Found");
////		}else
////		return users;
////	}
////
////	@Override
////	public User updateUserDetails(User user) throws UserNotFoundException {
////		// TODO Auto-generated method stub
////		Optional<User> opt = userRepository.findById(user.getId());
////		if(opt.isEmpty()) {
////			throw new UserNotFoundException();
////		}else
////			return userRepository.save(user);
////		
////	}
////
////	@Override
////	public String deleteUser(Long id) throws UserNotFoundException {
////		// TODO Auto-generated method stub
////		Optional<User> opt = userRepository.findById(id);
////		if(opt.isPresent()) {
////			userRepository.deleteById(id);
////			return "User has been successfully deleted";
////		}else
////			throw new UserNotFoundException();
////		
////	}
////
////	@Override
////	public String deleteAllUser() {
////		// TODO Auto-generated method stub
////		userRepository.deleteAll();
////		return "All users are successfully deleted";
////	}
////
////	@Override
////	public Admin addAdmin(Admin newUser) throws UserNotFoundException {
////		// TODO Auto-generated method stub
////		return null;
////	}
////
////	@Override
////	public Customer adminLogin(String email, String password) throws CustomerNotFoundException {
////		// TODO Auto-generated method stub
////		return null;
////	}
////}
