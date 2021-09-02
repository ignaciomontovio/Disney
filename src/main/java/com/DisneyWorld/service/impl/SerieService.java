package com.DisneyWorld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DisneyWorld.repo.ISerieRepo;
import com.DisneyWorld.service.ISerieService;

@Service
public class SerieService implements ISerieService{

	@Autowired
	private ISerieRepo serieRepo;
}
