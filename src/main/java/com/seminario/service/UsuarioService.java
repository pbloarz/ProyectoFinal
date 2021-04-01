package com.seminario.service;


import com.seminario.model.Usuario;
import com.seminario.repository.UsuarioDao;
import com.seminario.response.RespuestaPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
public class UsuarioService{
    @Autowired private UsuarioDao usuarioDao;
    @Autowired private BCryptPasswordEncoder encoder;
    public ResponseEntity<Object> crear(Usuario usuario){
        ResponseEntity<Object> respuesta;
        try{
            usuario.setClave(encoder.encode(usuario.getClave()));
            usuarioDao.save(usuario);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion de Usuario Exitosa", HttpStatus.OK);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res,HttpStatus.OK);
        }catch (Exception e){
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error alcrear el usuario", HttpStatus.BAD_REQUEST);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    public Usuario obtenerUsuario(String nombre){
        return usuarioDao.findByNombre(nombre);
    }
    public Usuario create(@RequestBody Usuario user){
        return usuarioDao.save(user);
    }
    public void edit(@RequestBody Usuario user){
        usuarioDao.save(user);
    }
    public void delete(@PathVariable("id") Integer id){
        usuarioDao.deleteById(id);
    }
    public ResponseEntity<Object> list(){
        ResponseEntity<Object> respuesta;
        try {
            List<Usuario> users = usuarioDao.findAll();
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(users,HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>("Disculpenos tenemos un error",HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
