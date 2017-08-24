package com.spring.controller;

import java.util.List;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import com.spring.model.Users;

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
	
	@RequestMapping("/{userid}")
	public String CheckoutPage(@ModelAttribute ("card") Card card,@PathVariable("userid") int userid, Model model){
		model.addAttribute("total", checkOutDAO.getTotal(userid));
		return "CheckOut";
		
	}

		
	@RequestMapping(value="/invoice",method=RequestMethod.POST)
	public String InvoicePage(@ModelAttribute ("card") Card card,HttpSession session, Model model){
		int charges=99;
		int userId = (Integer) session.getAttribute("userid");
		card.setCard_userid(userId);
		cardDAO.saveCard(card);
	
		model.addAttribute("user", userDAO.getUser(userId));
    	model.addAttribute("cd", cartDAO.getCartByUser(userId));
    	model.addAttribute("total",checkOutDAO.getTotal(userId));
		model.addAttribute("cod", charges);
		
		return "Invoice";
	
	
	}
	
	
}
