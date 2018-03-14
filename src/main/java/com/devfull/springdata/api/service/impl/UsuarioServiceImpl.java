package com.devfull.springdata.api.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devfull.springdata.api.entity.Usuario;
import com.devfull.springdata.api.repository.UsuarioRepository;
import com.devfull.springdata.api.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario findByEmail(String email) {
		return this.usuarioRepository.findByEmail(email);
	}

	@Override
	public Usuario createOrUpdate(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Usuario findById(String id) {
		return null;//this.usuarioRepository.findOne(id);  
	}

	@Override
	public Page<Usuario> findAll(int page, int count) {
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(page, count);
		return this.usuarioRepository.findAll(pageable);
	}

	@Override
	public void delete(String id) {
//		this.usuarioRepository.delete(id);
	}

}
