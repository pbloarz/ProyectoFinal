package com.seminario.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.seminario.model.Articulo;
import com.seminario.model.FArticulo;
import com.seminario.model.Venta;
import com.seminario.repository.ArticuloDao;
import com.seminario.repository.FArticuloDao;
import com.seminario.repository.VentaDao;
import com.seminario.response.RespuestaPersonalizada;


@Service
public class VentaService {
	
	private static final Logger logger = Logger.getLogger(ArticuloService.class);
	
	@Autowired
	private VentaDao ventaDao;
	
	ArticuloDao articuloDao;
	Articulo articulo;
	FArticulo farticulo;
	FArticuloDao farticuloDao;
	
	
	
	
	/********************************* Try and Catch ***********************************************/
	
	public ResponseEntity<Object> crearVenta(Venta venta){
		ResponseEntity<Object> respuesta;
		try {
			double precio=0;
			
	    	for (FArticulo farticulo : venta.getFarticulos()) 
	    	{
				precio+=((farticulo.getArticulos().getPrecioVenta())*farticulo.getCantidad());
			}
	    	venta.setTotalVenta(precio);
	    	venta.setCambio(venta.getDineroRecibido()-precio);
	    	
			ventaDao.save(venta);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Venta creada exitosamente", HttpStatus.OK);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res,HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpenos tenemos un error",HttpStatus.BAD_REQUEST);
			
		}
		return respuesta;
	}
	
	public ResponseEntity<Object> obtenerVentasRespuesta(){
		ResponseEntity<Object> respuesta;
		try {
			RespuestaPersonalizada res = new RespuestaPersonalizada("Busqueda de Ventas con exito", HttpStatus.OK);
			List<Venta> ventas= ventaDao.findAll();
			res.setObjectoRespuesta(ventas);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res,HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpenos tenemos un error",HttpStatus.BAD_REQUEST);
			
		}
		return respuesta;
	}
	
	public ResponseEntity<Object> obtenerVentaId(Integer idVenta){
		ResponseEntity<Object> respuesta;
		try {
			List<Venta> ventas =  ventaDao.findByVenta(idVenta);
			if (ventas.size()==0) 
			{
				throw new Exception("Error");
			}
			RespuestaPersonalizada res = new RespuestaPersonalizada("Busqueda de Ventas con exito", HttpStatus.OK);
			res.setObjectoRespuesta(ventas);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res,HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Error buscando Ventas", HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
		}
		return respuesta;
		
	}
	
    public ResponseEntity<Object> modificarVentaRespuesta(Venta venta){
		ResponseEntity<Object> respuesta;
		try {
			ventaDao.save(venta);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Venta actualizada con exito", HttpStatus.OK);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res,HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpenos tenemos un error",HttpStatus.BAD_REQUEST);
			
		}
		return respuesta;
	}
    
    public ResponseEntity<Object> modificarVentaParamRes(@RequestParam Integer id, @RequestParam String nit,@RequestParam String direccion, @RequestParam Integer telefono, @RequestParam String listaArticulos, @RequestParam Integer totalVenta, @RequestParam Integer dineroRecibido,@RequestParam String fecha, @RequestParam String vendedor, @RequestParam String cajaFacturada){
		ResponseEntity<Object> respuesta;
		try {
			Venta venta = ventaDao.findById(id).orElse(null);
			venta.setId(id);
			venta.setNit(nit);
			venta.setDireccion(direccion);
			venta.setTelefono(telefono);
			//venta.setListaArticulos(listaArticulos);
			//venta.setTotalVenta(totalVenta);
			//venta.setDineroRecibido(dineroRecibido);
			venta.setFecha(fecha);
			venta.setVendedor(vendedor);
			//venta.setCajaFacturada(cajaFacturada);
			ventaDao.save(venta);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Venta actualizada con exito", HttpStatus.OK);
			res.setObjectoRespuesta(venta);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res,HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpenos tenemos un error",HttpStatus.BAD_REQUEST);
			
		}
		return respuesta;
	}
    
    public ResponseEntity<Object> eliminarVentaRespuesta(Integer id){
		ResponseEntity<Object> respuesta;
		try {
			ventaDao.deleteById(id);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Venta eliminada satisfactoriamente", HttpStatus.OK);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res,HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>("Disculpenos tenemos un error",HttpStatus.BAD_REQUEST);
			
		}
		return respuesta;
	}
    
    public ResponseEntity<Object> obtenerVentaPorFecha(String fecha1, String fecha2){
		ResponseEntity<Object> respuesta;
		try {
			List<Venta> ventas =  ventaDao.findByFecha(fecha1, fecha2);
			if (ventas.size()==0) 
			{
				throw new Exception("Error");
			}
			RespuestaPersonalizada res = new RespuestaPersonalizada("Busqueda de Ventas con exito", HttpStatus.OK);
			res.setObjectoRespuesta(ventas);
			respuesta = ResponseEntity.ok(HttpStatus.OK);
			respuesta = new ResponseEntity<>(res,HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error(e);
			respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
			RespuestaPersonalizada res = new RespuestaPersonalizada("Error buscando Ventas", HttpStatus.BAD_REQUEST);
			respuesta = new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
		}
		return respuesta;
		
	}
	
    /*********************************NORMAL***********************************************/
    
    public Venta agregarVenta(Venta venta) {
    	double precio=0;
    	for (FArticulo farticulo : venta.getFarticulos()) 
    	{
			precio+=((farticulo.getArticulos().getPrecioVenta())*farticulo.getCantidad());
		}
    	venta.setTotalVenta(precio);
    	venta.setCambio(venta.getDineroRecibido()-precio);
		return ventaDao.save(venta);
	}
	
	public List<Venta> obtenerVentas(){
		return ventaDao.findAll();
	}
	
    public Venta modificarVenta(Venta venta) {
    	return ventaDao.save(venta);
    }
    
    public void eliminarVenta(Integer id) {
    	ventaDao.deleteById(id);
    }
    
}
