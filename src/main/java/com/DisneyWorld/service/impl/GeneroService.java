package com.DisneyWorld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DisneyWorld.repo.IGeneroRepo;
import com.DisneyWorld.service.IGeneroService;

@Service
public class GeneroService implements IGeneroService{

	@Autowired
	private IGeneroRepo generoRepo;
}
