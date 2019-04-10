package com.bookstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.bookstore.entity.User;

public class UserDAO extends JpaDAO<User> implements GenericDAO<User> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}
  public User create(User user){
	  return super.create(user);
  }
	@Override
	public User update(User user) {

		return super.update(user);
	}

	@Override
	public User get(Object userId) {
		return super.find(User.class, userId);
	
	}
	public User findByEmail(String email) {
		List<User> listUser= super.findWithNamedQuery("User.findByEmail","email",email);
		
		if(listUser !=null && listUser.size()>0){
			return listUser.get(0);
		}
		return null;
	
	}
	public boolean checkLogin(String email,String password){
		Map<String,Object>parameters=new HashMap<>();
		parameters.put("email",email);
		parameters.put("password",password);
		
		List<User> listUsers=super.findWithNamedQuery("User.checkLogin", parameters);
		if(listUsers.size()==1){
			return true;
		}
		return false;
	}
	
	@Override
	public void delete(Object userId) {
     super.delete(User.class,userId);		
	}

	@Override
	public List<User> listAll() {
		
		return super.findWithNamedQuery("User.findAll");
	}

	@Override
	public long count() {
       return super.countWithNameQuery("User.countAll");
      
	
	}

	


}
	