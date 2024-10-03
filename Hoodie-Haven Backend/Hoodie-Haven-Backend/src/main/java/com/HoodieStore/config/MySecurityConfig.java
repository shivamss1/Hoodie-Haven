package com.HoodieStore.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.HoodieStore.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/public/**","/user/usersignup","/contact/postcontact").permitAll()
				.requestMatchers(HttpMethod.GET,"/contact/getAllContacts","/product/products").hasAnyRole("ADMIN")
				.requestMatchers(HttpMethod.POST,"/product/add-product").hasAnyRole("ADMIN")
				.requestMatchers(HttpMethod.PUT,"/product/**").hasAnyRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE,"/product/**").hasAnyRole("ADMIN")
				);
		 http.csrf(csrf -> csrf.disable());
		http.httpBasic(withDefaults());
		http.cors();
		return http.build();
	}
	
	
	  	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		
	DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
	
	daoAuthenticationProvider.setUserDetailsService(customUserDetailService);
	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
		
	}
	
	


}
