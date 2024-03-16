package com.galeria.controllers.rest;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galeria.entities.PedidoEntity;
import com.galeria.repositories.PedidoRepository;

@RestController
@RequestMapping("/v1")
public class PedidosControllerRest {
	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping("/pedidos")
	public Iterable<PedidoEntity> obtenerTodasPedidos() {
		Iterable<PedidoEntity> pedidos = pedidoRepository.findAll();

		return pedidos;
	}
	
	@PostMapping("/pedidos")
	public ResponseEntity insertarPedidos(@RequestBody PedidoEntity pedido)
			throws ClassNotFoundException, SQLException, NamingException {

		pedidoRepository.save(pedido);

		return new ResponseEntity<>("Pedido insertado correctamente", HttpStatus.OK);
	}

	@PutMapping("/pedidos")
	public ResponseEntity actualizarPedido(@RequestBody PedidoEntity pedido) {
		pedidoRepository.save(pedido);
		 return new ResponseEntity<>("Pedido actualizado con éxito", HttpStatus.OK);
	}
}
