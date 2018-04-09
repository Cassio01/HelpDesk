package com.devfull.springdata.api.security.model;

import com.devfull.springdata.api.entity.User;

public class CurrentUser {

	private String token;
	private User user;

	public CurrentUser(String token, User usuario) {
		this.token = token;
		this.user = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
