package com.seminario.controller;

import java.util.Date;

import com.seminario.model.Articulo;
import com.seminario.service.ArticuloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/articulo")
@CrossOrigin(origins = "*")
public class ArticuloController {

    @Autowired
    ArticuloService articuloService;

    @PostMapping(value = "agregar-articulo")
    public ResponseEntity<Object> agregarArticulo(@RequestBody Articulo articuloNuevo) {
        return articuloService.agregarArticulo(articuloNuevo);
    }

    @PutMapping(value = "modificar-articulo")
    public ResponseEntity<Object> modifcarArticulo(@RequestBody Articulo articuloModificado) {
        return articuloService.modificarArticulo(articuloModificado);
    }

    @DeleteMapping(value = "eliminar-articulo")
    public ResponseEntity<Object> eliminarArticulo(@RequestParam Integer id) {
        return articuloService.eliminarArticulo(id);
    }

    @GetMapping(value = "listar-articulos")
    public ResponseEntity<Object> listarArticulos() {
        return articuloService.listarArticulos();
    }

    @GetMapping("listar-fechas")
	public ResponseEntity<Object> listarArticulosFecha(@RequestParam String fechaInicio, String fechaFin){
		return articuloService.listarArticulosFecha(fechaInicio, fechaFin);
	}

}
