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
    
    
    @Query(value = "SELECT * FROM buzon where fecha >= ?1 and fecha <= ?2",nativeQuery = true)
	public List<Buzon> findByRangeDate(String desde, String hasta);
}
