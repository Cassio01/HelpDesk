package com.devfull.springdata.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.devfull.springdata.api.entity.User;
import com.devfull.springdata.api.enums.ProfileEnum;

public class JwtUserFactory {

	private JwtUserFactory() {
		
	}
	public static JwtUser create(User usuario) {
		return new JwtUser(usuario.getId(), usuario.getEmail(), usuario.getPassword(),
				mapToGrantedAuthorities(usuario.getProfile()));
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum tipoEnum){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(tipoEnum.toString()));
		return authorities;
	}
}
