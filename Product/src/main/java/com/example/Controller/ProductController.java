package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Product;
import com.example.Service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	@PostMapping("/addproduct")
	public Product addproduct(@RequestBody Product Product)
	{
		return productservice.saveProduct(Product);
	}
	
	@PostMapping("/addproducts")
	public List<Product>addproduct(@RequestBody List<Product> Product)
	{
		return productservice.saveProducts(Product);
	}
	@GetMapping("/products")
	public  List<Product>findAllProducts(){
		return productservice.getProduct();
	}

}
