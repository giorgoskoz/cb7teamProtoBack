package com.klicks.klicks.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "token")
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "fk-user-id", referencedColumnName = "id")
	private User user;
	
	@Column(name = "token")
	private String alphanumeric;
	
	public Token() {
	}

	public Token(String alphanumeric, User user) {
		this.alphanumeric = alphanumeric;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAlphanumeric() {
		return alphanumeric;
	}

	public void setAlphanumeric(String alphanumeric) {
		this.alphanumeric = alphanumeric;
	}
	
	
}
