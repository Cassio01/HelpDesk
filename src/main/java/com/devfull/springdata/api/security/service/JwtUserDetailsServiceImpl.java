package com.devfull.springdata.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devfull.springdata.api.entity.User;
import com.devfull.springdata.api.security.jwt.JwtUserFactory;
import com.devfull.springdata.api.service.UserService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User usuario = usuarioService.findByEmail(email);
		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("Não foi encontrado o usuário '%s'.", email));
		} else {
			return JwtUserFactory.create(usuario);
		}
	}

}
