package com.seminario.controller;

import java.sql.Date;

import com.seminario.model.Viatico;
import com.seminario.service.ViaticoService;

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

@RestController
@RequestMapping("api/viaticos/")
public class ViaticoController {

    @Autowired
    ViaticoService viaticosService;

    @GetMapping("obtener-viaticos")
    public ResponseEntity<Object> obtenerViaticos(){
        return viaticosService.obtenerViaticos();
    }

    @GetMapping("obtener-viaticos-fechas")
    public ResponseEntity<Object> obtenerViaticosFechas(@RequestParam Date fechaIni, @RequestParam Date fechaFin){
        return viaticosService.obtenerViaticosFechas(fechaIni, fechaFin);
    }

    @PostMapping("agregar-viatico")
    public ResponseEntity<Object> agregarViatico(@RequestBody Viatico viaticoNuevo){
        return viaticosService.agregarViatico(viaticoNuevo);
    }

    @PutMapping("actualizar-viatico")
    public ResponseEntity<Object> actualizarViatico(@RequestBody Viatico viaticoModificar){
        return viaticosService.modificarViatico(viaticoModificar);
    }

    @DeleteMapping("eliminar-viatico")
    public ResponseEntity<Object> eliminarViatico(@RequestParam Integer id){
        return viaticosService.eliminarViatico(id);
    }
}
