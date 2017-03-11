package com.niit.Shoppingcart.testcase;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

import junit.framework.Assert;

public class SupplierTestCase {
	
	@Autowired
	private static Supplier supplier;
	
	@Autowired
	private static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void init()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		
		context.refresh();
		
		supplier = (Supplier) context.getBean("supplier");
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}
	
	//TEST CASES

	@Test
	public void createSupplierTestCase() {
		
		supplier.setId("SUP005");
		supplier.setName("Name005");
		supplier.setAddress("Address005");
		
		boolean flag = supplierDAO.save(supplier);
		
		Assert.assertEquals(true, flag);
	}
	
	@Test
	public void updateSupplierTestCase() {
		
		supplier.setId("SUP003");
		supplier.setName("Name003");
		supplier.setAddress("Address003");
		
		boolean flag = supplierDAO.update(supplier);
		
		Assert.assertEquals(true, flag);
	}

	@Test
	public void deleteByIdTestCase() {
		
		boolean flag = supplierDAO.deleteSupplierById("SUP01");
		
		Assert.assertEquals(true, flag);
	}
	
	@Test
	public void deleteByNameTestCase() {
		
		boolean flag = supplierDAO.deleteSupplierByName("Name002	");
		
		Assert.assertEquals(true, flag);
		
	}
	
	@Test
	public void getSupplierByIdTestCase()
	{
		supplier = supplierDAO.getSupplierByID("SUP004");
		
	    Assert.assertEquals(null, supplier);
	}
	
	@Test
	public void getSupplierByNameTestCase()
	{
		supplier = supplierDAO.getSupplierByName("");
		
	    Assert.assertEquals(null, supplier);
	}
	
	@Test
	public void getSupplierByAddressTestCase()
	{
		supplier = supplierDAO.getSupplierByAddress("");
		
	    Assert.assertEquals(null, supplier);
	}
	
	
	@Test
	public void getAllSuppliersTestCase()
	{
		int recordFromDB = supplierDAO.list().size();
		Assert.assertEquals("getAllCategoriesTestCase", 3, recordFromDB);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
