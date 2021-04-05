package com.seminario.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "NIT")
	private double NIT;
	@Column(name = "departamento")
	private String departamento;
	@Column(name = "ciudad")
	private String ciudad;
	@Column(name = "telefono")
	private double telefono;
	@Column(name = "responsabilidad_fiscal")
	private String responsabilidadFiscal;
	@Column(name = "correo")
	private String correo;
	@Column(name = "contacto")
	private String contacto;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "fecha_creacion")
	private String fechaCreacion = String.valueOf(LocalDate.now());
	
	private Proveedor() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNIT() {
		return NIT;
	}

	public void setNIT(double nIT) {
		NIT = nIT;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public double getTelefono() {
		return telefono;
	}

	public void setTelefono(double telefono) {
		this.telefono = telefono;
	}

	public String getResponsabilidadFiscal() {
		return responsabilidadFiscal;
	}

	public void setResponsabilidadFiscal(String responsabilidadFiscal) {
		this.responsabilidadFiscal = responsabilidadFiscal;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
