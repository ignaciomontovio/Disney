package com.example.DisneyWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DisneyWorld.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario,Integer> {

		Usuario findByUsername(String username);
}
