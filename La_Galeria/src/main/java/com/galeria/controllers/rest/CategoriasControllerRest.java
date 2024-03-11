package com.galeria.controllers.rest;

import java.sql.SQLException;
import java.util.Optional;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galeria.entities.CategoriaEntity;

import com.galeria.repositories.CategoriasRepository;

@RestController
@RequestMapping("/v1")
public class CategoriasControllerRest {

	@Autowired
	CategoriasRepository categoriaRepository;

	@GetMapping("/categorias")
	public Iterable<CategoriaEntity> obtenerTodasCategorias() {
		Iterable<CategoriaEntity> categorias = categoriaRepository.findAll();

		return categorias;
	}

	@PostMapping("/categorias")
	public ResponseEntity insertarCategorias(@RequestBody CategoriaEntity categoria)
			throws ClassNotFoundException, SQLException, NamingException {

		categoriaRepository.save(categoria);

		return new ResponseEntity<>("Categoria insertada correctamente", HttpStatus.OK);
	}

	@PutMapping("/categorias")
	public ResponseEntity actualizarCategoria(@RequestBody CategoriaEntity categoria) {
		categoriaRepository.save(categoria);
		 return new ResponseEntity<>("Categoría actualizada con éxito", HttpStatus.OK);
//	    Optional<CategoriaEntity> categoriaExistente = categoriaRepository.findById(String.valueOf(id));
//	    if (categoriaExistente.isPresent()) {
//	        CategoriaEntity categoriaActualizada = categoriaExistente.get();
//	        categoriaRepository.save(categoriaActualizada);
//	        return new ResponseEntity<>("Categoría actualizada con éxito", HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>("Categoría no encontrada", HttpStatus.NOT_FOUND);
//	    }
	}

	
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity borrarCategoria(@PathVariable("id") Integer id) {
	CategoriaEntity categoria = categoriaRepository.findById(String.valueOf(id)).orElse(null);
	if (categoria != null) {
	categoria.setActivo(0);
	categoriaRepository.save(categoria);
	return new ResponseEntity<>("Categoria borrada con éxito", HttpStatus.OK);
	} else {
	return new ResponseEntity<>("No se encontró la categoría", HttpStatus.NOT_FOUND);
	}
	}
}
