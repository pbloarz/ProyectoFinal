package com.seminario.response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RespuestaPersonalizada {

	private String codigo;
	private String mensaje;
	private int estado;
	private Object objetoRespuesta;
	
	public RespuestaPersonalizada() {
	
	}

	public RespuestaPersonalizada(String mensaje, HttpStatus estado) {
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

	public Object getObjetoRespuesta() {
		return objetoRespuesta;
	}

	public void setObjetoRespuesta(Object objetoRespuesta) {
		this.objetoRespuesta = objetoRespuesta;
	}

	
	
}
