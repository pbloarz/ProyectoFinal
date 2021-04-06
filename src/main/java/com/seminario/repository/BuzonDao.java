package com.seminario.repository;


import java.util.List;

import javax.transaction.Transactional;

import com.seminario.model.Buzon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BuzonDao extends JpaRepository<Buzon,Integer> {
    
    @Query(value = "SELECT * FROM buzon WHERE fecha  BETWEEN 1? AND ?2", nativeQuery = true)
	public List<Buzon> findByRangeDate(String desde, String hasta);
}
