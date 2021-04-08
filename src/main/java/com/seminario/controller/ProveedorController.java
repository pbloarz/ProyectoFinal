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

import com.seminario.model.Proveedor;
import com.seminario.service.ProveedorService;

@RestController
@RequestMapping("api/proveedor/")
public class ProveedorController {
	
	@Autowired
	private ProveedorService proveedorService;
	
	@PostMapping("crear")
	public ResponseEntity<Object> crearProveedor(@RequestBody Proveedor proveedorN) {
		return proveedorService.crearProveedor(proveedorN);
	}
	
	@GetMapping("listar")
	public ResponseEntity<Object> obtenerProveedores(){
		return proveedorService.obtenerProveedores();
	}
	
	@GetMapping("listar-fechas")
	public ResponseEntity<Object> obtenerProveedoresFechas(@RequestParam String fechaIni, String fechaFin){
		return proveedorService.obtenerProveedoresFechas(fechaIni, fechaFin);
	}
	
	@PutMapping("modificar")
	public ResponseEntity<Object> modificarProveedor(@RequestBody Proveedor proveedorN) {
		return proveedorService.modificarProveedor(proveedorN);
	}
	
	@DeleteMapping("eliminar")
	public ResponseEntity<Object> eliminarProveedor(@RequestParam Integer id) {
		return proveedorService.eliminarProveedor(id);
	}

}
