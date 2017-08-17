package com.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.spring.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

 
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}
	
	@Transactional 
	public boolean saveCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}

	public void add(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(category);
		
	}

	public void edit(Category category) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().update(category);
		
	}

	public void delete(int Catid) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().delete(getCategory(Catid));
	}

	public Category getCategory(int Catid) {
		// TODO Auto-generated method stub
		return (Category)sessionFactory.getCurrentSession().get(Category.class, Catid);
	}

	public List getAllCategory() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	@Transactional
	public List<Category> list() {
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession()
				.createQuery("from Category").list();

		return listCategory;
	}
}
