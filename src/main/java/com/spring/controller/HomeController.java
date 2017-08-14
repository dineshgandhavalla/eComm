package com.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.CartDAO;
import com.spring.dao.CartDAOImpl;
import com.spring.model.Cart;
import com.spring.model.Product;
import com.spring.service.CartService;
import com.spring.service.CategoryService;
import com.spring.service.ProductService;


@Controller
public class HomeController {

	@Autowired
	ProductService productService;
	@Autowired
	CartDAO cartDAO;
	
	@RequestMapping(value="/product{Categoryid}", method=RequestMethod.GET)
	public String categoryList(@PathVariable ("Categoryid") int Categoryid , Map<String,Object> map , Model model)
	{
		Product product = new Product();
		map.put("product", product);
		map.put("prodList", productService.getProductByCategory(Categoryid));
		return "ProductList";
	}
	
	@RequestMapping(value=".../addtoCart/{Productid}", method=RequestMethod.POST)
	public String addCart(@PathVariable("Productid") int Productid, Map<String,Object> map , Model model)
	{
		Cart cart= new Cart();
		cart.setPid(Productid);
		cartDAO.saveCart(cart);
		
		Product product = new Product();
		map.put("cart", cart);
		/*cart.setProdprice(cartDAO.getProdPrice(Productid));
		*//*map.put("cartList", cartService.getCartByProduct(Productid));
		*/
	return "ProductList";
		
	}
	
}
