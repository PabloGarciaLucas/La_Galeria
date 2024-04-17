package com.galeria.entities;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagenes")
public class ImagenEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Imagen")
    private Integer idImagen;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    @Column(name = "Imagen", nullable = false)
    private Blob imagen;
    
	public ImagenEntity() {
		super();
	}

	public ImagenEntity(Integer idImagen) {
		super();
		this.idImagen = idImagen;
	}

	public ImagenEntity(Integer idImagen, String descripcion) {
		super();
		this.idImagen = idImagen;
		this.descripcion = descripcion;
	}

	public ImagenEntity(String descripcion, Blob imagen) {
		super();
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public ImagenEntity(Integer idImagen, String descripcion, Blob imagen) {
		super();
		this.idImagen = idImagen;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public Integer getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Blob getImagen() {
		return imagen;
	}

	public void setImagen(Blob imagen) {
		this.imagen = imagen;
	}
	
	

	
}
