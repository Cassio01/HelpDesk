package com.devfull.springdata.api.security.jwt;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_CREATED = "created";
	static final String CLAIM_KEY_EXPIRED = "exp";

	@Value("${jwt.secret}")
	private String secret;

	@Value("${jwt.expiration}")
	private String expiration;

	public String getNomeUsuarioFromToken(String token) {
		String nomeUsuario;
		try {
			final Claims claims = getClaimsFromToken(token);
			nomeUsuario = claims.getSubject();
		} catch (Exception e) {
			nomeUsuario = null;
		}
		return nomeUsuario;
	}

	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(token)
					.getBody();
		} catch (Exception e) {
			claims = null;
		}
		
		return claims;
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
}
