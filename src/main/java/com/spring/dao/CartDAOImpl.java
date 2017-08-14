package com.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Cart;

@Repository
public class CartDAOImpl implements CartDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}

	@Transactional
	public boolean saveCart(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	public List getAllCartDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cart> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public List getCartByProduct(int Productid) {
		
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Product where id="+Productid).list();
	}

	

}
