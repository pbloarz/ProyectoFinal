package com.seminario.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.HttpStatus;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RespuestaPersonalizada {

    private String codigo;
    private String mensaje;
    private int estado;
    private Object objectoRespuesta;

    public RespuestaPersonalizada() {
    }

    public RespuestaPersonalizada(String mensaje, HttpStatus estado) {
        super();
        this.mensaje = mensaje;
        this.estado = estado.value();
        this.codigo = estado.name();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Object getObjectoRespuesta() {
        return objectoRespuesta;
    }

    public void setObjectoRespuesta(Object objectoRespuesta) {
        this.objectoRespuesta = objectoRespuesta;
    }
}