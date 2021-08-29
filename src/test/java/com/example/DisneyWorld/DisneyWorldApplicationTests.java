package com.example.DisneyWorld;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.DisneyWorld.model.Usuario;
import com.example.DisneyWorld.repo.IUsuarioRepo;

@SpringBootTest
class DisneyWorldApplicationTests {

	@Autowired
	private IUsuarioRepo repo;
	
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void contextLoads() {
		
	}
	@Test
	public void crearUsuarioTest() {
		Usuario us = new Usuario();
		us.setId(2);
		us.setNombre("ignacio");
		us.setClave(encoder.encode("1234"));
		Usuario retorno = repo.save(us);
	}

}
