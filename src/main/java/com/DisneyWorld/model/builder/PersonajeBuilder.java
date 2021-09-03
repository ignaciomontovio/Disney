package com.DisneyWorld.model.builder;

import com.DisneyWorld.dto.PersonajeDto;
import com.DisneyWorld.dto.PersonajeDtoRes;
import com.DisneyWorld.model.Personaje;

public class PersonajeBuilder {

	private String nombre;
	private String imagen;
	private int edad;
	private float peso;
	private String historia;
	
	public PersonajeBuilder withPersonajeDto(PersonajeDto personajeDto) {
		this.nombre = personajeDto.getNombre();
		this.imagen = personajeDto.getImagen();
		this.edad = personajeDto.getEdad();
		this.peso = personajeDto.getPeso();
		this.historia = personajeDto.getHistoria();
		return this;
	}
	
	public PersonajeBuilder withPersonajeDtoRes(Personaje personaje) {
		this.nombre = personaje.getNombre();
		this.imagen = personaje.getImagen();
		return this;
	}
	
	
	public Personaje build() {
		return new Personaje(this.nombre,this.imagen,this.edad,this.peso,this.historia);
	}
	public PersonajeDtoRes buildRes() {
		return new PersonajeDtoRes(this.nombre,this.imagen);
	}
}
