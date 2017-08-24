/*package com.spring.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.dao.ProductDAO;
import com.spring.model.Product;

@ComponentScan("com.spring")
public class TestProductDAO {

	@Autowired
	private static Product product;

	@Autowired
	private static ProductDAO productDAO;
	
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.*");
		context.refresh();
		
		product = (Product) context.getBean("product");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}


	@Test
	public void createProduct(){
		product.setProduct_name("cream donut");
		product.setDescription("small");
		product.setPrice(20);
		product.setStock(10);
		product.setCatid(878);
		product.setSupid(911);
		productDAO.add(product);
		int prodno = productDAO.list().size();
		assertEquals(16,prodno);
	}

}
*/