package com.DisneyWorld.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DisneyWorld.model.PeliculaSerie;

@Repository
public interface IPeliculaSerieRepo extends JpaRepository<PeliculaSerie,Long>{
	//public PeliculaSerie findByTitulo(String titulo);
	public List<PeliculaSerie> findByTitulo(String titulo);
}
