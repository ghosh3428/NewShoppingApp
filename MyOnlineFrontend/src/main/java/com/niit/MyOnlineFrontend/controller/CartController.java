package com.niit.MyOnlineFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MyOnlineFrontend.Service.CartLinesService;

@Controller
@RequestMapping(value="/cart")
public class CartController
{
	@Autowired
	private CartLinesService cartlinesService;

	@RequestMapping(value="/show")
	public ModelAndView showCart()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("userclickshowcart",true);
		mv.addObject("title" , "Online Shopping - User Cart");
		
		mv.addObject("cartlines" , cartlinesService.getCartLines() );
		
		return mv;
	}

}
