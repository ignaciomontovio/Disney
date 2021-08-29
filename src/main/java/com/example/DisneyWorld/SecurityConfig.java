package com.example.DisneyWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.ui.LoginPageGeneratingWebFilter;

import com.example.DisneyWorld.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
		throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
			.antMatchers("/auth/register.html","/css/*.css").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/auth/login.html")
			.permitAll()
			.and()
		.logout()
			.permitAll();
		//http
			//.authorizeRequests()
			//.anyRequest()
			//.authenticated()
			//.and()
			//.httpBasic();
//		http.formLogin()
//	      .loginPage("/login.html")
//	      .loginProcessingUrl("/perform_login")
//	      .defaultSuccessUrl("/homepage.html",true)
//	      .failureUrl("/login.html?error=true");
		
//		http
//        .oauth2Login(oauth2Login ->
//            oauth2Login
//                .loginPage("/login/oauth2")
//                .authorizationEndpoint(authorizationEndpoint ->
//                    authorizationEndpoint
//                 .baseUri("/login/oauth2/authorization");
		http.csrf().disable(); // VER CON QUE REEMPLAZAR ESTO
		
		
	}
	
}
