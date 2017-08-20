package com.spring.dao;

import java.util.List;

import com.spring.model.Users;

public interface UserDAO {
	 
	public boolean saveUser(Users users);
	public List<Users> list();
	  public List<Users> getUserById(int userid);
	  public void removeUserById(int user_id);
	  public Users getUser(int userid);
	  public List getAllUser();
	  public Users get(String email);
} 
