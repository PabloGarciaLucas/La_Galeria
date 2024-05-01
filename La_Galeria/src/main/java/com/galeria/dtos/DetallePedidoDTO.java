package com.galeria.dtos;

import java.util.List;

import com.galeria.entities.PedidoEntity;
import com.galeria.entities.ProductoEntity;

public class DetallePedidoDTO {

	private String id;
	private ProductoEntity idProducto;
	private PedidoEntity idPedido;
	private Integer cantidad;
	private Double precio;

	public DetallePedidoDTO() {
		super();
	}

	public DetallePedidoDTO(String id, ProductoEntity idProducto, PedidoEntity idPedido, Integer cantidad,
			Double precio) {
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

	public ProductoEntity getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(ProductoEntity idProducto) {
		this.idProducto = idProducto;
	}

	public PedidoEntity getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(PedidoEntity idPedido) {
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
