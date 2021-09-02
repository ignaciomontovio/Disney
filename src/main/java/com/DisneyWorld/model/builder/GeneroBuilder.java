package com.DisneyWorld.model.builder;

import com.DisneyWorld.dto.GeneroDto;
import com.DisneyWorld.model.Genero;

public class GeneroBuilder {

	private String nombre;
	private String imagen;
	
	public GeneroBuilder withGeneroDto(GeneroDto generoDto) {
		this.nombre = generoDto.getNombre();
		this.imagen = generoDto.getImagen();
		return this;
	}
	
	public Genero build() {
		return new Genero(this.nombre,this.imagen);
	}
}
