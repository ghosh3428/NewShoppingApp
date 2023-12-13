package com.niit.MyOnlineBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MyOnlineBackend.DAO.CategoryDAO;
import com.niit.MyOnlineBackend.model.Category;

public class CategoryTest 
{
	
	private Category c;
	private static CategoryDAO categoryDAO;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.MyOnlineBackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	
	@Test
	public void insertTest()
	{
		c = new Category();
		c.setActive(true);
		c.setCategoryName("Headphone");
		c.setDescription("Sample category for headphone.");
		
		assertEquals("Error",true,categoryDAO.insert(c));
		
	}
	
	//@Test
	public void getTest()
	{
		c = categoryDAO.getCategory(219);
		assertEquals("Error","Smart Phone",c.getCategoryName());
		
	}
	
	//@Test
	public void getCategoryListTest()
	{
		
		assertEquals("Error",1,categoryDAO.categoryList().size());
		
	
	}
	
	

}
