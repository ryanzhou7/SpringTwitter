package com.ryanzhou.model;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	private String userName;

	protected User() {} //needed for JPA
	
	public User(String name) {
		this.userName = name;
	}

	public Long getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "{id:"+ getId() + ", " + "username:" + getUserName()+"}";
	}
	
	@Override
	public boolean equals(Object obj) {
		User other = (User)obj;
		if( this.id.equals(other.getId()) 
				&& this.getUserName().equals(other.getUserName()) )
			return true;
		return false;
	}
	
}
