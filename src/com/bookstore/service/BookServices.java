package com.bookstore.service;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

import antlr.collections.List;

public class BookServices {
	 private EntityManager entityManager;
	  private BookDAO bookDAO;
	  private CategoryDAO categoryDAO;
	  private HttpServletRequest request;
	  private HttpServletResponse response;
  public BookServices(EntityManager entityManager, HttpServletRequest request,
			HttpServletResponse response) {
		super();
		this.entityManager = entityManager;
		this.request = request;
		this.response = response;
		bookDAO =new BookDAO(entityManager);
		categoryDAO=new CategoryDAO(entityManager);
	}
public void listBooks() throws ServletException, IOException{
	 java.util.List<Book> listBooks=bookDAO.listAll();
	 request.setAttribute("listBooks", listBooks);
	 
	 String listPage="book_list.jsp";
	 RequestDispatcher rd=request.getRequestDispatcher(listPage);
	 rd.forward(request, response);
			 
  }
public void showBookNewForm() throws ServletException, IOException{
	java.util.List<Category> listCategory=categoryDAO.listAll();
	request.setAttribute("listCategory", listCategory);
	 
	 String newPage="book_form.jsp";
	 RequestDispatcher rd=request.getRequestDispatcher(newPage);
	 rd.forward(request, response);
}
}
