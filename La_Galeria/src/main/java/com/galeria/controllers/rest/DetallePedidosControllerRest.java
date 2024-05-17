package com.galeria.controllers.rest;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galeria.dtos.DetallePedidoDTO;
import com.galeria.entities.DetallePedidoEntity;
import com.galeria.entities.PedidoEntity;
import com.galeria.entities.ProductoEntity;
import com.galeria.negocio.impl.DetallePedidosService;
import com.galeria.repositories.DetallePedidoRepository;

@RestController
@RequestMapping("/v1")
public class DetallePedidosControllerRest {
	@Autowired
	DetallePedidosService detallePedidoServicio;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	
	@GetMapping("/detallePedido")
	public Iterable<DetallePedidoEntity> obtenerTodosDetalles(){
		Iterable<DetallePedidoEntity> detallePedidoEntity = detallePedidoRepository.findAll();
		
		return detallePedidoEntity;
	}
	
	@GetMapping("/detallePedido/{id}")
	public ResponseEntity<DetallePedidoEntity>obtenerDetallePorId(@PathVariable("id") String id){
		
		DetallePedidoEntity detallePedido = detallePedidoRepository.findById(id).get();
		
		return new ResponseEntity<>(detallePedido, HttpStatus.OK);
	}
	
	@GetMapping(value="/detallePedido", params = {"id", "idProducto", "idPedido", "cantidad", "precio"})
	public List<DetallePedidoDTO>buscarDetallesConFiltros(@RequestParam(value = "id", required =false) String id,
			@RequestParam(value= "idProducto") ProductoEntity idProducto,
			@RequestParam(value= "idPedido") PedidoEntity idPedido,
			@RequestParam(value= "cantidad", required=false) Integer cantidad,
			@RequestParam(value= "precio", required=false) Double precio){
		List<DetallePedidoDTO> d = detallePedidoRepository.buscarDetallePedidos(id, idProducto, idPedido, cantidad, precio);
		
		return d;
	}
	
	@PostMapping(value = "/detallePedido", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity insertarDetalles(@RequestBody DetallePedidoEntity detallePedidoEntity) throws ClassNotFoundException, SQLException, NamingException {
		
		Integer resultado = detallePedidoServicio.insertarDetallePedidos(detallePedidoEntity.getProducto(), detallePedidoEntity.getPedido(), detallePedidoEntity.getCantidad(), detallePedidoEntity.getPrecio());
		return new ResponseEntity<>("Detalle insertado correctamente", HttpStatus.OK);
	}
	
	@PutMapping("/detallePedido")
	public ResponseEntity actualizarDetalles(@RequestBody DetallePedidoEntity detallePedidoEntity) {
		detallePedidoRepository.save(detallePedidoEntity);
		
		return new ResponseEntity<>("Detalle actualizado correctamente", HttpStatus.OK);
	}
}
