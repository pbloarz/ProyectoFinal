package com.seminario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seminario.model.Caja;
import com.seminario.repository.CajaDao;

@Service
public class CajaService{
	
	@Autowired
	private CajaDao cajadao;
	
	public Caja agregarCaja(Caja caja) {
		
		return cajadao.save(caja);
	}

	

}
