package com.example.DisneyWorld.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.DisneyWorld.model.JwtTokenUtil;
import com.example.DisneyWorld.model.Pelicula;
import com.example.DisneyWorld.model.Personaje;
import com.example.DisneyWorld.model.Usuario;
import com.example.DisneyWorld.repo.IGeneroRepo;
import com.example.DisneyWorld.repo.IPeliculaRepo;
import com.example.DisneyWorld.repo.IPersonajeRepo;
import com.example.DisneyWorld.repo.ISerieRepo;
import com.example.DisneyWorld.repo.IUsuarioRepo;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@RestController
public class RController {
	
//	@Autowired
//	private JwtTokenUtil jwtUtil;
	
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
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
//	private String getJWTToken(String username) {
//		String secretKey = "123456789ABCdef123456789ABCdef123456789ABCdef123456789ABCdef123456789ABCdef123456789ABCdef123456789ABCdef";
////		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
////				.commaSeparatedStringToAuthorityList("ROLE_USER");
//		
//		String token = Jwts
//				.builder()
//				.setId("softtekJWT")
//				.setSubject(username)
////				.claim("authorities",
////						grantedAuthorities.stream()
////								.map(GrantedAuthority::getAuthority)
////								.collect(Collectors.toList()))
//				.setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + 600000))
//				.signWith(SignatureAlgorithm.HS512,
//						secretKey.getBytes()).compact();
//
//		return "Bearer " + token;
//	}
	
	//-------------------------------------------------------------- 
	//Personaje
	//-------------------------------------------------------------- 
	
//	@GetMapping( value = "auth/logins.html")
//	public String LoginUser(@RequestBody Usuario user) {
//		String token = getJWTToken("adsa");
//		return token;
//		//return "";
//	}
	
	@PostMapping( value = "auth/register")
	public String RegisterUser(@RequestBody Usuario user) {
		user.setPassword(bcrypt.encode(user.getPassword()));
		user.setClave(bcrypt.encode(user.getClave()));
		usuarioService.save(user);
		return user.toString();
		
	}
	
//	private String getJWTToken(String username) {
//		String secretKey = "mySecretKey";
//		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//				.commaSeparatedStringToAuthorityList("ROLE_USER");
//		
//		String token = Jwts
//				.builder()
//				.setId("softtekJWT")
//				.setSubject(username)
//				.claim("authorities",
//						grantedAuthorities.stream()
//								.map(GrantedAuthority::getAuthority)
//								.collect(Collectors.toList()))
//				.setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + 600000))
//				.signWith(SignatureAlgorithm.HS512,
//						secretKey.getBytes()).compact();
//
//		return "Bearer " + token;
//	}
//	@GetMapping( value = "/auth/register.html")
//	//@RequestMapping("/auth/register.html")
//	public void loadRegisterUser(HttpServletResponse response) {
//		System.out.println("---");
////		System.out.println(model.getAttribute("password"));
//		//model.addAttribute("user", new Usuario());
//		try {
//			response.sendRedirect("/auth/register.html");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//return "redirect:localhost:8080/auth/register.html";
//	}
//	
//	@PostMapping( value = "/registerUser")
//	public String saveRegisterUser(Model model) {
//		Usuario newUser = (Usuario) model.getAttribute("user");
//		usuarioService.save(newUser);
//		return "ok";
//	}
	//-------------------------------------------------------------- 
	//END Usuario
	//-------------------------------------------------------------- 
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
