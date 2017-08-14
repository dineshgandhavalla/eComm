package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CartDAO;
import com.spring.model.Cart;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartDAO cartDAO;

	public boolean saveCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	public List getAllCartDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cart> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List getCartByProduct(int Productid) {
		// TODO Auto-generated method stub
		return cartDAO.getCartByProduct(Productid);
	}

}
