package com.ryanzhou.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tweet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String message;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="post_id", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
	
	protected Tweet() {}
	public Tweet(User user, String message) {}
	public String getMessage() {
		return message;
	}
	public User getUser() {
		return user;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
