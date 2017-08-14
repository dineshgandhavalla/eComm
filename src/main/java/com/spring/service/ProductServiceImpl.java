package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.ProductDAO;
import com.spring.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;
	
	@Transactional
	public void add(Product product) {
		// TODO Auto-generated method stub
		productDAO.add(product);
	}

	@Transactional
	public void edit(Product product) {
		// TODO Auto-generated method stub
		productDAO.edit(product);
	}

	@Transactional
	public void delete(int pid) {
		// TODO Auto-generated method stub
		productDAO.delete(pid);
	}

	@Transactional
	public Product getProduct(int pid) {
		// TODO Auto-generated method stub
		return productDAO.getProduct(pid);
	}

	@Transactional
	public List getAllProduct() {
		// TODO Auto-generated method stub
		return productDAO.getAllProduct();
	}

	@Transactional
	public List getProductByCategory(int Categoryid) {
		// TODO Auto-generated method stub
		return productDAO.getProductByCategory(Categoryid);
	}

	
}
