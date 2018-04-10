package com.devfull.springdata.api.entity;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.devfull.springdata.api.enums.ProfileEnum;

@Document
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Indexed(unique = true)
	@NotEmpty(message = "Informe um email")
	@Email(message = "Email inválido")
	private String email;

	@NotEmpty(message = "Informe uma senha")
	@Size(min = 6)
	private String password;

	private ProfileEnum profile;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public ProfileEnum getProfile() {
		return profile;
	}

	public void setProfile(ProfileEnum profile) {
		this.profile = profile;
	}
}
