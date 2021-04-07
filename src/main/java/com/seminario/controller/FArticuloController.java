package com.seminario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seminario.model.FArticulo;
import com.seminario.model.Venta;
import com.seminario.repository.FArticuloDao;
import com.seminario.service.FArticuloService;

@RestController
@RequestMapping("api/farticulo/")
public class FArticuloController {
	
	@Autowired
	FArticuloDao farticuloDao;
	
	@Autowired
	FArticuloService farticuloService;
	
	@PostMapping(value= "agregar-fac")
	public FArticulo agregarfac(@RequestBody FArticulo fac) {
		return farticuloService.agregarfac(fac);
	}
	
	@GetMapping(value= "obtener-fac")
	public List<FArticulo> farticulos(){
		return farticuloService.obtenerfacs();
	}

}
