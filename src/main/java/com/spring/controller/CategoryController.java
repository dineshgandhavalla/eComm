package com.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dao.CategoryDAO;
import com.spring.dao.ProductDAO;
import com.spring.dao.SupplierDAO;
import com.spring.dao.UserDAO;
import com.spring.model.Category;
import com.spring.model.Product;
import com.spring.model.Supplier;
import com.spring.model.Users;
import com.spring.service.CategoryService;
 

@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;
	
	
	@RequestMapping(value="/admin")
	public String Admin(Model model)
	{
		model.addAttribute("admin");
		return "Admin";
		
	}

/*	@RequestMapping(value="/category")
	public String categoryPage(Model model)
	{
		model.addAttribute("category", new Category());
		return "Category";
		
	}
	
	/*@RequestMapping(value="/saveCategory",method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category")Category category)
	{
			
			
			categoryDAO.saveCategory(category);
			
			return "redirect:/";
			
		}
	*/
//
	@Autowired
	private CategoryService categoryService;
	
	   @RequestMapping(value="/category")
		public String setupForm(Map<String, Object> map,Model model)
		{
			Category category = new Category();
			map.put("category", category);
			map.put("categoryList",categoryService.getAllCategory());
			return "Category";
		}
	
	
	@RequestMapping(value="/category.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Category category, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Category categoryResult = new Category();
			//only in Java7 you can put String in switch
		 if (action.equals("Add"))
		 {
			categoryService.add(category);
			categoryResult = category;
			
		 }
		 if (action.equals("Edit"))
				 {
			categoryService.edit(category);
			categoryResult = category;
			
		 }
		 if (action.equals("Delete")){
			categoryService.delete(category.getId());
			categoryResult = new Category();
			
		 }
		 if (action.equals("Search")){
			Category searchedCategory = categoryService.getCategory(category.getId());
			categoryResult = searchedCategory!=null ? searchedCategory : new Category();
			
		}
		map.put("category", categoryResult);
		map.put("categoryList", categoryService.getAllCategory());
		return "Category";
	}
	
	
	}




