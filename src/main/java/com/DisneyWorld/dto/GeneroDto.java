package com.DisneyWorld.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GeneroDto {

	private String nombre;
	private String imagen;
	
	List<Long> peliculas = new ArrayList<Long>();


	public GeneroDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeneroDto(String nombre, String imagen, List<Long> peliculas) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.peliculas = peliculas;
	}

	public GeneroDto(String nombre, String imagen) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<Long> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Long> peliculas) {
		this.peliculas = peliculas;
	}

	
	
}
