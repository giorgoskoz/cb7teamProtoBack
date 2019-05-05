package com.klicks.klicks.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "extra_gear")
public class ExtraGear {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idextra_gear")
	private int id;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "picklink")
	private String photoLink;
	
	@ManyToMany(mappedBy = "extras")
	@JsonIgnore
	List<StudioSessions> sessions;

	
	public ExtraGear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExtraGear(double price, String description, String photoLink) {
		super();
		this.price = price;
		this.description = description;
		this.photoLink = photoLink;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}

	public List<StudioSessions> getSessions() {
		return sessions;
	}

	public void setSessions(List<StudioSessions> sessions) {
		this.sessions = sessions;
	}
	
	
}
