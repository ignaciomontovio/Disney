package com.example.DisneyWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DisneyWorld.model.Personaje;

public interface IPersonajeRepo extends JpaRepository<Personaje,Integer>{

}
