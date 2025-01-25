package com.oneplace.fop.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

	public String generateToken(String username) {

		Map<String, Object> claims = new HashMap<>();

		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) //30min
				.and()
				.signWith(getKey())
				.compact();

	}
	
	@Value("${jwt.secret.key}")
    private String keyString;
	
	private Key getKey() {
	    byte[] keyBytes = keyString.getBytes();
	    return Keys.hmacShaKeyFor(keyBytes);
	}
	
/*
 * this generate random key every time.
 * 
	private Key getKeyUsingKeyGenerator() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
			keyGenerator.init(256); // Set key size to 256 bits
			SecretKey secretKey = keyGenerator.generateKey();
			String base64Key = Base64.getEncoder().encodeToString(secretKey.getEncoded());
			byte[] decodedKey = Base64.getDecoder().decode(base64Key);
			return new SecretKeySpec(decodedKey, "HmacSHA256");
		} catch (Exception e) {
			throw new RuntimeException("Failed to generate key", e);
		}
	}
*/

}
