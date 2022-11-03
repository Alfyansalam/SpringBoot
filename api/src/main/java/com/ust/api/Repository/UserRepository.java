package com.ust.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.api.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	

}
