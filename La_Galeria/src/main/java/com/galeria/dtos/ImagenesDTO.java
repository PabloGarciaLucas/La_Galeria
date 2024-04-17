package com.galeria.dtos;

import java.sql.Blob;

public class ImagenesDTO {
	private Integer idImagen;
	private String descripcion;
	private Blob imagen;
	
	public ImagenesDTO() {
		super();
	}
	public ImagenesDTO(Integer idImagen) {
		super();
		this.idImagen = idImagen;
	}
	public ImagenesDTO(Integer idImagen, String descripcion) {
		super();
		this.idImagen = idImagen;
		this.descripcion = descripcion;
	}
	public ImagenesDTO(Integer idImagen, String descripcion, Blob imagen) {
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
