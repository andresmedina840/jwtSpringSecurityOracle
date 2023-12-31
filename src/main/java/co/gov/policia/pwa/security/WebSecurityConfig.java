package co.gov.policia.pwa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {
	
	private final UserDetailsService userDetailsService;
	private final JWTAuthorizationFilter jwtAuthorizationFilter;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
		
		JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(authManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		
		return http
				.headers(headers -> {
			headers.frameOptions(frameOptions -> frameOptions.sameOrigin());
			headers.contentSecurityPolicy(
					csp -> csp.policyDirectives("default-src 'self' https: ; script-src 'self' ; object-src 'self'"));})
			.cors(cors -> cors.disable())
			.authorizeHttpRequests(auth -> {
				auth.antMatchers("/v1/api/sigicmovil/auth/signin", "/v1/api/sigicmovil/auth/piePaginaInicioPagina",
						"/v1/api/sigicmovil/auth/**", "/v1/api/**", "/v2/api-docs/**", "/swagger-ui/**",
						"/swagger-resources/**", "/configuration/**").permitAll();
				auth.anyRequest().authenticated();
		})
		.sessionManagement(session -> {session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);})
		.addFilter(jwtAuthenticationFilter)
		.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
		.build();
	}
	
	@Bean
	AuthenticationManager authManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder())
				.and()
				.build();
	}
	
	@Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
   }
		
}
