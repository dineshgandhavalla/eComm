package com.spring.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Order;


@Repository
public class OrderDAOImpl implements OrderDAO {

	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public OrderDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}
	@SuppressWarnings("deprecation")
	@Transactional
	public boolean OrderDetails()
	{
		
		@SuppressWarnings("rawtypes")
		Query query =sessionFactory.getCurrentSession().createQuery("insert into Order (orderId , productid , productname ,productprice ,quantity ,status ,subTotal ,userid )"+"select orderId ,productid ,productname ,productprice ,quantity ,status ,subTotal ,userid from Cart");
		 query.executeUpdate();
		
		return true;
		
	}
	
}
