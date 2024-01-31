package com.niit.MyOnlineBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MyOnlineBackend.DAO.CategoryDAO;
import com.niit.MyOnlineBackend.DAO.ProductDAO;
import com.niit.MyOnlineBackend.DAO.UserDAO;
import com.niit.MyOnlineBackend.model.Category;
import com.niit.MyOnlineBackend.model.Product;
import com.niit.MyOnlineBackend.model.User;

public class ProductTest 
{
	private User u;
	private static UserDAO userDAO;
	private static ProductDAO productDAO;
	private static CategoryDAO categoryDAO;
	private Product p;
	private Category c;
	
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.MyOnlineBackend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
		productDAO = (ProductDAO)context.getBean("productDAO");
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	//@Test
	public void productInsertTest()
	{
		p = new Product();
		/*
		p.setName("Sony PlayStation Pulse 3d Gaming Wireless Over Ear Headset/Headphone");
		p.setDescription("Black with Mic, Dual noise-cancellation Mic, 3.5mm Jack, Tempest 3D audio, USB Type-C charging, 12H Battery");
		p.setBrand("Sony");
		c = categoryDAO.getCategory(253);
		p.setCategoryId(c.getId());
		p.setSupplierId(255);
		p.setQuantity(15);
		p.setUnitPrice(7394);
		*/
		
		/*
		p.setName("Sony NWE394/R 8GB Walkman MP3 Player (Red)");
		p.setDescription("Product Dimensions	‎7.92 x 4.6 x 16.97 cm; 154.22 Grams\r\n" + 
				"Batteries	‎1 Lithium Polymer batteries required. (included)\r\n" + 
				"Item model number	‎NWE394/R\r\n" + 
				"Memory Storage Capacity	‎8 GB");
		p.setBrand("Sony");
		p.setCategoryId(252);
		p.setSupplierId(255);
		p.setQuantity(10);
		p.setUnitPrice(12524);
		*/
		/*
		p.setName("Lunar Connect Ace");
		p.setDescription("Round AMOLED Display Smartwatch with 1.43\" (3.63 cm) Screen, Bluetooth Calling, 100+ Sports Modes");
		p.setBrand("Boat");
		p.setCategoryId(251);
		p.setSupplierId(255);
		p.setQuantity(17);
		p.setUnitPrice(2499);
		*/
		
		p.setName("Galaxy S23 Ultra");
		p.setDescription("The S Pen inner cover located within the S Pen slot contains a minimum of 20% ocean-bound polyamide (PA). The front and back glass contain an average of 22% recycled content. The back glass deco film contains a minimum of 80% recycled content.");
		p.setBrand("Samsung");
		p.setCategoryId(219);
		p.setSupplierId(255);
		p.setQuantity(5);
		p.setUnitPrice(134999);
		
		assertEquals("Error adding Product",true,productDAO.insert(p));
	}
	
	//@Test
	public void productUpdateTest()
	{
		p = productDAO.getProduct(257);
		
		//assertEquals("Error","Sony NWE394/R 8GB Walkman MP3 Player (Red)" , p.getName());
		
		p.setQuantity(25);
		p.setUnitPrice(15000);
		
		assertEquals("Error",true , productDAO.update(p));
	}
	
	//@Test
	public void listProductTest()
	{
		assertEquals("Error",4 , productDAO.listProduct().size());
	}
	
	//@Test
	public void listActiveProductTest()
	{
		assertEquals("Error",3 , productDAO.listActiveProducts().size());
	}
	
	@Test
	public void listActiveProductByCategoryTest()
	{
		assertEquals("Error",1 , productDAO.listActiveProductsByCategory(253).size());
	}
	

}
