package com.seminario.repository;



import java.util.List;

import com.seminario.model.Compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraDao extends JpaRepository<Compra, Integer> {

    @Query(value = "SELECT * FROM compra WHERE fechaYHora >= ?1 AND  fechaYHora <= ?2", nativeQuery = true)
    public List<Compra> findByfechaYHora(String fechaIni, String fechaFin);
}
