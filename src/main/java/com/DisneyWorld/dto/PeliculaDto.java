package com.DisneyWorld.dto;

import java.util.Date;
import java.util.List;

import com.DisneyWorld.model.Pelicula;

public class PeliculaDto {
	
	private String titulo;
	private String imagen;
	private Date fechaCreacion;
	private int calificacion;
	
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
	
	
	
}
