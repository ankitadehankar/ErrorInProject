package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.domain.Product;

@Component
public interface ProductDAO {
	

	// get all products

	public List<Product> list();

	// create product

	public boolean save(Product product);

	// update product

	public boolean update(Product product);

	// delete product by id

	public boolean deleteProductById(String id);

	// delete product by name

	public boolean deleteProductByName(String name);

	// get product by id

	public Product getProductByID(String id);

	// get product by name
	public Product getProductByName(String name);
	
	//get product by price
	public Product getProductByPrice(int price);

}
