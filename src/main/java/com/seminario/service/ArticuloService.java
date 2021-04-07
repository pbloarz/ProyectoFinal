package com.seminario.service;

import java.util.List;
import org.apache.log4j.*;

import com.seminario.model.Articulo;
import com.seminario.repository.ArticuloDao;
import com.seminario.response.RespuestaPersonalizada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ArticuloService {

    private static final Logger logger = Logger.getLogger(ArticuloService.class);

    @Autowired
    ArticuloDao articuloDao;

    public ResponseEntity<Object> agregarArticulo(Articulo articuloNuevo) {
        ResponseEntity<Object> respuesta;
        try {
            Articulo articulo = articuloDao.save(articuloNuevo);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Articulo registrado con exito", HttpStatus.OK);
            res.setObjectoRespuesta(articulo);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error registrando articulo",
                    HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<Object> modificarArticulo(Articulo articuloModificado) {
        ResponseEntity<Object> respuesta;
        try {
            Articulo articulo = articuloDao.save(articuloModificado);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Articulo modificado con exito", HttpStatus.OK);
            res.setObjectoRespuesta(articulo);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error modificando articulo",
                    HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<Object> eliminarArticulo(@RequestParam Integer id) {
        ResponseEntity<Object> respuesta;
        try {
            articuloDao.deleteById(id);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Articulo eliminado con exito", HttpStatus.OK);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error eliminando articulo",
                    HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<Object> listarArticulos() {
        ResponseEntity<Object> respuesta;
        try {
            List<Articulo> listaArticulos = articuloDao.findAll();
            RespuestaPersonalizada res = new RespuestaPersonalizada("Articulos listados con exito", HttpStatus.OK);
            res.setObjectoRespuesta(listaArticulos);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error listando articulos", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<Object> listarArticulosFecha(@RequestParam String fechaInicio, String fechaFin) {
        ResponseEntity<Object> respuesta;
        try {
            List<Articulo> listaArticulos = articuloDao.findByFechaCreacion(fechaInicio, fechaFin);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Articulos listados con exito", HttpStatus.OK);
            res.setObjectoRespuesta(listaArticulos);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error listando articulos", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

}
