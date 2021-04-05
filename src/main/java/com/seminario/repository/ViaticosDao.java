package com.seminario.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.seminario.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ViaticosDao extends JpaRepository<Viatico,Integer> {
    
    @Modifying
    @Query(value ="SELECT * FROM prueba_final.viaticos WHERE via_fec BETWEEN :fechaIni AND :fechaFin", nativeQuery = true)
	public List<Viatico> findByFechas(Date fechaIni, Date fechaFin);
}
