package com.seminario.controller;

import java.util.Date;
import java.util.List;

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

import com.seminario.model.Articulo;
import com.seminario.model.FArticulo;
import com.seminario.model.Venta;
import com.seminario.repository.ArticuloDao;
import com.seminario.repository.VentaDao;


import com.seminario.service.VentaService;


@RestController
@RequestMapping("api/venta/")
public class VentaController {
	
	
	@Autowired
	VentaService ventaService;
	
	@Autowired
	VentaDao ventaDao;
	
	ArticuloDao articuloDao;
	
	
	
	


	
	
	
	/********************************* Try and Catch ***********************************************/
	
	@PostMapping(value= "crear-venta")
	public ResponseEntity<Object> crearVenta(@RequestBody Venta venta) {
		return ventaService.crearVenta(venta);
	}
	
	@GetMapping(value="get-ventas")
	public ResponseEntity<Object> obtenerVentasRespuesta(){
		return ventaService.obtenerVentasRespuesta();
	}
	
	@GetMapping(value = "get-venta-id")
	public ResponseEntity<Object> obtenerVentaId(@RequestParam Integer id){
		return ventaService.obtenerVentaId(id);
	}
	
	@PutMapping("modificar-venta-Respuesta")
	public ResponseEntity<Object> modificarVenta(@RequestBody Venta venta) {
		return ventaService.modificarVentaRespuesta(venta);
	}
	
	@PutMapping("modificar-venta-paramres")
	public ResponseEntity<Object> modificarVentaParamRes(@RequestParam Integer id, @RequestParam String nit,@RequestParam String direccion, @RequestParam Integer telefono, @RequestParam String listaArticulos, @RequestParam Integer totalVenta, @RequestParam Integer dineroRecibido,@RequestParam String fecha, @RequestParam String vendedor, @RequestParam String cajaFacturada){
		return ventaService.modificarVentaParamRes(id, nit, direccion, telefono, listaArticulos, totalVenta, dineroRecibido, fecha, vendedor, cajaFacturada);
	}
	
	@DeleteMapping("eliminar-venta-id-Respuesta")
	public ResponseEntity<Object> eliminarVentaRespuesta(@RequestParam Integer id) {
		return ventaService.eliminarVentaRespuesta(id);
	}
	
	@GetMapping("buscar-venta-fecha")
	public ResponseEntity<Object> buscarVentaPorFecha(@RequestParam String fecha1, @RequestParam String fecha2 ){
		return ventaService.obtenerVentaPorFecha(fecha1, fecha2);
	}
	
	/*********************************NORMAL***********************************************/
	
	@PostMapping(value= "agregar-venta")
	public Venta agregarVenta(@RequestBody Venta venta) {
		return ventaService.agregarVenta(venta);
	}
	
	@GetMapping(value= "obtener-ventas")
	public List<Venta> Ventas(){
		return ventaService.obtenerVentas();
	}
	
	@PutMapping("modificar-venta")
	public void modificarVentaSimple(@RequestBody Venta venta) {
		ventaService.modificarVenta(venta);
	}
	
	@PutMapping("modificar-venta-parametros")
	public void modificarVentaParametro(@RequestParam Integer id, @RequestParam String nit,@RequestParam String direccion, @RequestParam Integer telefono, @RequestParam String listaArticulos, @RequestParam Integer totalVenta, @RequestParam Integer dineroRecibido,@RequestParam String fecha, @RequestParam String vendedor, @RequestParam String cajaFacturada) {
	
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
			ventaService.modificarVenta(venta);		
	}
	
	@DeleteMapping("eliminar-venta-id")
	public void eliminarVenta(@RequestParam Integer id) {
		ventaService.eliminarVenta(id);
	}
	
	/*@PutMapping("probando")
	public void probandoCosas(@RequestParam Integer id) {
		Venta venta = ventaDao.findById(id).orElse(null);
		Articulo articulo = articuloDao.findById(2).orElse(null);
		
		venta.setCambio(articulo.getPrecioVenta());
		ventaService.modificarVenta(venta);
		
		
	}*/
	

}
