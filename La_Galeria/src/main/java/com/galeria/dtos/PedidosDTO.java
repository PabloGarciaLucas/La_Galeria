package com.galeria.dtos;

public class PedidosDTO {

	private String id;
	private String usuario;
	private String fechaPedido;
	
	public PedidosDTO() {
		super();
	}

	public PedidosDTO(String id, String usuario, String fechaPedido) {
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
	
	

}
