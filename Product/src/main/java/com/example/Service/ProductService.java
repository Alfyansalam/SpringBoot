package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.productRepo;
import com.example.Model.Product;

@Service
public class ProductService {

@Autowired
productRepo repo;

	public List<Product> saveProducts(List<Product> Product) {
		
		return repo.saveAll(Product);
	}

	public List<Product> getProduct() {
		
		return repo.findAll();
	}

	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
