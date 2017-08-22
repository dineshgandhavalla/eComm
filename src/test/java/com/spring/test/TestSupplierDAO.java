package com.spring.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.dao.SupplierDAO;
import com.spring.model.Supplier;
import com.spring.service.SupplierService;

@ComponentScan("com.spring")
public class TestSupplierDAO {

	@Autowired
	private static Supplier supplier;

	@Autowired
	private static SupplierDAO supplierDAO;
	
	@Autowired
	private static SupplierService supplierService;
	
	
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.spring.*");
		context.refresh();
		
			supplier = (Supplier) context.getBean("supplier");
			supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}

	@Test
	public void createSupplierTestCase()
	{
		supplier.setSupplier_name("Dinesh");
	
		boolean flag = supplierDAO.saveSupplier(supplier);
		assertEquals("createSupplierTestCase", true, flag);
	}
/*
	@Test
	public void updateProductTestCase()
	{
		supplier.setSupplier_name("Ramesh");
		
		boolean flag = supplierDAO.saveSupplier(supplier);
		assertEquals("updateSupplierTestCase", true, flag);
	}
	@Test
	public void deleteSupplierTestCase()
	{
	supplier.setId(780);
		Supplier flag =(Supplier)supplierService.delete(780);
		assertEquals("deleteSupplierTestCase", false, flag);
	}
	 
*/
	/*@Test
	public void getAllSupplierTestCase()
	{
		int noofpro=supplierDAO.list().size();
		assertEquals("getAllSupplierTestCase", noofpro);
	}*/
	
	
	
}
