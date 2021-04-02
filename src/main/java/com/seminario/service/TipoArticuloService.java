/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seminario.service;

import com.seminario.model.TipoArticulo;
import com.seminario.repository.TipoArticuloDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Carlos
 */
@Service
public class TipoArticuloService {
    
    @Autowired
    public TipoArticuloDao TipoArticuloDao;
    
    public List<TipoArticulo> obtenerTArticulos() {
        return TipoArticuloDao.findAll();
    }
    
    public TipoArticulo crearTArticulo(@RequestBody TipoArticulo t) {
        return TipoArticuloDao.save(t);
    }
    
    public TipoArticulo editarTArticulo(@RequestBody TipoArticulo t) {
        return TipoArticuloDao.save(t);
    }
    
    public void eliminarTArticulo(@RequestParam Integer idTA) {
        TipoArticuloDao.deleteById(idTA);
    }
}
