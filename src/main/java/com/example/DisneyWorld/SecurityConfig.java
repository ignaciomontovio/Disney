package com.example.DisneyWorld;

import static com.example.DisneyWorld.Constants.LOGIN_URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.ui.LoginPageGeneratingWebFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

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
//		http
//		.authorizeRequests()
//			.antMatchers("/auth/login","/auth/logins.html","/auth/registers.html","/css/*.css","./js/*.js").permitAll()
//			//,"/auth/register"
//			.anyRequest().authenticated()
//			.and()
//		.formLogin()
//			.loginPage("/auth/login.html")
//			.permitAll()
//			.and()
//		.logout()
//			.permitAll();
//		
//		http.csrf().disable(); // VER CON QUE REEMPLAZAR ESTO
		
		/*
		 * 1. Se desactiva el uso de cookies
		 * 2. Se activa la configuración CORS con los valores por defecto
		 * 3. Se desactiva el filtro CSRF
		 * 4. Se indica que el login no requiere autenticación
		 * 5. Se indica que el resto de URLs esten securizadas
		 */
		http
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.cors().and()
			.csrf().disable()
			.authorizeRequests().antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
			.anyRequest().authenticated().and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager()));
		
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
		
		
		
	}

//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//		return (CorsConfigurationSource) source;
//	}
}
