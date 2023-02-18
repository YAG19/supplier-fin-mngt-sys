package com.capstoneproj.supfinsys.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Userdto {
	
	@JsonProperty("username")
	private String username;

	@JsonProperty("password")
	private String password;

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
