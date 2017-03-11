package com.niit.shoppingcart.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	// instead of writting sessionFactory.getCurrentSession() every time we can create our own private method
	
	/**
	 * 
	 * private Session getSession()
	 * {
		return sessionFactory.getCurrentSession();
	}
	 */
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	public List<User> list() {
		
			return sessionFactory.getCurrentSession().createQuery("from User").list();
		
	}

	public User getUser(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
			} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
			} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean validate(String id, String password) {
		
		//select * from User where id = '' and password = ''
		String hql = "from User where id = '"+id+"'"+"and password = '"+password+"'";
		
        if(sessionFactory.getCurrentSession().createQuery(hql).uniqueResult() == null){
        	return false;
        } else {
			return true;
		}
	
	}


	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getUser(id));
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			
		}

}

}
