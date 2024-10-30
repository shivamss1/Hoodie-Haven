package com.HoodieStore.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

import com.HoodieStore.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	

	@Autowired
	private JwtFilter jwtFilter;
	
	@Autowired
	private CorsConfigurationSource customconfigurationSource;
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/public/**","/user/**","/contact/postcontact","/product/products","/public/id").permitAll()
				.requestMatchers(HttpMethod.GET,"/contact/getAllContacts").hasAnyRole("ADMIN")
				.requestMatchers(HttpMethod.GET,"/public/id").hasAnyRole("ADMIN","USER")
				.requestMatchers(HttpMethod.POST,"/product/add-product").hasAnyRole("ADMIN")
				.requestMatchers(HttpMethod.PUT,"/product/update-stock").hasAnyRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE,"/product/deleteproduct").hasAnyRole("ADMIN")
				.requestMatchers(HttpMethod.GET,"/public/status").authenticated()
				);
		 http.csrf(csrf -> csrf.disable());
		http.httpBasic(withDefaults());
//		 http.cors().disable();
//		http.formLogin(form->form
//				.loginPage("http://192.168.30.127:5500/Web-pages/Login.html")
//				.loginProcessingUrl("/user/login")
//				.permitAll());
       http.cors(config->config.configurationSource(customconfigurationSource));
        http.sessionManagement(session->session
        		.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.logout(withDefaults());
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        http.anonymous(anonymous->anonymous.disable());

		return http.build();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return  config.getAuthenticationManager();
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
