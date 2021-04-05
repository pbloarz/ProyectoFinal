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

import com.seminario.model.Persona;

import com.seminario.service.PersonaService;

@RestController
@RequestMapping("api/persona/")
public class PersonaController {
	
    @Autowired
    private PersonaService personaService;
    
    @GetMapping(value = "listar-persona")
    public ResponseEntity<Object> obtenerPersona() {
        return personaService.obtenerPersona();
    }
    
    @PostMapping(value = "crear-persona")
    public ResponseEntity<Object> crearPersona(@RequestBody Persona persona) {
        return personaService.crearPersona(persona);        
    }
    
    @PutMapping(value = "editar-persona")
    public ResponseEntity<Object> editarPersona(@RequestBody Persona persona) {
        return personaService.editarPersona(persona);
    }
    
    @DeleteMapping(value= "eliminar-persona")
    public void eliminarPersona(@RequestParam int id) {
       personaService.eliminarPersona(id);
    }   

}
