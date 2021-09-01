//package com.example.DisneyWorld.controller;
//
//import java.io.IOException;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.example.DisneyWorld.model.Usuario;
//import com.example.DisneyWorld.repo.IUsuarioRepo;
//
//@org.springframework.stereotype.Controller
//public class Controller {
//	@Autowired
//	private IUsuarioRepo usuarioService;
//	
//	@GetMapping( value = "/auth/register.html")
//	public String loadRegisterUser(HttpServletResponse response,Model model) {
//		System.out.println("---");
////		System.out.println(model.getAttribute("password"));
//		model.addAttribute("user", new Usuario());
//		try {
//			response.sendRedirect("register.html");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "/auth/login.html";
//	}
//}
