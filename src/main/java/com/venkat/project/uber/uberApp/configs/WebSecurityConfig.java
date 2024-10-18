package com.venkat.project.uber.uberApp.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.venkat.project.uber.uberApp.Security.JwtAuthFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
	
	private final JwtAuthFilter jwtAuthFilter;
	
	  private static final String[] PUBLIC_ROUTES = {
		        "/auth/**",           // Public authentication endpoints
		        "/swagger-ui/**",     // Swagger UI resources
		        "/v3/api-docs/**",    // OpenAPI documentation
		        "/swagger-ui.html",   // Main Swagger UI page (for older versions)
		        "/health",            // Health check endpoint
		        "/actuator/**",       // Actuator endpoints
		        "/" ,
		        "/redirectToGoogle"	// Root endpoint
		    };
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	    httpSecurity
	        .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .csrf(csrfConfig -> csrfConfig.disable())
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(PUBLIC_ROUTES).permitAll()     // Public routes
	            .requestMatchers("/health", "/actuator/**", "/").permitAll() // Allow health check and actuator endpoints
	            .anyRequest().authenticated()
	        )
	        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
	    return httpSecurity.build();
	}

	

}
