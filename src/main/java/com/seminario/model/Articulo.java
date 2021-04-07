package com.seminario.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fechaCreacion = String.valueOf(LocalDate.now());
    @OneToOne
    @JoinColumn(name = "id_tipoDeArticulo")
    private TipoArticulo tipoDeArticulo;
    private String nombre;
    private Double precioVenta;
    private Double precioCompra;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public TipoArticulo getTipoDeArticulo() {
        return tipoDeArticulo;
    }
    public void setTipoDeArticulo(TipoArticulo tipoDeArticulo) {
        this.tipoDeArticulo = tipoDeArticulo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
    public Double getPrecioCompra() {
        return precioCompra;
    }
    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    
}
