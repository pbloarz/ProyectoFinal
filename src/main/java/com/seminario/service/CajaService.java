package com.seminario.service;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.seminario.model.Caja;
import com.seminario.repository.CajaDao;
import com.seminario.response.RespuestaPersonalizada;

@Service
public class CajaService{
	
	private static final Logger logger = Logger.getLogger(CajaService.class);
	
	@Autowired
	private CajaDao cajadao;
	
	public ResponseEntity<Object> crearcaja(@RequestBody Caja cajan) {
		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion de caja ha sido exitosa", HttpStatus.OK);
			res.setObjectoRespuesta(cajadao.save(cajan));
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		}catch(Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de crear la", HttpStatus.BAD_REQUEST);
			
		}
		return respuesta;	
	}
	
	public ResponseEntity<Object> vercajas() {
		ResponseEntity<Object> respuesta;
		try {
			List<Caja> cajas = cajadao.findAll();
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de cajas exitosa", HttpStatus.OK);
			res.setObjectoRespuesta(cajas);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		}catch(Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar las cajas", HttpStatus.BAD_REQUEST);
			
		}
		return respuesta;
	}
	
	public ResponseEntity<Object> modificarCaja(@RequestBody Caja cajan) {
		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Actualizacion de caja exitosa", HttpStatus.OK);
			res.setObjectoRespuesta(cajadao.save(cajan));
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		}catch(Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("No se pudo actulizar caja", HttpStatus.BAD_REQUEST);
			
		}
		return respuesta;

	}
	
			
	public void  eliminarCaja(@RequestParam Integer id_caja) {
		cajadao.deleteById(id_caja);
	}
	
	public ResponseEntity<Object> obtenercajasFechas(@RequestParam String fechaIni, String fechaFin) {
		ResponseEntity<Object> respuesta;
		try {
			List<Caja> cajas = cajadao.findByFechaCreacion(fechaIni, fechaFin);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Consulta de cajas segun el rango de fecha exitosa", HttpStatus.OK);
			res.setObjectoRespuesta(cajas);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res, HttpStatus.OK);
		}catch(Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpa tenemos un error tratando de consultar los proveedores en el rango de fechas", HttpStatus.BAD_REQUEST);
			
		}
		return respuesta;
	}

    

}