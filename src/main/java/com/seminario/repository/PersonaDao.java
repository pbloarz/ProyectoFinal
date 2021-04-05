package com.seminario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seminario.model.Persona;

public interface PersonaDao extends JpaRepository<Persona, Integer>{
	//public Persona findByNombre(String nombre);
}
