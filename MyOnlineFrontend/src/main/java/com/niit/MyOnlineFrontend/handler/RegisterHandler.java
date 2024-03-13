package com.niit.MyOnlineFrontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.MyOnlineBackend.DAO.UserDAO;
import com.niit.MyOnlineBackend.model.Address;
import com.niit.MyOnlineBackend.model.Cart;
import com.niit.MyOnlineBackend.model.User;
import com.niit.MyOnlineFrontend.model.RegisterModel;

@Component("registerHandler")
public class RegisterHandler 
{
	
	@Autowired 
	UserDAO userDAO;
	
	public RegisterModel init()
	{
		return new RegisterModel();
	}
	
	
	public void addUser( User user ,RegisterModel registerModel) {
		registerModel.setUser(user);
	}
	
	public void addBilling( Address billing ,RegisterModel registerModel) {
		registerModel.setBilling(billing);
	}
	
	
	public String validate(User user , MessageContext error)
	{
		if((user.getConfirmPassword() == null || user.getConfirmPassword().contentEquals("")))
		{
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("confirm password cannot be empty!")
					.build());
			return "error";
		}
		
		if(userDAO.getUserByEmail(user.getEmail()) != null)
		{
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("email already taken!")
					.build());
			return "error";
	    }
		
		if(!(user.getPassword().equals(user.getConfirmPassword())))
		{
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Password does not match confirm password!")
					.build());
			return "error";
		}
		
		return "billing";
		
	}
	
	
	public String saveAll(RegisterModel registerModel) 
	{
		User user = registerModel.getUser();
		user.setEnabled(true);
		
		if(user.getRole().contentEquals("USER"))
		{
			Cart c = new Cart();
			
			c.setUser(user);
			
			user.setCart(c);
			
		}
		
		
		userDAO.insert(user);
		
		
		
		Address billing = registerModel.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		
		userDAO.insertAddress(billing);
		
		return "success";
		
	}

}
