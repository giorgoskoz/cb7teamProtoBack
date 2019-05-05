package com.klicks.klicks.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.klicks.klicks.entities.User;

@Entity
@Table(name = "studio-sessions")
public class StudioSessions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@JoinColumn(name = "fk_user_id", referencedColumnName = "iduser")
	@ManyToOne
	private User user;
	
	@Column(name = "date")
	private String date;

	public StudioSessions() {
	}

	public StudioSessions(User user, String date) {
		this.user = user;
		this.date = date;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
