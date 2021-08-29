package com.example.DisneyWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DisneyWorld.model.Pelicula;

public interface IPeliculaRepo extends JpaRepository<Pelicula,Integer>{

}
