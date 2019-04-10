package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.User;

public class UserDAOTest extends BaseDAOTest{
	private static UserDAO userDAO;
	@BeforeClass
	public static void setUpClass() throws Exception{
		BaseDAOTest.setUpBeforeClass();
		 userDAO=new UserDAO(entityManager);
	}

	@Test
	public void testCreateUser() {
		User user1=new User();
		user1.setEmail("jo@gmail");
		user1.setFullName("john smith");
		user1.setPassword("johnny");
	
		user1=userDAO.create(user1);
	
		assertTrue(user1.getUserId() >0);
		
	}
	@Test(expected=PersistenceException.class)
	public void testCreateUserFieldsNotSet(){
		User user1=new User();

		user1=userDAO.create(user1);
		
		assertTrue(user1.getUserId() >0);
		
	}
	@Test
	public void testUpdateUsers(){
		User user=new User();
		user.setUserId(1);
		user.setEmail("adit@gmail");
		user.setFullName("aditya pratap");
		user.setPassword("mysecret");
		
		user=userDAO.update(user);
		String expected="mysecret";
		String actual=user.getPassword();
		assertEquals(expected,actual);
	}
	@Test
	public void testGetUserFound(){
		Integer userId=1;
	
		User user=userDAO.get(userId);
		if(user!=null){
		System.out.println(user.getEmail());
		}
		assertNotNull(user);
	}
	@Test
	public void testGetUserNotFound(){
		Integer userId=99;
		User user=userDAO.get(userId);
		assertNull(user);
	}
	@AfterClass
	public  static void tearDownClass() throws Exception{
		BaseDAOTest.tearDownAfterClass();
	}
	@Test
	public void testDeleteUser(){
		Integer userId=5;
		userDAO.delete(userId);
		
		User user=userDAO.get(userId);
		assertNull(user);
	}
	@Test(expected=EntityNotFoundException.class)
	public void testDeleteNonExistUser(){
		Integer userId=55;
		userDAO.delete(userId);
	}
	@Test
	public void testListAll(){
		List<User>listUser=userDAO.listAll();
		for(User user:listUser){
			System.out.println(user.getEmail());
		}
		assertTrue(listUser.size()>0);
	}
	@Test
	public void testCount(){
		long totalUser=userDAO.count();
		assertEquals(23,totalUser);
	}
	@Test
	public void testCheckLoginSuccess(){
		String email="aditya@";
		String password="singh";
		boolean loginResult=userDAO.checkLogin(email, password);
		assertTrue(loginResult);
	}
	@Test
	public void testFindByEmail(){
		String email="aditya@";
		User user=userDAO.findByEmail(email);
		assertNotNull(user);
	}

}
