package com.DisneyWorld.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class PeliculaSerie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String titulo;
	private String imagen;
	private Date fechaCreacion;
	private int calificacion;
	
	//@JsonBackReference
	@ManyToMany
	List<Personaje> personajes;
	
	//@JsonBackReference
	@ManyToMany
	List<Genero> generos;
	
	
	public PeliculaSerie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PeliculaSerie(int id) {
		super();
		this.id = id;
	}

	public PeliculaSerie(String titulo) {
		super();
		this.titulo = titulo;
	}

	public PeliculaSerie(String titulo, String imagen, Date fechaCreacion, int calificacion) {
		super();
		this.titulo = titulo;
		this.imagen = imagen;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		

	}
	public String getImagen() {
		return imagen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	public List<Personaje> getPersonajes() {
		return personajes;
	}
	public void setPersonajes(List<Personaje> personajes) {
		this.personajes = personajes;
	}
	public List<Genero> getGeneros() {
		return generos;
	}
	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	
	
}
