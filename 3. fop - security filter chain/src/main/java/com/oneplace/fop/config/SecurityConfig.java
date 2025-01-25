package com.oneplace.fop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .build();

        /*
         * The following code does the same thing as above in a more detailed form:
         */

//      http.csrf(customizer -> customizer.disable()); // Disable CSRF protection
//      http.authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated()); // Require authentication for all requests
//      http.httpBasic(Customizer.withDefaults()); // Enable HTTP Basic authentication for API tools like Postman
//      http.formLogin(Customizer.withDefaults()); // Enable form-based login for browser interactions
//
//      return http.build(); // Build the HTTP security configuration

	}

}
