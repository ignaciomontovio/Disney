package com.DisneyWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DisneyWorld.model.Serie;

public interface ISerieRepo extends JpaRepository<Serie,Integer> {

}
