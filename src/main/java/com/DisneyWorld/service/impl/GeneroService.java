package com.DisneyWorld.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DisneyWorld.dto.GeneroDto;
import com.DisneyWorld.model.Genero;
import com.DisneyWorld.model.PeliculaSerie;
import com.DisneyWorld.model.builder.GeneroBuilder;
import com.DisneyWorld.repo.IGeneroRepo;
import com.DisneyWorld.service.IGeneroService;

@Service
public class GeneroService implements IGeneroService{

	@Autowired
	private IGeneroRepo generoRepo;

	@Override
	public List<Genero> findAllGenre() {
		List<Genero> generos = generoRepo.findAll();
		return generos;
	}

	@Override
	public Genero saveGenre(GeneroDto generoDto) {
		Genero genero = new GeneroBuilder().withGeneroDto(generoDto).build();
		genero = generoRepo.save(genero);
		return genero;
	}

	@Override
	public Genero updateGenre(Long id, GeneroDto generoDto) {
		Genero genero = generoRepo.findById(id).get();
		
		String imagen = generoDto.getImagen();
		String nombre = generoDto.getNombre();
		
		if(imagen != null)
			genero.setImagen(imagen);
		if(nombre != null);
			genero.setNombre(nombre);
		
		if(generoDto.getPeliculas() != null) {
			List<PeliculaSerie> peliculasSeries = new ArrayList<PeliculaSerie>();
			for (Long idPeliculaSerie : generoDto.getPeliculas()) {
				peliculasSeries.add(new PeliculaSerie(idPeliculaSerie));
				System.out.println(idPeliculaSerie);
			}
			genero.setPeliculas(peliculasSeries);
		}
		genero = generoRepo.save(genero);
		return genero;
	}

	@Override
	public Genero deleteGenre(Long id) {
		Genero genero = generoRepo.findById(id).get();
		generoRepo.deleteById(id);
		return genero;
	}
}
