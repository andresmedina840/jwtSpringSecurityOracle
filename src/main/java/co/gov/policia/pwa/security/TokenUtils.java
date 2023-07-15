package co.gov.policia.pwa.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {
	
	//private static final Logger logger = LoggerFactory.getLogger(AuthJwtUtil.class);

	@Value("${backend.app.jwtSecret}")
	private static String idJwt;

	@Value("${backend.app.jwtExpirationTime}")
	private static Long jwtExpirationTime;
	
	public static String generarJsonWebToken(String nombre, String email) {
		
		Date expirationDate = new Date(System.currentTimeMillis() + jwtExpirationTime); 
		
		Map<String, Object> extra = new HashMap<>();		
		extra.put("nombre", nombre);
		
		return Jwts.builder()
				.setSubject(email)
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
