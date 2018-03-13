package com.devfull.springdata.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devfull.springdata.api.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	
	public Usuario findByEmail(String email);

}
