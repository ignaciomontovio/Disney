package com.DisneyWorld.controller;

import static com.DisneyWorld.Constants.REGISTER_URL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DisneyWorld.dto.PersonajeDto;
import com.DisneyWorld.dto.PersonajeDtoRes;
import com.DisneyWorld.model.PeliculaSerie;
import com.DisneyWorld.model.Personaje;
import com.DisneyWorld.model.Usuario;
import com.DisneyWorld.model.builder.PersonajeBuilder;
import com.DisneyWorld.repo.IGeneroRepo;
import com.DisneyWorld.repo.IPeliculaSerieRepo;
import com.DisneyWorld.repo.IPersonajeRepo;
import com.DisneyWorld.repo.IUsuarioRepo;
import com.DisneyWorld.service.IPersonajeService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Configuration
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@RestController
public class RController {

	@Autowired
	private IUsuarioRepo usuarioService;
	
	@Autowired
	private IGeneroRepo generoService;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private IPersonajeService personajeService;
	
	@PostMapping( value = REGISTER_URL)
	public ResponseEntity<?> RegisterUser(@RequestBody Usuario user) {
		
		user.setPassword(bcrypt.encode(user.getPassword()));
		usuarioService.save(user);
		//return user.toString();
		return new ResponseEntity<>(user.toString(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	public void indexPage(HttpServletResponse response) throws IOException {
		 response.sendRedirect("/index.html");
	}
	
	

}
