package com.DisneyWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DisneyWorld.model.PeliculaSerie;

@Repository
public interface IPeliculaSerieRepo extends JpaRepository<PeliculaSerie,Integer>{
	public PeliculaSerie findByTitulo(String titulo);
}
