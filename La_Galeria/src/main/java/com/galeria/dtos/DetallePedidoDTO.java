package com.galeria.dtos;

public class DetallePedidoDTO {

	private String id;
	private String idProducto;
	private String idPedido;
	private Integer cantidad;
	private Double precio;

	public DetallePedidoDTO() {
		super();
	}

	public DetallePedidoDTO(String id, String idProducto, String idPedido, Integer cantidad, Double precio) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.idPedido = idPedido;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
