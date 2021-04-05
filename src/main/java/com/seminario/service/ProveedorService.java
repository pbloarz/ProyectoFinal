package com.seminario.service;

import java.util.List;

import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.seminario.model.Proveedor;
import com.seminario.repository.ProveedorDao;
import com.seminario.response.RespuestaPersonalizada;

@Service
public class ProveedorService {

	private static final Logger logger = Logger.getLogger(ProveedorService.class);
	
	@Autowired
	private ProveedorDao proveedorDao;

	public ResponseEntity<Object> crearProveedor(@RequestBody Proveedor proveedorN) {
		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion de proveedor con exito", HttpStatus.OK);
			res.setObjectoRespuesta(proveedorDao.save(proveedorN));
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		}catch(Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de crear el proveedor", HttpStatus.BAD_REQUEST);
			
		}
		return respuesta;	
	}

	public ResponseEntity<Object> obtenerProveedores() {
		ResponseEntity<Object> respuesta;
		try {
			List<Proveedor> proveedores = proveedorDao.findAll();
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de los proveedores exitosa", HttpStatus.OK);
			res.setObjectoRespuesta(proveedores);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		}catch(Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los proveedores", HttpStatus.BAD_REQUEST);
			
		}
		return respuesta;
	}
	
	public ResponseEntity<Object> obtenerProveedoresFechas(@RequestParam String fechaIni, String fechaFin) {
		ResponseEntity<Object> respuesta;
		try {
			List<Proveedor> proveedores = proveedorDao.findByFechaCreacion(fechaIni, fechaFin);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de los proveedores segun el rango de fecha exitosa", HttpStatus.OK);
			res.setObjectoRespuesta(proveedores);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		}catch(Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los proveedores en el rango de fechas", HttpStatus.BAD_REQUEST);
			
		}
		return respuesta;
	}

	public ResponseEntity<Object> modificarProveedor(@RequestBody Proveedor proveedorN) {
		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Modificacion del proveedor exitosa", HttpStatus.OK);
			res.setObjectoRespuesta(proveedorDao.save(proveedorN));
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		}catch(Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de modificar el proveedor", HttpStatus.BAD_REQUEST);
			
		}
		return respuesta;

	}

	public void eliminarProveedor(@RequestParam Integer id) {
		proveedorDao.deleteById(id);
	}

}
