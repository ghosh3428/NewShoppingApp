package com.niit.MyOnlineFrontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MyOnlineBackend.DAO.CategoryDAO;

@Controller
public class FrontController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title","My Online Frontend");
		mv.addObject("categorylist" , categoryDAO.categoryList());
		mv.addObject("userclickhome" , true);
		return mv;
	}
	
	@RequestMapping(value= "/login")
	public ModelAndView mylogin(@RequestParam(name="error", required = false)	String error,@RequestParam(name="logout", required = false)	String logout)
	{
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("title","My Online Frontend - LOGIN");
		
		if(error!= null) 
		{
			mv.addObject("message", "Username and Password is invalid!");
		}
		
		if(logout!= null) 
		{
			mv.addObject("logout", "You have successfully logged out.");
		}
		return mv;
	}
	
	
	@RequestMapping(value = "/custom-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    
	    return "redirect:/login?logout";
	}
	

}
