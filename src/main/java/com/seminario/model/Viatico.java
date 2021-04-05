package com.seminario.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "viaticos")
public class Viatico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "viatico_id")
    private Integer id;

    @Column(name = "viatico_val")
    @NotNull(message = "El valor del viatico no puede ser vacio")
    private double valor;

    @Column(name = "viatico_tip")
    @NotNull(message = "El tipo de viatico no puede estar vacio")
    private String tipoGasto;

    @Column(name = "viatico_fec")
    private Date fecha = fechaConvertida();
    
    @JoinColumn(name = "usuario_id")
    @ManyToOne
    @NotNull(message = "El usuario que autorizo el gasto no puede estar vacio")
    private Usuario usuarioAutorizo;

    public Viatico() {
        super();
    }

    public Viatico( double valor, String tipoGasto, Usuario usuarioAutorizo) {
        this.valor = valor;
        this.tipoGasto = tipoGasto;
        this.usuarioAutorizo = usuarioAutorizo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuarioAutorizo() {
        return usuarioAutorizo;
    }

    public void setUsuarioAutorizo(Usuario usuarioAutorizo) {
        this.usuarioAutorizo = usuarioAutorizo;
    }

    public Date fechaConvertida(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        Date fechaActual= Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());;
        return fechaActual; 
    }
}
