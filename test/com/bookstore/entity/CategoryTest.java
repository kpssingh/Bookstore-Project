package com.bookstore.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CategoryTest {

	public static void main(String[] args) {
	Category newCat=new Category("Advance java");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(newCat);
		entityManager.getTransaction().commit();
		entityManager.clear();
		System.out.println("A category object was persisted");

	}

}
