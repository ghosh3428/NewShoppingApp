package com.niit.MyOnlineFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MyOnlineBackend.DAO.CategoryDAO;
import com.niit.MyOnlineBackend.DAO.ProductDAO;

@Controller
@RequestMapping(value="/product")
public class ProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/show/all/active/products")
	public ModelAndView showProductList()
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title","My Online Frontend - All Product");
		mv.addObject("categorylist" , categoryDAO.categoryList());
		mv.addObject("productlist" , productDAO.listActiveProducts());
		mv.addObject("userclickallproducts" , true);
		return mv;
	}
	
	@RequestMapping(value="/show/all/active/category/{id}/products")
	public ModelAndView showProductList(@PathVariable int id)
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title","My Online Frontend - All Product");
		mv.addObject("categorylist" , categoryDAO.categoryList());
		mv.addObject("category" , categoryDAO.getCategory(id));
		mv.addObject("productlist" , productDAO.listActiveProductsByCategory(id));
		mv.addObject("userclickcategoryproducts" , true);
		return mv;
	}
	
	@RequestMapping(value="/show/single/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id)
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("title","My Online Frontend - Single Product");
		mv.addObject("product" , productDAO.getProduct(id));
		mv.addObject("userclicksingleproduct" , true);
		return mv;
	}

}
