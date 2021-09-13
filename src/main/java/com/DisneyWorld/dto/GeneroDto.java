package com.DisneyWorld.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GeneroDto {

	private String nombre;
	private String imagen;
	
	List<Integer> peliculas = new ArrayList<Integer>();


	public GeneroDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeneroDto(String nombre, String imagen, List<Integer> peliculas) {
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

	public List<Integer> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Integer> peliculas) {
		this.peliculas = peliculas;
	}
	
	
}
