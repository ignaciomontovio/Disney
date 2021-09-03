package com.DisneyWorld.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DisneyWorld.model.Personaje;

public interface IPersonajeRepo extends JpaRepository<Personaje,Integer>{

	public List<Personaje> findAll();
	public Personaje getById(Integer id);
	public Personaje save(Personaje personaje);
	public void deleteById(Integer id);
}
