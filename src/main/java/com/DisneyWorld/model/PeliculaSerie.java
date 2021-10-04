package com.DisneyWorld.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@CrossOrigin("*")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id")
public class PeliculaSerie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String imagen;
	private Date fechaCreacion;
	private int calificacion;
	
	@JsonManagedReference
	@JoinTable(
			  name = "peliculaserie_personaje", 
			  joinColumns = @JoinColumn(name = "peliculaserie_id"), 
			  inverseJoinColumns = @JoinColumn(name = "personaje_id"))
	@ManyToMany
	List<Personaje> personajes;
	
	@JsonManagedReference
	@JoinTable(
			  name = "peliculaserie_genero", 
			  joinColumns = @JoinColumn(name = "peliculaserie_id"), 
			  inverseJoinColumns = @JoinColumn(name = "genero_id"))
	@ManyToMany
	List<Genero> generos;
	
	
	public PeliculaSerie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PeliculaSerie(String titulo) {
		super();
		this.titulo = titulo;
	}

	
	public PeliculaSerie(String titulo, String imagen, Date fechaCreacion, int calificacion, List<Personaje> personajes,
			List<Genero> generos) {
		super();
		this.titulo = titulo;
		this.imagen = imagen;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		this.personajes = personajes;
		this.generos = generos;
	}

	public String getImagen() {
		return imagen;
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

	@Override
	public String toString() {
		return "PeliculaSerie [id=" + id + ", titulo=" + titulo + ", imagen=" + imagen + ", fechaCreacion="
				+ fechaCreacion + ", calificacion=" + calificacion + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public PeliculaSerie(Long id) {
		super();
		this.id = id;
	}

	
	
}
