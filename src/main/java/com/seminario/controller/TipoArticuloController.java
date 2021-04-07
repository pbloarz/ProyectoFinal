/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seminario.controller;

import com.seminario.model.TipoArticulo;
import com.seminario.service.TipoArticuloService;
import java.io.Serializable;
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

/**
 *
 * @author Carlos
 */
@RestController
@RequestMapping("api/tipo-articulo")
@CrossOrigin(origins= "*")
public class TipoArticuloController implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private TipoArticuloService TipoArticuloService;
    
    @GetMapping(value = "listar-tipos-articulos")
    public ResponseEntity<Object> obtenerTArticulos() {
        return TipoArticuloService.obtenerTArticulos();
    }
    
    @PostMapping(value = "crear-tipo-articulo")
    public ResponseEntity<Object> crearTArticulo(@RequestBody TipoArticulo t) {
        return TipoArticuloService.crearTArticulo(t);        
    }
    
    @PutMapping(value = "editar-tipo-articulo")
    public ResponseEntity<Object> editarTArticulo(@RequestBody TipoArticulo t) {
        return TipoArticuloService.editarTArticulo(t);
    }
    
    @DeleteMapping(value= "eliminar-tipo-articulo")
    public ResponseEntity<Object> eliminarTArticulo(@RequestParam int id) {
       TipoArticuloService.eliminarTArticulo(id);
       return TipoArticuloService.eliminarTArticulo(id);
    }
    
    @GetMapping(value = "listar-fechas-TA")
    public ResponseEntity<Object> listarTAFecha(@RequestParam String d1, @RequestParam String d2){
        return TipoArticuloService.listarTAFecha(d1, d2);
    }
}
