package com.DisneyWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DisneyWorld.model.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario,Long> {

		Usuario findByUsername(String username);
}
