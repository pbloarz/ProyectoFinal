/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seminario.service;

import com.seminario.model.TipoArticulo;
import com.seminario.repository.TipoArticuloDao;
import com.seminario.response.RespuestaPersonalizada;
import com.seminario.service.TipoArticuloService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class TipoArticuloService {
    
    private static final Logger logger = Logger.getLogger(TipoArticuloService.class);
    
    @Autowired
    public TipoArticuloDao TipoArticuloDao;
    
    public ResponseEntity<Object> obtenerTArticulos() {
        ResponseEntity<Object> respuesta;
        try {
            List<TipoArticulo> tarticulos = TipoArticuloDao.findAll();
            if (tarticulos.isEmpty()) {
                throw new Exception("Error");
            }
            RespuestaPersonalizada res = new RespuestaPersonalizada("Busqueda de tipos de articulos con exito", HttpStatus.OK);
            res.setObjectoRespuesta(tarticulos);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
            logger.isTraceEnabled();
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error buscando tipos de articulos", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
        //return TipoArticuloDao.findAll();
    }
    
    public ResponseEntity<Object> crearTArticulo(@RequestBody TipoArticulo t) {
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion de tipo de articulos con exito", HttpStatus.OK);
            res.setObjectoRespuesta(TipoArticuloDao.save(t));
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
            logger.isTraceEnabled();
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error creando tipo de articulos", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
        //return TipoArticuloDao.save(t);
    }
    
    public ResponseEntity<Object> editarTArticulo(@RequestBody TipoArticulo t) {
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Modificacion de tipo de articulos con exito", HttpStatus.OK);
            res.setObjectoRespuesta(TipoArticuloDao.save(t));
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
            logger.isTraceEnabled();
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error modificando tipos de articulos", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
        //return TipoArticuloDao.save(t);
    }
    
    public void eliminarTArticulo(@RequestParam Integer idTA) {
        ResponseEntity<Object> respuesta;
        try {
            RespuestaPersonalizada res = new RespuestaPersonalizada("Eliminacion de tipo de articulos con exito", HttpStatus.OK);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
            logger.isTraceEnabled();
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error eliminando tipos de articulos", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        TipoArticuloDao.deleteById(idTA);
    }
    
    public ResponseEntity<Object> listarTAFecha(@RequestParam String d1, String d2) {
        ResponseEntity<Object> respuesta;
        try {

            List<TipoArticulo> taFechas = TipoArticuloDao.findAll();
            if (taFechas.isEmpty()) {
                throw new Exception("Error");
            }

            RespuestaPersonalizada res = new RespuestaPersonalizada("Busqueda de tipos de articulos por fecha realizada con exito", HttpStatus.OK);
            res.setObjectoRespuesta(TipoArticuloDao.listarTAFecha(d1, d2));
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
            logger.isTraceEnabled();
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error listando tipos de articulos por fechas", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
        
        //return TipoArticuloDao.listarTAFecha(d1, d2);
    }
}
