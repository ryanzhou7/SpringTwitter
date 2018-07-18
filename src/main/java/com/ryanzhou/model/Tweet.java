package com.ryanzhou.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Tweet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database will generate the id, given id will be overwritten", required=false)
	private Long id;
	private String message;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;

	protected Tweet() {
	}

	public Tweet(User user, String message) {
		this.user = user;
		this.message = message;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isEqualTo(Tweet other) {
		return (this.message.equals(other.getMessage()) && this.id.equals(other.getId()));
	}

	@Override
	public String toString() {
		return String.format("{id:%s, message:%s}", id, message);
	}
}
