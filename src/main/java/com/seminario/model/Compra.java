package com.seminario.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Compra")
public class Compra implements Serializable {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_compra")
    private Long id;
    
    private String fechaYHora;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id")
    private Proveedor proveedor;

    public Compra() {
        this.fechaYHora = Util.obtenerFechaYHoraActual();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(String fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

}