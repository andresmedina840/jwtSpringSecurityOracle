package co.gov.policia.pwa.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import co.gov.policia.pwa.entity.EmpleadosSipac;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class AuthJwtUtil {

	@Value("${backend.app.jwtSecret}")
	private static String idJwt;

	@Value("${backend.app.jwtExpirationTime}")
	private static Long jwtExpirationTime;
	
	public static String generarJsonWebToken(Authentication autenticacion) {
		
		UserDetalle userPrincipal= (UserDetalle) autenticacion.getPrincipal();
		
		Date expirationDate = new Date(System.currentTimeMillis() + jwtExpirationTime); 
		
		Map<String, Object> extra = new HashMap<>();		
		extra.put("nombre", userPrincipal.getUsername());
		
		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setExpiration(expirationDate)
				.addClaims(extra)
				.signWith(Keys.hmacShaKeyFor(idJwt.getBytes()))
				.compact();
	}
	
	public String generateJwtTokenLdap(EmpleadosSipac authentication) {

		Date expirationDate = new Date(System.currentTimeMillis() + jwtExpirationTime);
				
		Map<String, Object> extra = new HashMap<>();		
		extra.put("nombre", authentication.getNombres());
		
		return Jwts.builder()
				.setSubject((authentication.getUsuarioSipac()))
				.setExpiration(expirationDate)
				.addClaims(extra)
				.signWith(Keys.hmacShaKeyFor(idJwt.getBytes()))
				.compact();
	}
	
	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
		try {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(idJwt.getBytes())
					.build()
					.parseClaimsJws(token)
					.getBody();
			
			String email = claims.getSubject();
			
			return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
		} catch (JwtException e) {
			return null;
		}
	}

}
