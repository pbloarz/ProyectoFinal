package com.seminario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seminario.model.FArticulo;
import com.seminario.model.Venta;
import com.seminario.repository.FArticuloDao;

@Service
public class FArticuloService {
	
	@Autowired
	private FArticuloDao farticuloDao;
	
	public FArticulo agregarfac(FArticulo fac) {
		return farticuloDao.save(fac);
	}
	
	public List<FArticulo> obtenerfacs(){
		return farticuloDao.findAll();
	}

}
