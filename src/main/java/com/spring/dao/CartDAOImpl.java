package com.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Cart;
import com.spring.model.Category;

@SuppressWarnings("deprecation")
@Repository
public class CartDAOImpl implements CartDAO{
 

	@Autowired
	private SessionFactory sessionFactory;
	public CartDAOImpl(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public boolean saveProductToCart(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	
	@Transactional
	public Cart getitem(int prodId, int userId) {
		String hql = "from"+" Cart"+" where userid="+userId+" and productid="+prodId;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Cart> list = (List<Cart>) query.list();
		if (list!= null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	
	@Transactional
	public List<Cart> getAllCartDetails() {
		@SuppressWarnings("unchecked")
		List<Cart> listCart= (List<Cart>) sessionFactory.getCurrentSession()
				.createQuery("from Cart").list();

		return listCart;
	}

	
	
	/*@Autowired
	SessionFactory sessionFactory;
	
	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}

	@Transactional
	public boolean saveCart(Cart cart) {
		int q=1;
		cart.setQuantity(q);
		cart.setSumtotal(q*(cart.getProdprice()));
		 List<Cart> cartList = (List<Cart>) sessionFactory.getAttribute("cart");
			
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

	

*/}
