package com.DisneyWorld.model.builder;

import java.util.ArrayList;
import java.util.List;

import com.DisneyWorld.dto.PeliculaSerieDto;
import com.DisneyWorld.dto.PersonajeDto;
import com.DisneyWorld.dto.PersonajeDtoRes;
import com.DisneyWorld.model.PeliculaSerie;
import com.DisneyWorld.model.Personaje;

public class PersonajeBuilder {

	private String nombre;
	private String imagen;
	private int edad;
	private float peso;
	private String historia;
	private List<PeliculaSerie> peliculas = new ArrayList<PeliculaSerie>();
	
	public PersonajeBuilder withPersonajeDto(PersonajeDto personajeDto) {
		this.nombre = personajeDto.getNombre();
		this.imagen = personajeDto.getImagen();
		this.edad = personajeDto.getEdad();
		this.peso = personajeDto.getPeso();
		this.historia = personajeDto.getHistoria();
		
		
		if(personajeDto.getPeliculas() != null) {
			List<Integer> peliculasDto = personajeDto.getPeliculas();
			for (Integer idPelicula : peliculasDto) {
				this.peliculas.add(new PeliculaSerie(idPelicula));
			}
			
		}
			

		return this;
	}
	
	public PersonajeBuilder withPersonajeDtoRes(Personaje personaje) {
		this.nombre = personaje.getNombre();
		this.imagen = personaje.getImagen();
		return this;
	}
	
	
	public Personaje build() {
		return new Personaje(this.nombre,this.imagen,this.edad,this.peso,this.historia,this.peliculas);
	}
	public PersonajeDtoRes buildRes() {
		return new PersonajeDtoRes(this.nombre,this.imagen);
	}
}
