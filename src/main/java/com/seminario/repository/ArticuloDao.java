package com.seminario.repository;

import java.util.Date;

import com.seminario.model.Articulo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloDao extends JpaRepository<Articulo, Integer> {

    public Articulo findByFechaCreacion(Date fechaCreacion);
}
