package com.seminario.repository;


import com.seminario.model.Buzon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuzonDao extends JpaRepository<Buzon,Integer> {
}
