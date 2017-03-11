package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;


public interface UserDAO {

	public List<User> list();
	
	public User getUser(String id);
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	// delete category by id

	public boolean delete(String id);

	// delete category by category

	public boolean delete(User user);
	
	// for user name and password is correct or not to check this we need validate methode.
	
	public boolean validate(String id, String password);
	
}
