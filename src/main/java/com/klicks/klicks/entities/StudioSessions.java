package com.klicks.klicks.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "studio_sessions")
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
	
	@ManyToMany
	@JoinTable(name = "session_gear", joinColumns = @JoinColumn(name = "fk_gear_id"), inverseJoinColumns = @JoinColumn(name = "fk_session_id"))
	List<ExtraGear> extras;
	
	
	@Column(name = "total_price")
	private double totalPrice;

	public StudioSessions() {
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


	public List<ExtraGear> getExtras() {
		return extras;
	}


	public void setExtras(List<ExtraGear> extras) {
		this.extras = extras;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
