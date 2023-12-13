package com.niit.MyOnlineFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MyOnlineBackend.DAO.CategoryDAO;

@Controller
@RequestMapping(value="/product")
public class ProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/show/all/active/product")
	public ModelAndView showProductList()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title","My Online Frontend - All Product");
		mv.addObject("categorylist" , categoryDAO.categoryList());
		mv.addObject("userclickallproduct" , true);
		return mv;
	}

}
