package com.galeria.dtos;

import com.galeria.entities.User;

public class PedidosDTO {

	private String id;
	private User usuario;
	private String fechaPedido;
	
	public PedidosDTO() {
		super();
	}

	public PedidosDTO(String id, User usuario, String fechaPedido) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fechaPedido = fechaPedido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	

}
