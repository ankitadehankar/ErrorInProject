package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Supplier;


public interface SupplierDAO {
	
	// get all suppliers

		public List<Supplier> list();

		// create supplier

		public boolean save(Supplier supplier);

		// update supplier

		public boolean update(Supplier supplier);

		// delete supplier by id

		public boolean deleteSupplierById(String id);

		// delete supplier by name

		public boolean deleteSupplierByName(String name);

		// get supplier by id

		public Supplier getSupplierByID(String id);

		// get supplier by name
		public Supplier getSupplierByName(String name);
		
		//get supplier by address
		public Supplier getSupplierByAddress(String address);

}
