package com.DisneyWorld.controller;

import static com.DisneyWorld.Constants.REGISTER_URL;

import java.io.IOException;
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
import com.DisneyWorld.model.Pelicula;
import com.DisneyWorld.model.Personaje;
import com.DisneyWorld.model.Usuario;
import com.DisneyWorld.model.builder.PersonajeBuilder;
import com.DisneyWorld.repo.IGeneroRepo;
import com.DisneyWorld.repo.IPeliculaRepo;
import com.DisneyWorld.repo.IPersonajeRepo;
import com.DisneyWorld.repo.ISerieRepo;
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
	private ISerieRepo serieService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private IPersonajeService personajeService;
	
	@PostMapping( value = REGISTER_URL)
	public String RegisterUser(@RequestBody Usuario user) {
		user.setPassword(bcrypt.encode(user.getPassword()));
		usuarioService.save(user);
		return user.toString();
		
	}
	
	@GetMapping(value = "/")
	public void indexPage(HttpServletResponse response) throws IOException {
		 response.sendRedirect("/index.html");
	}
	
	@GetMapping(value ="/characters")
	public ResponseEntity<?> obtenerPersonajes(){
		List<Personaje> personajes = personajeService.findAll();
		String personajesResponse="";
		for (Personaje personaje : personajes) {
			personajesResponse="{"+personaje.getImagen()+","+personaje.getNombre()+"}"+personajesResponse;
		}
		return new ResponseEntity<>(personajesResponse,HttpStatus.OK);
	}

}
