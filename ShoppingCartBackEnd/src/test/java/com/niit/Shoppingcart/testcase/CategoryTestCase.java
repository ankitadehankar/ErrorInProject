package com.niit.Shoppingcart.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

import junit.framework.Assert;

public class CategoryTestCase {

	@Autowired
	private static Category category;
	
	@Autowired
	private static CategoryDAO categoryDAO;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		category = (Category) context.getBean("category");
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
	}
	
	// TEST CASES
	
	@Test
	public void createCategoryTestCase()
	{
		category.setId("CG08032017");
		category.setName("Rado Watch");
		category.setDescription("This is Rado Watch Category");
		
		boolean flag = categoryDAO.save(category);
		
		//compare what u r expecting VS what u r getting from save method
		
		Assert.assertEquals(true, flag);
		
	}
	
	@Test
	public void updateCategoryTestCase()
	{
		category.setId("CG01032017");
		category.setName("MobilePhone Category");
		category.setDescription("This is Men Category");
		
		boolean flag = categoryDAO.update(category);
		
		//compare what u r expecting VS what u r getting from save method
		
		Assert.assertEquals(true, flag);
		
	}
	
	@Test
	public void deleteCategoryByIDTestCase()
	{
		boolean flag = categoryDAO.delete("CG05032017");
		Assert.assertEquals(true, flag);
	}
	
	@Test
	public void deleteCategorybyCategoryTestCase()
	{
		category.setId("CG05032017");
		boolean flag = categoryDAO.delete("category");
		Assert.assertEquals(true, flag);
	}
	
	@Test
	public void getCategoryByIDTestCase()
	{
		category = categoryDAO.getCategoryByID("CG01032017");
		
	    Assert.assertEquals(null, category);

	}
	
	@Test
	public void getCategoryByNameTestCase()
	{
		category = categoryDAO.getCategoryByName("MobilePhone Category");
		
	    Assert.assertEquals(null, category);

	}
	
	@Test
	public void getAllCategoriesTestCase()
	{
		int recordFromDB = categoryDAO.list().size();
		assertEquals("getAllCategoriesTestCase", 4, recordFromDB);
	}
	
}
