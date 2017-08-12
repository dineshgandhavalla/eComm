package com.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CategoryDAO;
import com.spring.model.Category;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Transactional
	public void add(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.add(category);
	}
	@Transactional
	public void edit(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.edit(category);
	}
	@Transactional
	public void delete(int Catid) {
		// TODO Auto-generated method stub
		categoryDAO.delete(Catid);
	}
	@Transactional
	public Category getCategory(int Catid) {
		// TODO Auto-generated method stub
		return categoryDAO.getCategory(Catid);
	}
	@Transactional
	public List getAllCategory() {
		// TODO Auto-generated method stub
		return categoryDAO.getAllCategory() ;
	}

}
