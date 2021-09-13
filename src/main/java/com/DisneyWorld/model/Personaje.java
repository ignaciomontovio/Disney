package com.DisneyWorld.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Personaje {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String nombre;
	private String imagen;
	private int edad;
	private float peso;
	private String historia;
	
	//@JsonBackReference
	 //@JsonManagedReference
	@ManyToMany
	List<PeliculaSerie> peliculas;
	

	public Personaje() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Personaje(int id) {
		super();
		this.id = id;
	}

	public Personaje(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Personaje(String nombre, String imagen, int edad, float peso, String historia) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
	}
	

	public Personaje(String nombre, String imagen, int edad, float peso, String historia,
			List<PeliculaSerie> peliculas) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.peliculas = peliculas;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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


	public List<PeliculaSerie> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<PeliculaSerie> peliculas) {
		this.peliculas = peliculas;
	}
	
	public String toStringImagenNombre() {
		return "{nombre=" + nombre + ", imagen=" + imagen+"}";
	}
	
}
