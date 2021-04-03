package com.seminario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.seminario.model.Caja;
import com.seminario.service.CajaService;

@RestController
@RequestMapping(value = "caja/")
public class CajaController {
	
	@Autowired
	private CajaService cajaservice;

	@PostMapping(value="anadir")
	public Caja agregar(@RequestBody Caja caja) {
		return cajaservice.agregarCaja(caja);
	}
}
