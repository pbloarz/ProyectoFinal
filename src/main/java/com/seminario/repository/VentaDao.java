package com.seminario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.seminario.model.Venta;



public interface VentaDao extends JpaRepository<Venta, Integer> {
	
	@Query(value = "select * from ventas where id=?", nativeQuery = true)
	public List<Venta> findByVenta(Integer idVenta);
	
	@Query(value = "select * from ventas where fecha >= ?1 AND  fecha < ?2", nativeQuery = true)
	public List<Venta> findByFecha(String fecha1, String fecha2);
	
	/*@Query
	(value = "select * from proveedor where fecha_creacion >= ?1 AND  fecha_creacion < ?2", nativeQuery = true)
	public List<Caja> findByFechaCreacion(String fechaIni, String fechaFin);*/

}
