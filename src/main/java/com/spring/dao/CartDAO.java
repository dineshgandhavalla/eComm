package com.spring.dao;

import java.util.List;

import com.spring.model.Cart;

public interface CartDAO {
	/*public boolean saveCart(Cart cart);
	//public Cart getCart(int Cartid); 
	
	public List getAllCartDetails();
	public List<Cart> list() ;
	public List getCartByProduct(int Productid);

*/

public boolean saveProductToCart(Cart cart);
	
	public Cart getitem(int prodId,int userId);

	public List<Cart> getAllCartDetails();
}
