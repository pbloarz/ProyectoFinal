package com.seminario.model;

//librerias usadas
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Caja")
public class Caja {
	
	//Atributos de caja
	@Id
	@Column(name="id_caja")
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //Id automatico
	private Integer id_caja;
	private String nombrecaja;
	private String ubicacion;
	private String observacion;
	private String sede;
	private Date fecha;
	
	// getters and setters

	public Integer getId_caja() {
		return id_caja;
	}
	public void setId_caja(Integer id_caja) {
		this.id_caja = id_caja;
	}
	public String getNombrecaja() {
		return nombrecaja;
	}
	public void setNombrecaja(String nombrecaja) {
		this.nombrecaja = nombrecaja;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	

}
