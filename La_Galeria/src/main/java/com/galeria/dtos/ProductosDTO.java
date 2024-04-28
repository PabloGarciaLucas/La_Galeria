package com.galeria.dtos;

public class ProductosDTO {

	private String id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer cantidadEnStock;

	public ProductosDTO() {
		super();
	}

	public ProductosDTO(String id, String nombre, String descripcion, Double precio, Integer cantidadEnStock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getcantidadEnStockk() {
		return cantidadEnStock;
	}

	public void setcantidadEnStock(Integer cantidadStock) {
		this.cantidadEnStock = cantidadStock;
	}

}
