package com.niit.MyOnlineBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MyOnlineBackend.DAO.CategoryDAO;
import com.niit.MyOnlineBackend.DAO.UserDAO;
import com.niit.MyOnlineBackend.model.Cart;
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
	
	/*@Test
	public void insertUserTest()
	{
		u = new User();
		u.setContactNumber("1237867890");
		u.setEmail("jdv_kolkata@gmail.com");
		u.setEnabled(true);
		u.setFirstName("Jadavpur");
		u.setLastName("kolkata");
		u.setPassword("admin@12345");
		u.setRole("ADMIN");
		
		assertEquals("Error adding User",true,userDAO.insert(u));
		
	}
	
	*/
	
	//@Test
	public void getUserByEmailTest()
	{
		u = userDAO.getUserByEmail("niitjadavpur@gmail.com");
		
		assertEquals("Error fetching user","Niit",u.getFirstName());
		
	}
	
	@Test
	public void insertUserTest()
	{
		u = new User();
		u.setContactNumber("1237867890");
		u.setEmail("am@gmail.com");
		u.setEnabled(true);
		u.setFirstName("Amit");
		u.setLastName("Kumar");
		u.setPassword("user@12345");
		u.setRole("USER");
		
		Cart c = new Cart();
		
		c.setUser(u);
		
		u.setCart(c);
		
		assertEquals("Error adding User",true,userDAO.insert(u));
		
	}
}
