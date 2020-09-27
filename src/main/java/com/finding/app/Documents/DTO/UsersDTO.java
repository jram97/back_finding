package com.finding.app.Documents.DTO;

import java.io.Serializable;
import java.util.Set;

public class UsersDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nameComplete;

	private String username;

	private String email;

	private String password;

	private String photo;

	private String country;

	private Set<String> roles;

	public String getNameComplete() {
		return nameComplete;
	}

	public void setNameComplete(String nameComplete) {
		this.nameComplete = nameComplete;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}