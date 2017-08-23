/*package com.spring.test;

import static org.junit.Assert.assertEquals;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.dao.CategoryDAO;
import com.spring.model.Category;

@ComponentScan("com.spring")
public class TestCategoryDAO {

	@Autowired
	private static Category category;

	@Autowired
	private static CategoryDAO categoryDAO;
	

@SuppressWarnings("resource")
@BeforeClass
public static void initialize()
{
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.spring.*");
	context.refresh();
	
	category = (Category) context.getBean("category");
	categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
}


@Test
public void createCategory()
{
	//Category category=new Category();
	category.setCategoryName("Muffins");
	category.setCategoryDescription("small");
	categoryDAO.add(category);
	int catno = categoryDAO.list().size();
	assertEquals(5 , catno);

}


	@Test
	public void editCategory(){
		category.setId(912);
		category.setCategoryName("dessert");
		category.setCategoryDescription("cool");
		categoryDAO.edit(category);
		int catno = categoryDAO.list().size();
		assertEquals(5,catno);
}
	@Test
	public void deleteCategory()
	{
		categoryDAO.delete(912);
		int catno = categoryDAO.list().size();
		assertEquals(4, catno);
	}


}
*/