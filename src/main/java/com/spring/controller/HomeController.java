package com.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.OrderDAO;
import com.spring.model.Product;
import com.spring.service.CategoryService;
import com.spring.service.ProductService;


@Controller
public class HomeController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	OrderDAO orderDAO;
	

	@RequestMapping(value="/product{Categoryid}", method=RequestMethod.GET)
	public String categoryList(@PathVariable ("Categoryid") int Categoryid , Map<String,Object> map , Model model)
	{
		Product product = new Product();
		map.put("product", product);
		map.put("prodList", productService.getProductByCategory(Categoryid));
		map.put("categoryList",categoryService.getAllCategory());

		return "ProductList";
	}

	@RequestMapping(value="/myorders")
	public String myOrders(Model model,HttpSession session)
	{
		/*model.addAttribute("users", new Users());*/
		int userId = (Integer) session.getAttribute("userid");
		
		model.addAttribute("od", orderDAO.getOrderDetailsByUser(userId));
				
		model.addAttribute("total",orderDAO.getTotal(userId));
		
		return "myorders";
		
	}
}

