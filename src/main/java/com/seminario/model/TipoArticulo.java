/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seminario.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "TArticulo")
public class TipoArticulo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTA;
    
    
    @Column(name = "nombreTA")
    private String nombreTA;
    
    @Column(name = "referencia")
    private String referencia;
    
    @Column(name = "unidadMedida")
    private String unidadDeMedida;
    
    @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
    @Column(name = "fechaCreacion")
    private String fechaDeCreacion = String.valueOf(LocalDate.now());

    public TipoArticulo() {
    }

    public int getIdTA() {
        return idTA;
    }

    public void setIdTA(int idTA) {
        this.idTA = idTA;
    }

    public String getNombreTA() {
        return nombreTA;
    }

    public void setNombreTA(String nombreTA) {
        this.nombreTA = nombreTA;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    
}
