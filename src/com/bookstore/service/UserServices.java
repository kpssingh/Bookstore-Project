package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.User;

public class UserServices {
 private UserDAO userDAO;
  private EntityManager entityManager;
  private HttpServletRequest request;
  private HttpServletResponse response;
 public UserServices( EntityManager entityManager,HttpServletRequest request,HttpServletResponse response){
	 this.request=request;
	 this.response=response;
	 this.entityManager=entityManager;
	 userDAO=new UserDAO(entityManager);
 }
 public void listUser()throws ServletException,IOException{
 listUser(null);
 }
 public void listUser(String message) throws ServletException,IOException{
	 List<User> listUser=userDAO.listAll();
	 
		request.setAttribute("listUser", listUser);
		if(message!=null){
		request.setAttribute("message", message);
		}
		String listPage="user_list.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(listPage);
		rd.forward(request, response);
	
 }
public void createUser() throws ServletException, IOException{
	String email=request.getParameter("email");
	String fullName=request.getParameter("fullname");
	String password=request.getParameter("password");
	
	User existUser=userDAO.findByEmail(email);	
	
	if(existUser!=null){
	   String message="could not create user .A User  with email "  +email+ " already exist";
	   request.setAttribute("message", message);
	   RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
	   rd.forward(request, response);
	}
	else{
   User newUser=new User(email,fullName,password);
   userDAO.create(newUser);
   listUser("New User created successfully");
	}
}
public void editUser() throws ServletException, IOException {
	   int userId=Integer.parseInt(request.getParameter("id"));
	User user=userDAO.get(userId);

	String editpage="user_form.jsp";
	request.setAttribute("user", user);
	RequestDispatcher rd=request.getRequestDispatcher(editpage);
	rd.forward(request, response);
}
public void updateUser() throws ServletException, IOException {
	int userId=Integer.parseInt(request.getParameter("userId"));
          String email=request.getParameter("email");  
          String password=request.getParameter("password");  	
          String fullName=request.getParameter("fullname");  
          
          User userById=userDAO.get(userId);
          User userByEmail=userDAO.findByEmail(email);
          
          if(userByEmail!=null && userByEmail.getUserId()!=userById.getUserId()){
        	  String message="could not Update User  with email       "+email+" already Exist";
        	  request.setAttribute("message", message);
        	  RequestDispatcher rd=request.getRequestDispatcher("message.jsp");
        		rd.forward(request, response);
          }
          else{
        	  
          }
          
          System.out.println(userId+","+email+","+fullName+","+password);
          
          User user=new User(userId,email,fullName,password);
          userDAO.update(user);
          
          String message="User Has been updated successfully";
          listUser(message);
}
public void deleteUser() throws ServletException, IOException {
	int userId=Integer.parseInt(request.getParameter("id"));
	userDAO.delete(userId);
	
	String message="User has Been deleted successfully";
	listUser(message);
	
}
public void login() throws ServletException, IOException{
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	System.out.println(email);
	@SuppressWarnings("unused") 
	boolean loginResult=userDAO.checkLogin(email, password);
	if(loginResult){
		request.getSession().setAttribute("useremail", email);
		RequestDispatcher rd=request.getRequestDispatcher("/admin/");
		rd.forward(request, response);
	}
	else{
         String message="Login failed";
         request.setAttribute("message", message);
         RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
 		rd.forward(request, response);
         
	}
}
}
