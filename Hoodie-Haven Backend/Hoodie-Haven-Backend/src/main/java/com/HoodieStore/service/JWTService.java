package com.HoodieStore.service;


import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;




@Service
public class JWTService {

	 private String SECRET_KEY = "";
	 
	 private JWTService() {
		try {
			KeyGenerator key=KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk=key.generateKey();
			SECRET_KEY=Base64.getEncoder().encodeToString(sk.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	 public String generateToken(String username) {
		 Map<String,Object> claims=new HashMap<>();
		 
		 
		 return Jwts.builder()
				 .claims()
				 .add(claims)
				 .subject(username)
				 .issuedAt(new Date(System.currentTimeMillis()))
				 .expiration(new Date(System.currentTimeMillis()+60*60*60))
				 .and()
				 .signWith(getKey())
				 .compact();
	 }

	private SecretKey getKey() {
		byte[] keybyte=Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keybyte);
	}

	public String extractusername(String token) {
		 return extractClaim(token, Claims::getSubject);
	}

	public boolean validateToken(String token, UserDetails userDetail) {
		
		  final String userName = extractusername(token);
	        return (userName.equals(userDetail.getUsername()) && !isTokenExpired(token));
	}
	 
	
	private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimResolver.apply(claims);
	    }
	  
	private Claims extractAllClaims(String token) {
	        return Jwts.parser()
	                .verifyWith(getKey())
	                .build()
	                .parseSignedClaims(token)
	                .getPayload();
	    }
	
	 private boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }
	 
	 private Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }
	   }
