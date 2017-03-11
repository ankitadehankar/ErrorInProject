package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

@Transactional
@Repository("productDAO")
@Component
public class ProductDAOImpl implements ProductDAO {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	

	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("from product").list();
	}

	public boolean save(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteProductById(String id) {
		try {
			//sessionFactory.getCurrentSession().delete(getProductByID(id));
			sessionFactory.getCurrentSession().delete(getProductByID(id));
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteProductByName(String name) {

		try {
			sessionFactory.getCurrentSession().delete(getProductByName(name));
			
			System.out.println("Name passed is "+getProductByName(name));
			
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return false;
		}
	}

	public Product getProductByID(String id) {
		
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	public Product getProductByName(String name) {
		System.out.println("Value passed is "+name);
		
		return (Product) sessionFactory.getCurrentSession().get(Product.class, name);
		
	}

	public Product getProductByPrice(int price) {
		System.out.println("price is: "+price);
	   return (Product) sessionFactory.getCurrentSession().get(Product.class, price);
	}	

}
