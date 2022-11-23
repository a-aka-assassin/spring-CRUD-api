package com.spring.app.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.rest.Models.User;
import com.spring.app.rest.Repo.UserRepo;

@RestController
public class ApiController {
	
	@Autowired
	private UserRepo userrepo;
	
	@GetMapping(value = "/")
	public String getPage() {
		return "Hello";
	}
	
	@GetMapping(value = "/users")
	public List<User> getUsers() {
		return userrepo.findAll();
	}
	
	@PostMapping(value ="/save")
	public String saveUser(@RequestBody User user) {
		userrepo.save(user);
		return "Saved";
	}
	
	@PutMapping(value = "/edit/{id}")
	public String updateUser(@PathVariable Long id, @RequestBody User user) {
		User updateUser = userrepo.findById(id).get();
		updateUser.setFname(user.getFname());
		updateUser.setLname(user.getLname());
		updateUser.setAge(user.getAge());
		updateUser.setOccupation(user.getOccupation());
		userrepo.save(updateUser);
		return "User Updated";
		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		User deleteUser = userrepo.findById(id).get();
		userrepo.delete(deleteUser);
		return "User deleted with the id of " + id;
	}
}
