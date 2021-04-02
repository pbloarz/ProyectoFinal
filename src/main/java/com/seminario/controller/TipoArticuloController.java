/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seminario.controller;

import com.seminario.model.TipoArticulo;
import com.seminario.service.TipoArticuloService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<TipoArticulo> obtenerTArticulos() {
        return TipoArticuloService.obtenerTArticulos();
    }
    
    @PostMapping(value = "crear-tipo-articulo")
    public TipoArticulo crearTArticulo(@RequestBody TipoArticulo t) {
        return TipoArticuloService.crearTArticulo(t);        
    }
    
    @PutMapping(value = "editar-tipo-articulo")
    public TipoArticulo editarTArticulo(@RequestBody TipoArticulo t) {
        return TipoArticuloService.editarTArticulo(t);
    }
    
    @DeleteMapping(value= "eliminar-tipo-articulo")
    public void eliminarTArticulo(@RequestParam int idTA) {
       TipoArticuloService.eliminarTArticulo(idTA);
    } 
}
