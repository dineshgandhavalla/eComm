package com.spring.dao;

import java.util.List;

import com.spring.model.Category;
import com.spring.model.Product;
 
public interface ProductDAO {

	public boolean saveProduct(Product product);
	
	public void add(Product product);
	public void edit(Product product);
	public void delete(int pid);
	public Product getProduct(int pid);
	public List getAllProduct();
	public List getProductByCategory(int Categoryid);

	public List<Product> list();

}
