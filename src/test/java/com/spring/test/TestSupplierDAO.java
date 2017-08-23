/*package com.spring.test;

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
	public void addSupplierTestCase()
	{
		supplier.setSupplier_name("Dinesh");
			supplierDAO.add(supplier);
			int noofpro = supplierDAO.list().size();
			assertEquals(3, noofpro);
		}

	@Test
	public void deleteSupplierTestCase()
	{
		supplierDAO.delete(910);
		int noofpro = supplierDAO.list().size();
		assertEquals(2, noofpro);
	}
	
	@Test
	public void editSupplierTestCase()
	{
		supplier.setId(911);;
		supplier.setSupplier_name("naveen");
		supplierDAO.edit(supplier);
		int noofpro = supplierDAO.list().size();
		assertEquals(3, noofpro);
	}
		
}
*/