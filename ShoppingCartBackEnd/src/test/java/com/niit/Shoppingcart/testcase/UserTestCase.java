package com.niit.Shoppingcart.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

import junit.framework.Assert;

public class UserTestCase {
	
	@Autowired
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static User user;
	
	@Autowired
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	// TEST CASES
	
	@Test
	public void createUserTestCase()
	{
		user.setId("Us08");
		user.setName("User006");
		user.setContact("84210161144");
		user.setPassword("Pass6");
		user.setRole("");
		
		
		boolean flag = userDAO.save(user);
		
		//compare what u r expecting VS what u r getting from save method
		
		Assert.assertEquals(true, flag);
		
	}
	
	@Test
	public void updateUserTestCase()
	{
		user.setId("niit");
		user.setName("NIIT");
		user.setContact("7564783923");
		user.setPassword("NIIT123");
		user.setRole("");
		
		boolean flag = userDAO.update(user);
		
		//compare what u r expecting VS what u r getting from save method
		
		Assert.assertEquals(true, flag);
	}
	
	@Test
	public void deleteUserByIDTestCase()
	{
		boolean flag = userDAO.delete("CG08032017");
		Assert.assertEquals(true, flag);
	}
	
	/**
	 * @Test
	public void deleteUserbyUserTestCase()
	{
		user.setId("CG05032017");
		boolean flag = userDAO.delete("user");
		Assert.assertEquals(true, flag);
	}
	 * 
	 */
	
	
	
	@Test
	public void getUserById()
	{
		user = userDAO.getUser("");
		
	    Assert.assertEquals(null, user);
	}
	
	@Test
	public void getAllUsers()
	{
		int recordFromDB = userDAO.list().size();
		assertEquals("getAllCategoriesTestCase",6, recordFromDB);
	}

	@Test
	public void validateCredentialsTestCase() {
      
	boolean flag = userDAO.validate("niit", "niit123");
	
	assertEquals("validateCredentialsTestCase ", true, flag);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
