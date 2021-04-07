package com.seminario.service;

import java.util.Date;
import java.util.List;
import org.apache.log4j.*;

import com.seminario.model.Compra;
import com.seminario.repository.CompraDao;
import com.seminario.response.RespuestaPersonalizada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CompraService {

    private static final Logger logger = Logger.getLogger(CompraService.class);

    @Autowired
    CompraDao compraDao;

    public ResponseEntity<Object> agregarCompra(Compra compraNuevo) {
        ResponseEntity<Object> respuesta;
        try {
            Compra compra = compraDao.save(compraNuevo);
            RespuestaPersonalizada res = new RespuestaPersonalizada("compra registrado con exito", HttpStatus.OK);
            res.setObjectoRespuesta(compra);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error registrando compra",
                    HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<Object> modificarCompra(Compra compraModificado) {
        ResponseEntity<Object> respuesta;
        try {
            Compra compra = compraDao.save(compraModificado);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Compra modificada con exito", HttpStatus.OK);
            res.setObjectoRespuesta(compra);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error modificando compra",
                    HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<Object> eliminarCompra(@RequestParam Integer id) {
        ResponseEntity<Object> respuesta;
        try {
            compraDao.deleteById(id);
            RespuestaPersonalizada res = new RespuestaPersonalizada("compra eliminado con exito", HttpStatus.OK);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error eliminando compra",
                    HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<Object> listarCompras() {
        ResponseEntity<Object> respuesta;
        try {
            List<Compra> listaCompras = compraDao.findAll();
            RespuestaPersonalizada res = new RespuestaPersonalizada("Compras listadas con exito", HttpStatus.OK);
            res.setObjectoRespuesta(listaCompras);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error listando compras", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<Object> listarComprasFecha(@RequestParam String fechaInicio, String fechaFin) {
        ResponseEntity<Object> respuesta;
        try {
            List<Compra> listaCompras = compraDao.findByfechaYHora(fechaInicio, fechaFin);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Compras listadas con exito", HttpStatus.OK);
            res.setObjectoRespuesta(listaCompras);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error listando compras", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

}
