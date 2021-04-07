/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seminario.repository;

import com.seminario.model.TipoArticulo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos
 */
@Repository
public interface TipoArticuloDao extends JpaRepository<TipoArticulo, Integer>{
    @Query(value = "select * from tarticulo where fecha_creacion >= ?1 AND  fecha_creacion < ?2 ", nativeQuery= true )
    public List<TipoArticulo> listarTAFecha(String d1, String d2);
}
