package com.seminario.controller;



import com.seminario.model.Compra;
import com.seminario.service.CompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/compra")
public class CompraController {

    @Autowired
    CompraService compraService;

    @PostMapping(value = "agregar-compra")
    public ResponseEntity<Object> agregarCompra(@RequestBody Compra compraNueva) {
        return compraService.agregarCompra(compraNueva);
    }

    @PutMapping(value = "modificar-compra")
    public ResponseEntity<Object> modifcarCompra(@RequestBody Compra compraModificado) {
        return compraService.modificarCompra(compraModificado);
    }

    @DeleteMapping(value = "eliminar-compra")
    public ResponseEntity<Object> eliminarCompra(@RequestParam Integer id) {
        return compraService.eliminarCompra(id);
    }

    @GetMapping(value = "listar-compras")
    public ResponseEntity<Object> listarCompras() {
        return compraService.listarCompras();
    }

    @GetMapping("listar-fechas")
	public ResponseEntity<Object> listarComprasFecha(@RequestParam String fechaInicio, String fechaFin){
		return compraService.listarComprasFecha(fechaInicio, fechaFin);
	}

}