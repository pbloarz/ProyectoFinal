package com.seminario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.log4j.Logger;

import com.seminario.model.Persona;
import com.seminario.repository.PersonaDao;
import com.seminario.response.RespuestaPersonalizada;

@Service
public class PersonaService{
	
    @Autowired
    private PersonaDao personaDao;
    
   /* @Autowired
    private BCryptPasswordEncoder encoder;*/
    
    private static final Logger logger = Logger.getLogger(PersonaService.class);
    
    public ResponseEntity<Object> obtenerPersona() {
        ResponseEntity<Object> respuesta;
        
        try {
        	List<Persona> personas = personaDao.findAll();
        	RespuestaPersonalizada resp = new RespuestaPersonalizada("Consulta de personas exitosa", HttpStatus.OK);
        	resp.setObjectoRespuesta(personas);
        	respuesta = ResponseEntity.ok(HttpStatus.OK);
        	respuesta = new ResponseEntity<>(resp, HttpStatus.OK);        	
        } catch (Exception e) {
        	logger.error(e);
        	respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        	respuesta = new ResponseEntity<>("Error consultando personas", HttpStatus.BAD_REQUEST);
        }
        return respuesta;        
    }
    
    public ResponseEntity<Object> crearPersona(@RequestBody Persona persona) {
        ResponseEntity<Object> respuesta;
        try {
        	//persona.setClave(encoder.encode(persona.getClave()));
        	
        	RespuestaPersonalizada resp = new RespuestaPersonalizada("Creacion de pesona con exito", HttpStatus.OK);
        	resp.setObjectoRespuesta(personaDao.save(persona));
        	respuesta = ResponseEntity.ok(HttpStatus.OK);
        	respuesta = new ResponseEntity<>(resp, HttpStatus.OK);        	
        }catch (Exception e) {        	
        	logger.error(e);
        	respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        	respuesta = new ResponseEntity<>("Hay un error creando persona", HttpStatus.BAD_REQUEST);        	
        }        
        return respuesta;
    }
    
    public ResponseEntity<Object> editarPersona(@RequestBody Persona persona) {
    	ResponseEntity<Object> respuesta;
    	try {
    		RespuestaPersonalizada resp = new RespuestaPersonalizada("Se edito correctamente", HttpStatus.OK);
    		resp.setObjectoRespuesta(personaDao.save(persona));
    		respuesta = ResponseEntity.ok(HttpStatus.OK);
    		respuesta = new ResponseEntity<>(resp, HttpStatus.OK);    		
    	} catch(Exception e){
    		logger.error(e);
    		respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    		respuesta = new ResponseEntity<Object>("Hubo un error tratando de editar persona", HttpStatus.BAD_REQUEST);    		
    	} 
    	return respuesta;    	
    }
    
    public void eliminarPersona(@RequestParam Integer id) {
        personaDao.deleteById(id);
    }    
    /*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Persona persona = personaDao.findByNombre(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		UserDetails user = new User(persona.getNombre(), persona.getClave(), authorities);
		return user;
	}
	
	public Persona obtenerUnaPersona(String nombre) {
		return personaDao.findByNombre(nombre);
	}*/

}
