package com.example.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.Product;

@Repository
public interface productRepo extends JpaRepository<Product,Integer> {
Product findByName(String name);
}
