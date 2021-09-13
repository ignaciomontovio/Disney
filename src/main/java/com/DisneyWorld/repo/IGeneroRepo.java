package com.DisneyWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DisneyWorld.model.Genero;

@Repository
public interface IGeneroRepo extends JpaRepository<Genero,Integer>{

}
