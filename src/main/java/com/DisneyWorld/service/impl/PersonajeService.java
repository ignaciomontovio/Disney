package com.DisneyWorld.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DisneyWorld.model.Personaje;
import com.DisneyWorld.service.IPersonajeService;

@Service
public class PersonajeService implements IPersonajeService{

	@Autowired
	private IPersonajeService personajeService;

	@Override
	public List<Personaje> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
