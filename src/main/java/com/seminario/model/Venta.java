package com.seminario.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "ventas")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String nit;
	String direccion;
	Integer telefono;
	Double totalVenta;
	Double dineroRecibido;
	Double cambio;
	String fecha = String.valueOf(LocalDate.now());
	String vendedor;
	
	@OneToOne
	@JoinColumn(name = "id_caja")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	Caja cajaFacturada;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_venta")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	List<FArticulo> farticulos;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNit() {
		return nit;
	}


	public void setNit(String nit) {
		this.nit = nit;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Integer getTelefono() {
		return telefono;
	}


	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}


	public Double getTotalVenta() {
		return totalVenta;
	}


	public void setTotalVenta(Double totalVenta) {
		this.totalVenta = totalVenta;
	}


	public Double getDineroRecibido() {
		return dineroRecibido;
	}


	public void setDineroRecibido(Double dineroRecibido) {
		this.dineroRecibido = dineroRecibido;
	}


	public Double getCambio() {
		return cambio;
	}


	public void setCambio(Double cambio) {
		this.cambio = cambio;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getVendedor() {
		return vendedor;
	}


	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}


	


	public Caja getCajaFacturada() {
		return cajaFacturada;
	}


	public void setCajaFacturada(Caja cajaFacturada) {
		this.cajaFacturada = cajaFacturada;
	}


	public List<FArticulo> getFarticulos() {
		return farticulos;
	}


	public void setFarticulos(List<FArticulo> farticulos) {
		this.farticulos = farticulos;
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
