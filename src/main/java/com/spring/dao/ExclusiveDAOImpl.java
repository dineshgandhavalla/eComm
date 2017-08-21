package com.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Exclusive;

@Repository
public class ExclusiveDAOImpl implements  ExclusiveDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public ExclusiveDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}
	
	
	@Transactional
	public void add(Exclusive exclusive) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(exclusive);
	}

	@Transactional
	public void edit(Exclusive exclusive) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(exclusive);
	}

	@Transactional
	public void delete(int exid) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(getExclusive(exid));
	}

	@Transactional
	public Exclusive getExclusive(int exid) {
		// TODO Auto-generated method stub
		return (Exclusive)sessionFactory.getCurrentSession().get(Exclusive.class, exid);
	}

	public List getAllExclusive() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Exclusive").list();
	}


	@SuppressWarnings("unchecked")
	@Transactional
	public List<Exclusive> list() {
		// TODO Auto-generated method stub
		List<Exclusive> exclusive=(List<Exclusive>)sessionFactory.getCurrentSession().createQuery("from Exclusive").list();
		return exclusive;
	}

	

}
