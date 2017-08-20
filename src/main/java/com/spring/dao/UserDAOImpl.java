package com.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Cart;
import com.spring.model.Users;


@Repository
public class UserDAOImpl implements UserDAO {

	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory; 
		
	}
	
	@Transactional
	public boolean saveUser(Users users) {
		
		
		sessionFactory.getCurrentSession().saveOrUpdate(users);
		
		return true;
	}

public List<Users> list() {
		
		return null;
	}

@Transactional
public Users getUser(int userid) {
	// TODO Auto-generated method stub
	return (Users)sessionFactory.getCurrentSession().get(Users.class, userid);
}
@Transactional
public List getAllUser() {
	// TODO Auto-generated method stub
	return sessionFactory.getCurrentSession().createQuery("from Users").list();
}


	public void removeUserById(int user_id) {
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Transactional
	public Users get(String email) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Users.class);
		c.add(Restrictions.eq("email", email));

		@SuppressWarnings("unchecked")
		List<Users> listUser = (List<Users>) c.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		} else {
			return null;
		}

	}

/*@Transactional
	public List<Users> getUserById(int user_id) {
		// TODO Auto-generated method stub
	@SuppressWarnings("unchecked")
	List<Users> listUsers= (List<Users>) sessionFactory.getCurrentSession()
			.createQuery("from Users where id="+user_id).list();
		return listUsers;	}*/
	
	
	@SuppressWarnings("unchecked")
	@Transactional	
	public List<Users> getUserById(int userid) {
			
			// TODO Auto-generated method stub
			return (List<Users>) sessionFactory.getCurrentSession().createQuery("from Users where id="+userid).list();
		}


}
