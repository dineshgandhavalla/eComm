package com.spring.service;

import java.util.List;

import com.spring.model.Cart;

public interface CartService {
	/*public boolean saveCart(Cart cart);
	//public Cart getCart(int Cartid);
	public List getAllCartDetails();
	public List<Cart> list() ;
	public List getCartByProduct(int Productid);
*/
	
public boolean saveProductToCart(Cart cart);
	
	public Cart getitem(int prodId,int userId);
}
