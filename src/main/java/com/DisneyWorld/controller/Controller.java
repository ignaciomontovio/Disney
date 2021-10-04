package com.DisneyWorld.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Configuration
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@RestController
public class Controller {
	
	@GetMapping(value = "/")
	public void indexPage(HttpServletResponse response) throws IOException {
		 response.sendRedirect("/index.html");
	}
	
	

}
