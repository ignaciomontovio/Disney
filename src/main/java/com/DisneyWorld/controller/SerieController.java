package com.DisneyWorld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DisneyWorld.service.ISerieService;

@RestController
@RequestMapping("/serie")
public class SerieController {

	@Autowired
	private ISerieService serieService;
}
