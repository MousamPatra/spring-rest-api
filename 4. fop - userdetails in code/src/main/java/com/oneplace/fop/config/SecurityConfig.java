package com.oneplace.fop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()).build();

	}

	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails user1 = User.withDefaultPasswordEncoder().username("Sidd").password("s@123").roles("ADMIN").build();
		UserDetails user2 = User.withDefaultPasswordEncoder().username("Akash").password("a@123").roles("USER").build();

		return new InMemoryUserDetailsManager(user1, user2);
	}

}
