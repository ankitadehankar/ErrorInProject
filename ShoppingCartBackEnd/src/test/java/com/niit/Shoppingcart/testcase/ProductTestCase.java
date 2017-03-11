package com.niit.Shoppingcart.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

import junit.framework.Assert;

public class ProductTestCase {

	@Autowired
	private static Product product;
	
	@Autowired
	private static ProductDAO productDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void init(){
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		product = (Product) context.getBean("product");
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		
		// 		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}
	
	// TEST CASES
	
	@Test
	public void createProductTestCase()
	{
		product.setId("p06");
		product.setName("Green Casuals");
		product.setPrice(2500);
		
		boolean flag = productDAO.save(product);
		
		Assert.assertEquals(true, flag);

	}
	
	
	@Test
	public void updateProductTestCase()
	{
		product.setId("p03");
		product.setName("Hight Casuals");
		product.setPrice(1900);

		boolean flag = productDAO.update(product);
		
		Assert.assertEquals(true, flag);
		
	}
	
	/**
	 * 
	 * 
	 * @Test
	 * public void deleteProductByIdTestCase()
	{
		boolean flag = productDAO.deleteProductById("p02");
		
		Assert.assertEquals(true, flag);
	}
	 */
	
	
	@Test
	public void deleteProductNameTestCase()
	{
		//product.setName("Green Casuals");
		
		boolean h = productDAO.deleteProductByName("Green Casuals");
		
		Assert.assertEquals(true,h);

	}
	
	@Test
	public void getProductByIdTestCase()
	{
		product = productDAO.getProductByID("p01");
		
		Assert.assertEquals(null, "product");
	}
	
	@Test
	public void getProductByNameTestCase()
	{
		product = productDAO.getProductByName("WhiteCasuals");
		
		Assert.assertEquals(null, "product");
	}
	
	
	@Test
	public void getProductByPriceTestCase()
	{
		product = productDAO.getProductByPrice(2500);
		
		Assert.assertEquals(null, "product");
	}
	
}
