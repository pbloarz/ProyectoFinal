package com.seminario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.seminario.model.Persona;


public interface PersonaDao extends JpaRepository<Persona, Integer>{
	public Persona findByRol(String rol);
	public Persona findByNombre(String nombre);
	
	@Query(value = "select * from persona where nacimiento >= ?1 AND  nacimiento < ?2", nativeQuery = true)
	public List<Persona> findByFechaNacimiento(String fechaIni, String fechaFin);

}
