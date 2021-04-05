package com.seminario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.seminario.model.Caja;
import com.seminario.service.CajaService;

@RestController
@RequestMapping(value = "api/caja")
public class CajaController {
	
	@Autowired
	private CajaService cajaservice;
	
	@GetMapping(value="vercajas")
	public ResponseEntity<Object> vercajas(){
		return cajaservice.vercajas();
	}

	@PostMapping(value="crear")
	public ResponseEntity<Object> agregar(@RequestBody Caja caja) {
		return cajaservice.crearcaja(caja);
	}
	
	@PutMapping(value="modificar")
	public ResponseEntity<Object> modificar(@RequestBody Caja caja) {
		return cajaservice.modificarCaja(caja);
	}
	
	@DeleteMapping(value="eliminar")
	public void eliminar(@RequestParam Integer id_caja) {
		cajaservice.eliminarCaja(id_caja);
	}

	@GetMapping("listarfechas")
	public ResponseEntity<Object> obtenercajasFechas(@RequestParam String fechaIni, String fechaFin){
		return cajaservice.obtenercajasFechas(fechaIni, fechaFin);
	}
  
	
}




