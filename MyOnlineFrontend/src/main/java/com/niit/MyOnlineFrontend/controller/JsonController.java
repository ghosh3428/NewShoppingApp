package com.niit.MyOnlineFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MyOnlineBackend.DAO.ProductDAO;
import com.niit.MyOnlineBackend.model.Product;

@RequestMapping(value = "/json")
@Controller
public class JsonController {
	@Autowired
	ProductDAO productDAO;

	@RequestMapping(value = "/show/all/active/products")
	@ResponseBody
	public List<Product> allActiveProduct() {
		ModelAndView mv = new ModelAndView("index");

		return productDAO.listActiveProducts();
	}

	@RequestMapping(value = "/show/all/active/category/{id}/products")
	@ResponseBody
	public List<Product> showProductList(@PathVariable int id) {

		return productDAO.listActiveProductsByCategory(id);

	}
	
	@RequestMapping(value = "/show/all/products")
	@ResponseBody
	public List<Product> allProduct() 
	{
		return productDAO.listProduct();
	}

}
