package com.spring.dao;

import java.util.List;

import com.spring.model.Cart;

public interface CheckOutDAO {

	public List<Cart> getTotal(int uid);
}
