
package com.DisneyWorld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DisneyWorld.model.Usuario;
import com.DisneyWorld.repo.IUsuarioRepo;
import com.DisneyWorld.service.ISendMailService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private IUsuarioRepo usuarioService;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
    private ISendMailService sendMailService;
	
	@PostMapping( "/register")
	public ResponseEntity<?> RegisterUser(@RequestBody Usuario user) {
		
		user.setPassword(bcrypt.encode(user.getPassword()));
		usuarioService.save(user);
		sendMailService.sendEmail(user.getEmail(),user.getName());
		return new ResponseEntity<>(user.toString(),HttpStatus.OK);
	}
}
