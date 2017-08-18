package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.CardDAO;
import com.spring.dao.CartDAO;
import com.spring.dao.CheckOutDAO;
import com.spring.dao.UserDAO;
import com.spring.model.Card;
import com.spring.model.Cart;

@Controller
public class CheckOutController {

	@Autowired
	CheckOutDAO checkOutDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	CardDAO cardDAO;
	
	@RequestMapping("/cardPay/{userid}")
	public String CheckoutPage(@PathVariable("userid") int userid, Model model){
		/*Cart cart = new Cart();
		model.addAttribute("cart", cart);*/
		model.addAttribute("total", checkOutDAO.getTotal(userid));
		
		return "CheckOut";
		
	}
	/*
	@RequestMapping(value="/invoice", method = RequestMethod.POST)
	public String InvoicePage(HttpSession session, Model model){
		int userId = (Integer) session.getAttribute("userid");
    	model.addAttribute("user", userDAO.getUserById(userId));
    	model.addAttribute("cd", cartDAO.getCart(userId));
    	model.addAttribute("total", checkOutDAO.getTotal(userId));
		
		return "Invoice";
		
		
	}*/
	
	@RequestMapping(value="/invoice",method=RequestMethod.POST)
	public String InvoicePage(@ModelAttribute ("cardPay") Card cardPay,HttpSession session, Model model){
		//Card cardPay = new Card();
		
		cardDAO.saveCard(cardPay);
		
		return "redirect:/cardPay";
	
	
	}
	
}
