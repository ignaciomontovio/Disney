package com.DisneyWorld.dto;

import java.util.Date;
import java.util.List;

import com.DisneyWorld.model.Genero;
import com.DisneyWorld.model.PeliculaSerie;
import com.DisneyWorld.model.Personaje;

public class PeliculaSerieDto {
	
	private String titulo;
	private String imagen;
	private Date fechaCreacion;
	private int calificacion;
	private List<Integer> personajes;
	private List<Integer> generos;
	//private List<Personaje> personajes;
	//private List<Genero> generos;
	
	public PeliculaSerieDto(String titulo, String imagen, Date fechaCreacion, int calificacion,
			List<Integer> personajes, List<Integer> generos) {
		super();
		this.titulo = titulo;
		this.imagen = imagen;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		this.personajes = personajes;
		this.generos = generos;
	}
	
	/*public PeliculaSerieDto(String titulo, String imagen, Date fechaCreacion, int calificacion,
			List<Personaje> personajes, List<Genero> generos) {
		super();
		this.titulo = titulo;
		this.imagen = imagen;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		this.personajes = personajes;
		this.generos = generos;
	}*/
	

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
		return "PeliculaDto [titulo=" + titulo + ", imagen=" + imagen + ", fechaCreacion=" + fechaCreacion
				+ ", calificacion=" + calificacion + "]";
	}

	public List<Integer> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<Integer> personajes) {
		this.personajes = personajes;
	}

	public List<Integer> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Integer> generos) {
		this.generos = generos;
	}

	
	
	
}
