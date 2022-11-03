package com.example.userdetails.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userdetails.Repository.urepository;
import com.example.userdetails.model.User;



@Service
public class userService {
	
	@Autowired
	 private urepository repository;
	
	public List<User> saveDetails(List<User> user) {
		return repository.saveAll(user);
	}

	public List<User> getDetails() {
		return repository.findAll();
	}

	public String deleteDetail(int id) {
        repository.deleteById(id);
        return id + " is removed !! " ;
	}

	public User updateDetails(User user) {
		User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setUsername(user.getUsername());
        existingUser.setPhone(user.getPhone());
        existingUser.setAddress(user.getAddress());
        return repository.save(existingUser);
	}


}