package com.example.DisneyWorld.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Personaje {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String imagen;
	private int edad;
	private float peso;
	
	@ManyToMany
	List<Serie> series;
	
	@ManyToMany
	List<Pelicula> peliculas;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String historia;
	
	
	
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
	@Override
	public String toString() {
		return "Personaje [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", edad=" + edad + ", peso=" + peso
				+ ", series=" + series + ", peliculas=" + peliculas + ", historia=" + historia + "]";
	}
	
}
