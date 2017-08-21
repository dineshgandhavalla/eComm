package com.spring.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dao.CartDAO;
import com.spring.dao.ProductDAO;
import com.spring.model.Cart;
import com.spring.model.Product;
import com.spring.service.ProductService;

@Controller
public class CartController {

	@Autowired
	CartDAO cartDAO;
	 
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	ProductService productService;
	
	
	Cart cart;

	
	
    @RequestMapping(value="addToCart/{id}")
    public String addProductToCart(@PathVariable("id") int id, HttpSession session,Model model)
    {
    	int userId = (Integer) session.getAttribute("userid");
    	int q=1;
    	if (cartDAO.getitem(id, userId) != null) {
			Cart item = cartDAO.getitem(id, userId);
			item.setQuantity(item.getQuantity() + q);
			Product p = productDAO.getProduct(id);
			System.out.println(item);
			item.setProductprice(p.getPrice());
			model.addAttribute("message", p.getProduct_name() +"is already exist");
			item.setSubTotal(item.getProductprice() + (q*p.getPrice()));
			cartDAO.saveProductToCart(item);
			return "ProductList";
		} else {
			Cart item = new Cart();
			Product p = productDAO.getProduct(id);
			item.setProductid(p.getId());
			item.setProductname(p.getProduct_name());
			item.setUserid(userId);
			item.setQuantity(q);
			item.setSubTotal(q * p.getPrice());
			item.setProductprice(p.getPrice());
			cartDAO.saveProductToCart(item);
			return "redirect:/";
		}
    
    	
    	
    }

	@RequestMapping("/cart")
    public String CartDetails(HttpSession session,Model model)   {
		Cart cd = new Cart();
		int userId = (Integer) session.getAttribute("userid");
	model.addAttribute("userid", userId);
		model.addAttribute("cartList", cartDAO.getCartByUser(userId));
		return "CartDetails";
    	
    }
	
	@RequestMapping(value="cart.do/{id}", method=RequestMethod.POST)
	public String CartOperations(@PathVariable("id") int id , @RequestParam String action,@RequestParam ("quantity") int qty, Model model){
		
		
		Cart cartResult = new Cart();
		if(action.equals("Delete")){
			cartDAO.deleteCart(id);
			cartResult = new Cart();
		}
		if(action.equals("Edit")){
			Cart cart = cartDAO.getCart(id);
			Product p = productDAO.getProduct(cart.getProductid());
			cart.setQuantity(qty);
			cart.setSubTotal(qty * p.getPrice());
			cartDAO.saveProductToCart(cart);
			
		}
		model.addAttribute("cartList", cartResult);
		return "redirect:/cart.do"+id;
	}
	
	}
