package com.devfull.springdata.api.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.devfull.springdata.api.enums.TipoEnum;

@Document
public class Usuario {

	@Id
	private String id;

	@Indexed(unique = true)
	@NotEmpty(message = "Informe um email")
	@Email(message = "Email inválido")
	private String email;

	@NotEmpty(message = "Informe uma senha")
	@Size(min = 6)
	private String senha;

	private TipoEnum tipo;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

}
