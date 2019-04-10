package com.bookstore.entity;
// Generated Mar 4, 2019 4:16:53 AM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "category", catalog = "bookstoredb")

@NamedQueries({
	@NamedQuery(name="Category.findAll",query="SELECT c FROM Category c ORDER BY c.name"),
	@NamedQuery(name="Category.countAll" ,query="SELECT COUNT(*)FROM Category"),
    @NamedQuery(name="Category.findByName",query="SELECT c FROM Category c WHERE c.name=:name")
 })

public class Category implements java.io.Serializable {

	
   
	
	private long categoryId;
	private String name;
	private Set<Book> books = new HashSet<Book>(0);
	

	
	  public Category(){
	    	 
	     }
	  public Category(String name) {
		    
			this.name = name;
		
		
		}
	public Category(String name,  long categoryId) {
		this.categoryId=categoryId;
		this.name=name;
		
	}
	
	
	@Id
	

	   @GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name = "category_id", unique = true, nullable = false)
	public long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

		@Column(name = "name", nullable = false, length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	public Set<Book> getBooks(  ) {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
