package com.seminario.model;

import javax.persistence.*;

@Entity
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Float cantidad, precio;
    private String nombre;
    @ManyToOne
    @JoinColumn
    private Compra compra;

    public DetalleCompra(Float cantidad, Float precio, String nombre, Compra compra) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre = nombre;
        this.compra = compra;
    }

    public DetalleCompra() {
    }

    public Float getTotal() {
        return this.cantidad * this.precio;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}