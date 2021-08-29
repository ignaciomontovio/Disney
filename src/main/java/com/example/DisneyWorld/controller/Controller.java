package com.example.DisneyWorld.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DisneyWorld.model.Pelicula;
import com.example.DisneyWorld.model.Personaje;
import com.example.DisneyWorld.model.Usuario;
import com.example.DisneyWorld.repo.IGeneroRepo;
import com.example.DisneyWorld.repo.IPeliculaRepo;
import com.example.DisneyWorld.repo.IPersonajeRepo;
import com.example.DisneyWorld.repo.ISerieRepo;
import com.example.DisneyWorld.repo.IUsuarioRepo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@RestController
public class Controller {
	
	@Autowired
	private IUsuarioRepo usuarioService;
	
	@Autowired
	private IGeneroRepo generoService;
	
	@Autowired
	private IPersonajeRepo personajeService;
	
	@Autowired
	private IPeliculaRepo peliculaService;
	
	@Autowired
	private ISerieRepo serieService;
	
	//-------------------------------------------------------------- 
	//Personaje
	//-------------------------------------------------------------- 
	@PostMapping( value = "/actualizarPersona")
	public String updatePerson(@RequestBody Personaje personaje) {
		System.out.println(personaje);
		return "ok";
	}
	
	@GetMapping( value = "/obtenerPersonajes")
	public List<Personaje> obtenerPersonajes() {
		List<Personaje> personajes = personajeService.findAll();
		return personajes;
	}
	
	/*@GetMapping( value= "/login.html")
	public String InterfazlOgearuSuario(Model model) {
		System.out.println("ok");
		return "redirect:/login.html";
	}
	
	@PostMapping( value= "/loginUser")
	public String logearUsuario() {
		System.out.println("ok");
		return null;
	}*/
	
	//-------------------------------------------------------------- 
	//END Personaje
	//-------------------------------------------------------------- 
	
	
	//-------------------------------------------------------------- 
	//Pelicula
	//-------------------------------------------------------------- 
	@GetMapping( value = "/obtenerPeliculas")
	public List<Pelicula> obtenerPeliculas() {
		List<Pelicula> peliculas = peliculaService.findAll();
		return peliculas;
	}
	
	@PostMapping(value = "/crearPelicula")
	public Pelicula crearPelicula(@RequestBody Pelicula pelicula) {
		peliculaService.save(pelicula);
		return pelicula;
	}
	
	//-------------------------------------------------------------- 
	//END Personaje
	//-------------------------------------------------------------- 
//	public List<Usuario> updatePerson() {
//		List<Usuario> usuarios = usuarioService.findAll();
//		return usuarios;
//	}
}
