package com.seminario.repository;

import java.util.List;

import com.seminario.model.Articulo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloDao extends JpaRepository<Articulo, Integer> {

    @Query(value = "SELECT * FROM articulo WHERE fecha_creacion >= ?1 AND  fecha_creacion <= ?2", nativeQuery = true)
    public List<Articulo> findByFechaCreacion(String fechaIni, String fechaFin);
}
