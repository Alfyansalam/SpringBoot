package com.example.userdetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userdetails.model.User;

@Repository
public interface urepository extends JpaRepository<User,Integer>{

}

