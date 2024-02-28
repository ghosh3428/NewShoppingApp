package com.niit.MyOnlineFrontend.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.niit.MyOnlineBackend.model.Product;

public class ProductValidator implements Validator
{

	@Override
	public boolean supports(Class<?> productClass) 
	{
		return Product.class.equals(productClass);
	}
	
	
	@Override
	public void validate(Object target, Errors errors) 
	{
		
		
		Product product = (Product)target;
		
		if(product.getFile() == null || product.getFile().getOriginalFilename().equals(""))
		{
			errors.rejectValue("file", null, "Please select a file to upload!");
			return;
		}
		
		if(! (product.getFile().getContentType().equals("image/jpeg") || 
				product.getFile().getContentType().equals("image/png")) ||
				product.getFile().getContentType().equals("image/gif")
			 )
		{
			errors.rejectValue("file", null, "Please select an image file to upload!");
			return;
		}
		
		if( product.getDescription().length()>254 )
		{
			errors.rejectValue("description", null, "Description cannot be more than 255 Characters!");
			return;
		}
		
		if( product.getDescription().length()<10 )
		{
			errors.rejectValue("description", null, "Description must be atleast 10 characters!");
			return;
		}
		
		
	}
	

}
