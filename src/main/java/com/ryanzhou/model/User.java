package com.ryanzhou.model;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Comparator<User>{
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
	public int compare(User o1, User o2) {
		if(o1.getId().equals(o2.getId()) && o1.getUserName().equals(o2.getUserName())) {
			return 0;
		}
		return -1;
	}
	

}
