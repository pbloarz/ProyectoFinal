package com.seminario.repository;


import com.seminario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao  extends JpaRepository<Usuario, Integer> {
    public Usuario findByNombre(String nombre);
}
