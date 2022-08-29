package com.backend.metaphorce.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class User implements Serializable {

	@Id
	@Column(name = "username", length = 50)
	private String username;

	@Column(name = "password", length = 500)
	private String password;

	public User() { }

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
