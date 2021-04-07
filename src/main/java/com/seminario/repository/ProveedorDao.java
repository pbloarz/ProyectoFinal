package com.seminario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seminario.model.Proveedor;

@Repository
public interface ProveedorDao extends JpaRepository<Proveedor, Integer>{
	
	@Query(value = "select * from proveedor where fecha_creacion >= ?1 AND  fecha_creacion <= ?2", nativeQuery = true)
	public List<Proveedor> findByFechaCreacion(String fechaIni, String fechaFin);

}
