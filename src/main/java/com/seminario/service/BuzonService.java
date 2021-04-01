package com.seminario.service;


import com.seminario.model.Buzon;
import com.seminario.repository.BuzonDao;
import com.seminario.response.RespuestaPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class BuzonService {

    @Autowired
    private BuzonDao buzonDao;
    @Autowired private Optional<Buzon> buzon;

    public ResponseEntity<Object> create(@RequestBody Buzon buzon){
        ResponseEntity<Object> respuesta;
        try {
            buzonDao.save(buzon);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Peticion exitosa ", HttpStatus.OK);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error creando usuario", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    public ResponseEntity<Object> findByid(@RequestParam int id){
        ResponseEntity<Object> respuesta;
        try {
            buzon = buzonDao.findById(id);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Peticion exitosa ", HttpStatus.OK);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error creando usuario", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    public ResponseEntity<Object> edit(@RequestBody Buzon buzon){
        ResponseEntity<Object> respuesta;
        try {
            buzonDao.save(buzon);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Peticion exitosa ", HttpStatus.OK);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error creando usuario", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    public ResponseEntity<Object> list(){
        ResponseEntity<Object> respuesta;
        try {
            List<Buzon> libros = buzonDao.findAll();
            RespuestaPersonalizada res = new RespuestaPersonalizada("Peticion exitosa ", HttpStatus.OK);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(libros,HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>("Error al procesar la peticion.",HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        ResponseEntity<Object> respuesta;
        try {
            buzonDao.deleteById(id);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Peticion exitosa ", HttpStatus.OK);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error creando usuario", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

}
