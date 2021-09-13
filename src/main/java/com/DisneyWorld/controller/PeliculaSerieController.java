package com.DisneyWorld.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DisneyWorld.dto.PeliculaSerieDto;
import com.DisneyWorld.dto.PeliculaSerieDtoRes;
import com.DisneyWorld.dto.PersonajeDto;
import com.DisneyWorld.model.PeliculaSerie;
import com.DisneyWorld.repo.IPeliculaSerieRepo;
import com.DisneyWorld.service.IPeliculaSerieService;

@RestController
@RequestMapping("/movies")
public class PeliculaSerieController {
	@Autowired
	private IPeliculaSerieService peliculaService;
	
	@GetMapping( value = "")
	public ResponseEntity<?> obtenerPeliculasPorParametros(@RequestParam(defaultValue = "") String nombre,@RequestParam(defaultValue = "0") Integer genre,@RequestParam(defaultValue = "") String order) {
		//List<PeliculaSerieDtoRes> peliculas = peliculaService.findAllPeliculaSerieDtoRes();
		if(nombre != ""){
		}
		if(genre != 0){

		}
		if(order.equals("ASC") || order.equals("DESC") ) {

		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping( value = "/")
	public ResponseEntity<?> obtenerPeliculasDtoRes() {
		List<PeliculaSerieDtoRes> peliculas = peliculaService.findAllPeliculaSerieDtoRes();
		return new ResponseEntity<>(peliculas,HttpStatus.ACCEPTED);
	}
	
	@GetMapping( value = "/obtenerPeliculas")
	public ResponseEntity<?> obtenerPeliculas() {
		List<PeliculaSerie> peliculas = peliculaService.findAllPeliculaSerie();
		return new ResponseEntity<>(peliculas,HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/crearPelicula")
	public ResponseEntity<?> crearPelicula(@RequestBody PeliculaSerieDto peliculaDto) {
		PeliculaSerie pelicula = peliculaService.savePelicula(peliculaDto);
		return new ResponseEntity<>(pelicula,HttpStatus.ACCEPTED);
	}
	
	@PutMapping( value = "/actualizarPelicula/{id}")
	public ResponseEntity<?> actualizarPeliculas(@PathVariable(value = "id")Integer id,@RequestBody PeliculaSerieDto peliculaDto) {
		
		PeliculaSerie peliculas = peliculaService.updatePelicula(id,peliculaDto);
		
		return new ResponseEntity<>(peliculas,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping( value = "/eliminarPelicula/{id}")
	public ResponseEntity<?> eliminarPeliculas(@PathVariable(value = "id")Integer id){
		PeliculaSerie pelicula = peliculaService.deletePelicula(id);
		return new ResponseEntity<>(pelicula,HttpStatus.ACCEPTED);
	}
}
