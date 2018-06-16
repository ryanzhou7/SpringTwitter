
package com.ryanzhou.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryanzhou.model.User;
import com.ryanzhou.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> readUsers(){
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}
	
	@PostMapping
	public User createUser(@RequestBody User user){
		return userRepository.save(user);		
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id){
		userRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public User readUser(@PathVariable Long id){
		return userRepository.findById(id).get();
	}
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user){
		return userRepository.save(user);
	}
	
}
