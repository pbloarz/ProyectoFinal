package com.seminario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seminario.model.FArticulo;
import com.seminario.model.Venta;

public interface FArticuloDao extends JpaRepository<FArticulo, Integer> {

}
