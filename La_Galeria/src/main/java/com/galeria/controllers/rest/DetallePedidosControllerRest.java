package com.galeria.controllers.rest;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galeria.entities.DetallePedidoEntity;
import com.galeria.repositories.DetallePedidoRepository;

@RestController
@RequestMapping("/v1")
public class DetallePedidosControllerRest {
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	
	@GetMapping("/detallePedido")
	public Iterable<DetallePedidoEntity> obtenerTodosDetallesPedidos() {
		Iterable<DetallePedidoEntity> detallePedido = detallePedidoRepository.findAll();

		return detallePedido;
	}
	
	@PostMapping("/detallePedido")
	public ResponseEntity insertarDetallesPedidos(@RequestBody DetallePedidoEntity detallePedido)
			throws ClassNotFoundException, SQLException, NamingException {

		detallePedidoRepository.save(detallePedido);

		return new ResponseEntity<>("Detalle del Pedido insertado correctamente", HttpStatus.OK);
	}

	@PutMapping("/detallePedido")
	public ResponseEntity actualizarDetallesPedido(@RequestBody DetallePedidoEntity detallePedido) {
		detallePedidoRepository.save(detallePedido);
		 return new ResponseEntity<>("Detalle del Pedido actualizado con éxito", HttpStatus.OK);
	}
}
