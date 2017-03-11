package com.devops.projectone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	
	//define 3 methods
	
	
	
	@RequestMapping("/manage_categories")
	public ModelAndView manageCategories()
	{
		System.out.println("manageCategories");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedCategories", "true");
		
		//get the categories from db.
		
		return mv;
		
	}
	
	@RequestMapping("/manage_products")
	public ModelAndView manageProducts()
	{
		System.out.println("manageProducts");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedProducts", "true");
		
		//get the categories from db.
		
		return mv;
		
	}
	
	@RequestMapping("/manage_suppliers")
	public ModelAndView manageSupplier()
	{
		System.out.println("manageSupplier");
		ModelAndView mv = new ModelAndView("/Admin/AdminHome");
		mv.addObject("isUserClickedSuppliers", "true");
		
		//get the categories from db.
		
		return mv;
		
	}

}
