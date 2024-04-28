package com.galeria.dtos;

public class DetallePedidoDTO {

	private String id;
	private String idProducto;
	private String idPedido;
	private String cantidad;
	private String stock;

	public DetallePedidoDTO() {
		super();
	}

	public DetallePedidoDTO(String id, String idProducto, String idPedido, String cantidad, String stock) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.idPedido = idPedido;
		this.cantidad = cantidad;
		this.stock = stock;
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

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

}
