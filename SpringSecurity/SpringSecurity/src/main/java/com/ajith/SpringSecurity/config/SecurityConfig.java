package com.ajith.SpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
	  return	httpSecurity
		      .csrf(costomizer-> costomizer.disable())
		      .authorizeHttpRequests(request->request.anyRequest().authenticated())
		      .httpBasic(Customizer.withDefaults())
		      .sessionManagement(session->
		                            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		      .build();
		
//		httpSecurity.csrf(costomizer-> costomizer.disable());
//		httpSecurity.authorizeHttpRequests(request->request.anyRequest().authenticated());
////		httpSecurity.formLogin(Customizer.withDefaults());
//		httpSecurity.httpBasic(Customizer.withDefaults());
//		httpSecurity.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		
//		return httpSecurity.build();
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public AuthenticationProvider getAuthenticationProvide() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);
		return  provider;
	}

}
