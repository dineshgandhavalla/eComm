
package com.spring.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.model.Product;
import com.spring.model.Users;
import com.spring.dao.CategoryDAO;
import com.spring.dao.ProductDAO;
import com.spring.dao.SupplierDAO;
import com.spring.dao.UserDAO;

@Controller
public class RegistrationController {


	@Autowired
	ProductDAO productDAO;

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/")
	public String landPage(@ModelAttribute("Users")Users users,BindingResult result,Model model)
	{
		return "index";
		
	}
	
	
    @RequestMapping("/login")
	public String login(@RequestParam(value="error",required=false) String error,
    		@RequestParam(value="logout",required=false) String logout,
    		Model model){
    	if(error!=null)
    		model.addAttribute("error","Invalid Username and Password.. Please enter valid username and password");
    	if(logout!=null)
    		model.addAttribute("logout","Loggedout successfully");
    		model.addAttribute("LoginPageClicked", true);
    	return "login";
    }
	 

    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/login_session_attributes")
	public String login_session_attributes(HttpSession session,Model model) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Users user = userDAO.get(email);
		session.setAttribute("userid", user.getId());
		session.setAttribute("name", user.getEmail());
		session.setAttribute("LoggedIn", "true");

		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
		.getAuthentication().getAuthorities();
		String role="ROLE_USER";
		for (GrantedAuthority authority : authorities) 
		{
		  
		     if (authority.getAuthority().equals(role)) 
		     {
		    	 session.setAttribute("UserLoggedIn", "true");
		    	 /*session.setAttribute("cartsize",cartDAO.cartsize((Integer)session.getAttribute("userid")));*/
		    	 return "redirect:/";
		     }
		     else 
		     {
		    	 session.setAttribute("Administrator", "true");
		    	 model.addAttribute("product",  new Product());
		    	 model.addAttribute("ProductPageClicked", "true");
		    	 model.addAttribute("supplierList",supplierDAO.list());
		    	 model.addAttribute("categoryList",categoryDAO.list());
			 return "Admin";
		     }
	}
		return "index";
	
	}
    
    
	
	@RequestMapping(value="/signup")
	public String registrationPage(Model model)
	{
		model.addAttribute("users", new Users());
		return "Signup";
		
	}
	 
	
	 
	
	@RequestMapping(value="/saveUser",method = RequestMethod.POST)
public String addUser(@ModelAttribute("users")Users users)
{
		
		users.setRole("ROLE_USER");
		users.setEnabled(true);
		userDAO.saveUser(users);
		
		return "redirect:/";
		
	}
	
	/*@RequestMapping(value = "navproducts/${id}")
	public String listCategory(Model model,@PathVariable("id") int id,RedirectAttributes attributes) {
	
		model.addAttribute("navproducts", productDAO.getProductByCategory(id));
		model.addAttribute("Clickedcatproduct", "true");
		return "catproducts";
	}*/
	

}