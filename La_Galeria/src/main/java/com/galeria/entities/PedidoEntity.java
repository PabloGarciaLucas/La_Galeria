package com.galeria.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Pedido")
	private String id;

	@ManyToOne
	@JoinColumn(name = "ID_Cliente")
	@JsonBackReference
	private User usuario;

	@Column(name = "FechaPedido")
	private String fechaPedido;

	@OneToMany(mappedBy = "pedido")
	@JsonManagedReference
	private Set<DetallePedidoEntity> detallePedidos;

	
	public PedidoEntity(User usuario) {
		super();
		this.usuario = usuario;
	}

	public PedidoEntity(String id) {
		super();
		this.id = id;
	}

	public PedidoEntity(String id, User usuario) {
		super();
		this.id = id;
		this.usuario = usuario;
	}

	public PedidoEntity(String id, User usuario, String fechaPedido) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.fechaPedido = fechaPedido;
	}

	public PedidoEntity() {
		super();
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

	public Set<DetallePedidoEntity> getDetallePedidos() {
		return detallePedidos;
	}

	public void setDetallePedidos(Set<DetallePedidoEntity> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}

}