package com.klicks.klicks.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.klicks.klicks.entities.Token;
import com.klicks.klicks.entities.Role;


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iduser")
	private int id;
	
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@JoinColumn(name = "fk_role_id", referencedColumnName = "id")
	@ManyToOne
	private Role role;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email")
	private String email;
	
	@Column(name = "piclink")
	private String photoLink;
	
	@Column(name = "random")
	private String random;
	
	@OneToMany
	@JoinColumn(name = "fk_user_id", referencedColumnName = "iduser")
	@JsonIgnore
	private List<Token> tokens;
	
	@OneToMany
	@JoinColumn(name = "fk_user_id",referencedColumnName = "iduser")
	@JsonIgnore
	private List<StudioSessions> studioSessions;

	public User() {
	}

	public User(String username, String password, Role role, String firstName,
			String lastName, String email) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String retrievePassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}

	public String retrieveRandom() {
		return random;
	}

	public void setRandom(String random) {
		this.random = random;
	}
	
	
	
}
