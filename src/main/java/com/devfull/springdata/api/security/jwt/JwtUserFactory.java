package com.devfull.springdata.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.devfull.springdata.api.entity.Usuario;
import com.devfull.springdata.api.enums.TipoEnum;

public class JwtUserFactory {

	private JwtUserFactory() {
		
	}
	
	public static JwtUsuario create(Usuario usuario) {
		return new JwtUsuario(usuario.getId(), usuario.getEmail(), usuario.getSenha(), mapToGrantedAuthorities(usuario.getTipo()));
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(TipoEnum tipoEnum){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(tipoEnum.toString()));
		return authorities;
	}
}
