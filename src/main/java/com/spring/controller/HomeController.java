package com.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.CartDAO;
import com.spring.dao.CartDAOImpl;
import com.spring.dao.ProductDAO;
import com.spring.model.Cart;
import com.spring.model.Product;
import com.spring.service.CartService;
import com.spring.service.CategoryService;
import com.spring.service.ProductService;


@Controller
public class HomeController {
 
	@Autowired
	ProductService productService;
	/*@Autowired
	CartDAO cartDAO;
	
	@Autowired
	SessionFactory 	sessionFactory;*/
	
	@RequestMapping(value="/product{Categoryid}", method=RequestMethod.GET)
	public String categoryList(@PathVariable ("Categoryid") int Categoryid , Map<String,Object> map , Model model)
	{
		Product product = new Product();
		map.put("product", product);
		map.put("prodList", productService.getProductByCategory(Categoryid));
		return "ProductList";
	}
	
/*	@RequestMapping(value=".../addtoCart/{Productid}/{price}", method=RequestMethod.POST)
	public String addCart(@PathVariable("price") int price, @PathVariable("Productid") int Productid, Map<String,Object> map , Model model )
	{
		Cart cart= new Cart();
		cart.setPid(Productid);
		map.put("cart", cart);
		cart.setProdprice(price);
		cartDAO.saveCart(cart);
			
	return "redirect:/";
		
	}
		
*/}


