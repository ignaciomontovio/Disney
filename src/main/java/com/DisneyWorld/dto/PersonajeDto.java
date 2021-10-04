package com.DisneyWorld.dto;

import java.util.List;

import com.DisneyWorld.model.PeliculaSerie;

public class PersonajeDto {

	private String nombre;
	private String imagen;
	private int edad;
	private float peso;
	private String historia;
	private List<Long> peliculas;
	private List<Long> generos;
	
	//private List<PeliculaSerieDto> peliculas;
	//private List<GeneroDto> generos;
	
	public String getNombre() {
		return nombre;
	}
	public PersonajeDto(String nombre, String imagen, int edad, float peso, String historia, List<Long> peliculas,
			List<Long> generos) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.peliculas = peliculas;
		this.generos = generos;
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	public List<Long> getPeliculas() {
		return peliculas;
	}
	public void setPeliculas(List<Long> peliculas) {
		this.peliculas = peliculas;
	}
	public List<Long> getGeneros() {
		return generos;
	}
	public void setGeneros(List<Long> generos) {
		this.generos = generos;
	}
	
	
}
