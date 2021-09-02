package com.DisneyWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DisneyWorld.model.Pelicula;

public interface IPeliculaRepo extends JpaRepository<Pelicula,Integer>{

}
