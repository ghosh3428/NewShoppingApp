package com.niit.MyOnlineBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MyOnlineBackend.DAO.CategoryDAO;
import com.niit.MyOnlineBackend.DAO.UserDAO;
import com.niit.MyOnlineBackend.model.Category;
import com.niit.MyOnlineBackend.model.User;

public class UserTest 
{
	private User u;
	private static UserDAO userDAO;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.MyOnlineBackend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	//@Test
	public void insertUserTest()
	{
		u = new User();
		u.setContactNumber("1234567890");
		u.setEmail("niitjadavpur@gmail.com");
		u.setEnabled(true);
		u.setFirstName("Niit");
		u.setLastName("Jadavpur");
		u.setPassword("admin@12345");
		u.setRole("ADMIN");
		
		assertEquals("Error adding User",true,userDAO.insert(u));
		
	}
	
	
	@Test
	public void getUserByEmailTest()
	{
		u = userDAO.getUserByEmail("niitjadavpur@gmail.com");
		
		assertEquals("Error fetching user","Niit",u.getFirstName());
		
	}
}
