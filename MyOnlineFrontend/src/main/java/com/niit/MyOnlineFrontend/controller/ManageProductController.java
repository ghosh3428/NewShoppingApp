package com.niit.MyOnlineFrontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.MyOnlineBackend.DAO.CategoryDAO;
import com.niit.MyOnlineBackend.DAO.ProductDAO;
import com.niit.MyOnlineBackend.DAO.UserDAO;
import com.niit.MyOnlineBackend.model.Category;
import com.niit.MyOnlineBackend.model.Product;
import com.niit.MyOnlineBackend.model.User;
import com.niit.MyOnlineFrontend.util.ImageUploader;
import com.niit.MyOnlineFrontend.util.ProductValidator;

@Controller
@RequestMapping(value = "/manage")
public class ManageProductController {
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/show")
	public ModelAndView show(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userclickmanageproduct", true);

		if (operation != null) {
			switch (operation) {

			case "product":
				mv.addObject("message", "Product Added Successfully");
				break;
			case "productupdate":
				mv.addObject("message", "Product Updated Successfully");
				break;
			case "category":
				mv.addObject("message", "category Added Successfully");
				break;
			}
		}

		return mv;
	}

	@ModelAttribute(name = "product")
	public Product getProduct() {
		return new Product();
	}

	@ModelAttribute(name = "category")
	public Category getcategory() {
		return new Category();
	}

	@ModelAttribute(name = "categoryList")
	public List<Category> getCategoryList() {
		return categoryDAO.categoryList();
	}

	@ModelAttribute(name = "supplierList")
	public List<User> getSupplierList() {
		return userDAO.getSuppliers();
	}

	@RequestMapping(value = "/product")
	public String addproduct(@Valid @ModelAttribute("product") Product p, BindingResult results, Model model,
			HttpServletRequest request) 
	{

		new ProductValidator().validate(p,results);
		
		String message = "";
		
		if (results.hasErrors()) 
		{
			model.addAttribute("userclickmanageproduct", true);
			return "index";

		}

		if (p.getId() == 0) 
		{
			productDAO.insert(p);
			message="product";
		} 
		else
		{
			productDAO.update(p);
			message = "productupdate";
			
		}

		if (!p.getFile().getOriginalFilename().equals("")) 
		{
			ImageUploader.uploadFile(request, p.getFile(), p.getCode());
		}
		
		return "redirect:/manage/show?operation="+message;

	}

	@RequestMapping(value = "/add/category")
	public String addproduct(@ModelAttribute("category") Category c) {

		c.setActive(true);
		categoryDAO.insert(c);

		return "redirect:/manage/show?operation=category";
	}

	@RequestMapping(value = "/edit/{id}/product")
	public ModelAndView editProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userclickmanageproduct", true);
		mv.addObject("product", productDAO.getProduct(id));

		return mv;
	}

	@RequestMapping(value = "/product/{id}/activation")
	public String activateDeactivateProduct(@PathVariable("id") int id) {

		Product p = productDAO.getProduct(id);

		p.setActive(!p.isActive());

		productDAO.update(p);

		return (p.isActive() ? "Successfully Activated the product with id : " + p.getId()
				: "Successfully Deactivated the product with id : " + p.getId());
	}

}
