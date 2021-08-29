package com.example.DisneyWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DisneyWorld.model.Serie;

public interface ISerieRepo extends JpaRepository<Serie,Integer> {

}
