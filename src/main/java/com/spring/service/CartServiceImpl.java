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

	

	public boolean saveProductToCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDAO.saveProductToCart(cart);
	}

	public Cart getitem(int prodId, int userId) {
		// TODO Auto-generated method stub
		return cartDAO.getitem(prodId, userId);
	}

}
