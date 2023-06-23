package com.skillstorm.configuration;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .csrf().disable()
        .oauth2Login();
		
		//Configure CORS at the security level
		httpSecurity.cors().configurationSource(request -> {
			CorsConfiguration corsConfig = new CorsConfiguration();
			corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
			corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
			corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
			corsConfig.setAllowCredentials(true);
			corsConfig.setMaxAge(3600L); 
			
			// Sets this corsconfig to  ALL requests
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", corsConfig);
			
			return corsConfig;
		});

    return httpSecurity.build();
	}
	
	
	
}
