package com.niit.MyOnlineFrontend.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.MyOnlineBackend.DAO.CartLinesDAO;
import com.niit.MyOnlineBackend.model.Cart;
import com.niit.MyOnlineBackend.model.CartLines;
import com.niit.MyOnlineFrontend.model.UserModel;


@Service("cartlinesService")
public class CartLinesService 
{
	@Autowired
	private HttpSession session;
	
	@Autowired
	CartLinesDAO cartlinesDAO;

	private Cart getCart() 
	{
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}
	
	public List<CartLines> getCartLines()
	{
		Cart cart = this.getCart();
		return cartlinesDAO.list(cart.getId());
	}
}
