package com.galeria.controllers.rest;

import java.sql.SQLException;
import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galeria.entities.CategoriaEntity;
import com.galeria.negocio.impl.CategoriaService;
import com.galeria.repositories.CategoriasRepository;

@RestController
@RequestMapping("/v1")
public class CategoriasControllerRest {
	
	@Autowired
	CategoriaService categoriasServicio;
	@Autowired
	CategoriasRepository categoriaRepository;
	
	@GetMapping("/categorias")
	public Iterable<CategoriaEntity> obtenerTodasCategorias(){
		Iterable<CategoriaEntity> categorias = categoriaRepository.findAll();
		
		return categorias;
	}
	
	@PostMapping("/categorias")
	public ResponseEntity insertarCategorias(@RequestBody CategoriaEntity categoria) throws ClassNotFoundException, SQLException, NamingException {
		
		Integer resultado = categoriasServicio.insertarCategorias(categoria.getNombre(), categoria.getDescripcion(), categoria.getActivo().toString());
		return new ResponseEntity<>("Categoria insertada correctamente", HttpStatus.OK);
	}
	
	@PutMapping("/categorias")
	public ResponseEntity actualizarCategorias(@RequestBody CategoriaEntity categoria) {
		categoriaRepository.save(categoria);
		
		return new ResponseEntity<>("Categoría actualizada correctamente", HttpStatus.OK);
	}
	
	@DeleteMapping("/categorias")
	public ResponseEntity borrarCategorias(@RequestBody CategoriaEntity categoria) {
		
		
		categoria.setActivo(0);
		categoriaRepository.save(categoria);
		
		return new ResponseEntity<>("Categoría borrada correctamente", HttpStatus.OK);
	}
}
