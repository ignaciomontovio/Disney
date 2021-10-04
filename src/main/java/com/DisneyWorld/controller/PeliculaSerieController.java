package com.DisneyWorld.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.DisneyWorld.dto.PeliculaSerieDto;
import com.DisneyWorld.service.IPeliculaSerieService;

@RestController
@RequestMapping("/movies")
public class PeliculaSerieController {
	@Autowired
	private IPeliculaSerieService peliculaService;
	
//	@GetMapping( value = "")
//	public ResponseEntity<?> obtenerPeliculasPorParametros(@RequestParam(defaultValue = "") String nombre,@RequestParam(defaultValue = "0") Long genre,@RequestParam(defaultValue = "") String order) {
//		//List<PeliculaSerieDtoRes> peliculas = peliculaService.findAllPeliculaSerieDtoRes();
//		if(nombre != ""){
//			List<PeliculaSerie> peliculas = peliculaService.findByTitulo(nombre);
//			return new ResponseEntity<>(peliculas,HttpStatus.ACCEPTED);
//		}
//		if(genre != 0){
//			
//			return new ResponseEntity<>(HttpStatus.ACCEPTED);
//		}
//		if(order.equals("ASC") || order.equals("DESC") ) {
//
//			return new ResponseEntity<>(HttpStatus.ACCEPTED);
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
	
	
	@GetMapping( value = "")
	public ResponseEntity<?> getMoviesDtoRes() {
		return new ResponseEntity<>(peliculaService.findAllMovieSerieDtoRes(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping( value = "/")
	public ResponseEntity<?> getMovies() {
		return new ResponseEntity<>(peliculaService.findAllMovieSerie(),HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<?> createMovie(@RequestBody PeliculaSerieDto peliculaDto) {
		return new ResponseEntity<>(peliculaService.saveMovieSerie(peliculaDto),HttpStatus.ACCEPTED);
	}
	
	@PutMapping( value = "/{id}")
	public ResponseEntity<?> updateMovie(@PathVariable(value = "id")Long id,@RequestBody PeliculaSerieDto peliculaDto) {
		return new ResponseEntity<>(peliculaService.updateMovieSerie(id,peliculaDto),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping( value = "/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable(value = "id")Long id){
		return new ResponseEntity<>(peliculaService.deleteMovieSerie(id),HttpStatus.ACCEPTED);
	}
}
