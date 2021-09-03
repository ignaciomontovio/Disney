package com.DisneyWorld.dto;

public class PersonajeDtoRes {
	private String nombre;
	private String imagen;
	
	public PersonajeDtoRes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonajeDtoRes(String nombre, String imagen) {
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
}
