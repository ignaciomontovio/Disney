package com.DisneyWorld.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@CrossOrigin("*")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nombre;
	
	private String imagen;
	
	
	@ManyToMany
	private List<PeliculaSerie> peliculas ;
	
	
	public Genero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genero(String nombre, String imagen) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Genero(int id) {
		super();
		this.id = id;
	}

	public Genero(String nombre, String imagen, List<PeliculaSerie> peliculas) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.peliculas = peliculas;
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

	public List<PeliculaSerie> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<PeliculaSerie> peliculas) {
		this.peliculas = peliculas;
	}

	
}
