package com.DisneyWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DisneyWorld.model.Personaje;

public interface IPersonajeRepo extends JpaRepository<Personaje,Integer>{

}
