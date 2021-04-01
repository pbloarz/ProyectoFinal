package com.seminario.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Articulo {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private TipoArticulo tipoDeArticulo;
    private String nombre;
    private Double precioVenta;
    private Double precioCompra;
    private Date fechaCreacion;

    public int getId() {
        return id;
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
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    

}
