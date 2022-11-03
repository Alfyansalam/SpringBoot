package com.example.userdetails.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userdetails.Service.userService;
import com.example.userdetails.model.User;




@RestController

public class ucontroller {

	@Autowired 
	private userService service;
	
	@PostMapping("/addDetails")
	public List<User> addDetails(@RequestBody List<User> User) {
        return service.saveDetails(User);
    }
	@GetMapping("/users")
	public List<User> findAllProducts() {
	     return service.getDetails();
	}
	@PutMapping("/updateuser")
    public User updateDetail(@RequestBody User User) {
        return service.updateDetails(User);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteDetail(id);
    }
}

