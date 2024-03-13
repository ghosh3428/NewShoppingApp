package com.niit.MyOnlineBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.MyOnlineBackend.DAO.CartLinesDAO;
import com.niit.MyOnlineBackend.DAO.ProductDAO;
import com.niit.MyOnlineBackend.model.CartLines;
import com.niit.MyOnlineBackend.model.Product;

public class CartlinesTest 
{
	private Product p;
	private CartLines c;
	private static CartLinesDAO cartLinesDAO;
	private static ProductDAO productDAO;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.MyOnlineBackend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
		cartLinesDAO = (CartLinesDAO)context.getBean("cartLinesDAO");
	}
	
	
	@Test
	public void testAddCartLines()
	{
		
		p = productDAO.getProduct(68);
		
		c = new CartLines();
		
		c.setBuyingPrice(p.getUnitPrice());
		c.setCartId(36);
		c.setProduct(p);
		c.setProductCount(3);
		c.setTotal(c.getBuyingPrice() * c.getProductCount());
		
		assertEquals("Error",true,cartLinesDAO.add(c));
		
	}

}
