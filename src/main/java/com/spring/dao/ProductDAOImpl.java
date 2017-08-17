package com.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Product;

@Repository 
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}
	

	@Transactional
	public boolean saveProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}


	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Product> list() {
	List<Product>product=(List<Product>)sessionFactory.getCurrentSession().createQuery("from Product").list();
		return product;
	}


	public void add(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(product);
		
	}


	public void edit(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(product);
	}


	public void delete(int pid) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(getProduct(pid));
	}

	@Transactional
	public Product getProduct(int pid) {
		// TODO Auto-generated method stub
		return (Product)sessionFactory.getCurrentSession().get(Product.class, pid);
	}


	public List getAllProduct() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}


	public List getProductByCategory(int Categoryid) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Product where Catid="+Categoryid).list();
	}

}
