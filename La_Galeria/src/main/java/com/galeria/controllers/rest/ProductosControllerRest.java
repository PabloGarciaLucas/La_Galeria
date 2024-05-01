package com.galeria.controllers.rest;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galeria.dtos.CategoriasDTO;
import com.galeria.dtos.ProductosDTO;
import com.galeria.entities.CategoriaEntity;
import com.galeria.entities.ProductoEntity;
import com.galeria.negocio.impl.ProductosService;
import com.galeria.repositories.ProductoRepository;

@RestController
@RequestMapping("/v1")
public class ProductosControllerRest {

	@Autowired
	ProductosService productoServicio;
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping("/productos")
	public Iterable<ProductoEntity> obtenerTodosProductos(){
		Iterable<ProductoEntity> productoEntity = productoRepository.findAll();
		
		return productoEntity;
	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<ProductoEntity>obtenerProductoPorId(@PathVariable("id") Integer id){
		
		ProductoEntity producto = productoRepository.findById(id).get();
		
		return new ResponseEntity<>(producto, HttpStatus.OK);
	}
	
	@GetMapping(value="/productos", params = {"id", "nombre", "descripcion", "precio", "cantidadEnStock", "categoria"})
	public List<ProductosDTO>buscarProductosConFiltros(@RequestParam(value = "id", required =false) Integer id,
			@RequestParam(value= "nombre", required=false) String nombre,
			@RequestParam(value= "descripcion", required=false) String descripcion,
			@RequestParam(value= "precio", required=false) Double precio,
			@RequestParam(value= "cantidadEnStock", required=false) Integer cantidadEnStock,
			@RequestParam(value= "categoria", required=false) CategoriaEntity categoria){
		List<ProductosDTO> p = productoRepository.buscarProductos(id, nombre, descripcion, precio, cantidadEnStock, categoria);
		
		return p;
	}
	
	@PostMapping("/productos")
	public ResponseEntity insertarProductos(@RequestBody ProductoEntity productoEntity) throws ClassNotFoundException, SQLException, NamingException {
		
		Integer resultado = productoServicio.insertarProductos(productoEntity.getNombre(), productoEntity.getDescripcion(), productoEntity.getPrecio(), productoEntity.getCantidadEnStock(), productoEntity.getCategoria());
		return new ResponseEntity<>("Producto insertado correctamente", HttpStatus.OK);
	}
	
	@PutMapping("/productos")
	public ResponseEntity actualizarProductos(@RequestBody ProductoEntity productoEntity) {
		productoRepository.save(productoEntity);
		
		return new ResponseEntity<>("Producto actualizado correctamente", HttpStatus.OK);
	}

}
