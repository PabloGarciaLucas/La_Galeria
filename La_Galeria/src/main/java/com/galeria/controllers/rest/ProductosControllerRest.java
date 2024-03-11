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
import com.galeria.entities.ProductoEntity;
import com.galeria.repositories.ProductoRepository;

@RestController
@RequestMapping("/v1")
public class ProductosControllerRest {

	@Autowired
	ProductoRepository productosRepository;

	@GetMapping("/productos")
	public Iterable<ProductoEntity> obtenerTodasProductos() {
		Iterable<ProductoEntity> productos = productosRepository.findAll();

		return productos;
	}

	@PostMapping("/productos")
	public ResponseEntity insertarProductos(@RequestBody ProductoEntity producto)
			throws ClassNotFoundException, SQLException, NamingException {

		productosRepository.save(producto);

		return new ResponseEntity<>("Producto insertado correctamente", HttpStatus.OK);
	}

	@PutMapping("/productos")
	public ResponseEntity actualizarProducto(@RequestBody ProductoEntity producto) {
		productosRepository.save(producto);
		return new ResponseEntity<>("Producto actualizado con éxito", HttpStatus.OK);
	}

}
