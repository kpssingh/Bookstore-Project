package com.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="User.findAll",query="SELECT u FROM User u ORDER BY u.fullName"),
	@NamedQuery(name="User.findByEmail",query="SELECT u FROM User u WHERE u.email=:email"),

    @NamedQuery(name="User.countAll", query="SELECT Count(*) FROM User u"),
	  @NamedQuery(name="User.checkLogin", query="SELECT u FROM User u WHERE u.email= :email AND password= :password")
})
public class User {
	private Integer userId;
	private String password; 
	private String fullName;
	private String email;
	
   public User() {
	
	}
   
   public User( Integer userId,String email, String fullName, String password) {
	this(email,fullName,password);
		this.userId=userId;
		this.fullName = fullName;
		this.email = email;
	}


public User(String email, String fullName, String password) {
		super();
		this.password = password;
		this.fullName = fullName;
		this.email = email;
	}

@Column(name="user_id")
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    @Column(name="full_name")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
