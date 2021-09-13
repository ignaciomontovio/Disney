package com.DisneyWorld.dto;

import java.util.Date;
import java.util.List;

import com.DisneyWorld.model.Genero;
import com.DisneyWorld.model.PeliculaSerie;
import com.DisneyWorld.model.Personaje;

public class PeliculaSerieDtoRes {
	
	private String titulo;
	private String imagen;
	private Date fechaCreacion;
	
	public PeliculaSerieDtoRes(String titulo, String imagen,Date fechaCreacion) {
		super();
		this.titulo = titulo;
		this.imagen = imagen;
		this.fechaCreacion = fechaCreacion;
	}
	
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

	
}
