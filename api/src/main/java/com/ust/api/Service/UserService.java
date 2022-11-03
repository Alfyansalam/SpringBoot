package com.ust.api.Service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.api.Entity.User;
import com.ust.api.Repository.UserRepository;
import com.ust.api.dto.UserRequest;
@Service
public class UserService {
	
	@Autowired
	UserRepository repository;

	public User saveUser(@Valid UserRequest userrequest) {
		User user=new User();
		user.setName(userrequest.getName());
		user.setEmail(userrequest.getEmail());
		user.setGender(userrequest.getGender());
		user.setPhone(userrequest.getPhone());
		user.setAge(userrequest.getAge());
		user.setNationality(userrequest.getNationality());
		return repository.save(user);
	}

	public List<User> getAllUsers() {

		return repository.findAll();
	}

	
}
