package com.seminario.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seminario.model.Caja;
@Repository
public interface CajaDao extends JpaRepository<Caja, Integer>{
	@Query
	(value = "select * from caja where fecha >= ?1 AND  fecha < ?2", nativeQuery = true)
	public List<Caja> findByFechaCreacion(String fechaIni, String fechaFin);
}
