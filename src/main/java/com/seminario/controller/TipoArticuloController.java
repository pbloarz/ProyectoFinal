/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seminario.controller;

import com.seminario.model.TipoArticulo;
import com.seminario.service.TipoArticuloService;
import java.io.Serializable;
import java.util.Date;

import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
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
    public void eliminarTArticulo(@RequestParam int id) {
       TipoArticuloService.eliminarTArticulo(id);
    }
    
    @GetMapping(value = "listar-fechas-TA")
    public List<TipoArticulo> listarTAFecha(@RequestParam String d1, @RequestParam String d2){
		return (List<TipoArticulo>) TipoArticuloService.listarTAFecha(d1, d2);
    }
}
