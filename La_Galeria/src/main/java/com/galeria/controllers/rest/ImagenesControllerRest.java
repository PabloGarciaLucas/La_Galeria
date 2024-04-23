package com.galeria.controllers.rest;

import java.sql.SQLException;

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
import org.springframework.web.bind.annotation.RestController;

import com.galeria.entities.ImagenEntity;
import com.galeria.negocio.impl.ImagenesService;
import com.galeria.repositories.ImagenesRepository;

@RestController
@RequestMapping("/v1")
public class ImagenesControllerRest {
	
	@Autowired
	ImagenesService imagenesServicio;
	@Autowired
	ImagenesRepository imagenRepository;
	
	@GetMapping("/imagenes")
	public Iterable<ImagenEntity> obtenerTodasImagenes(){
		Iterable<ImagenEntity> imagenEntity = imagenRepository.findAll();
		
		return imagenEntity;
	}
	
	@GetMapping("/imagenes/{id}")
	public ImagenEntity obtenerImagenPorID(@PathVariable("idImagen") Integer id) {
		return imagenRepository.findById(id).orElse(null);
	}

	
	@PostMapping("/imagenes")
	public ResponseEntity insertarImagenes(@RequestBody ImagenEntity imagenEntity) throws ClassNotFoundException, SQLException, NamingException {
		
		Integer resultado = imagenesServicio.insertarImagenes(imagenEntity.getDescripcion(), imagenEntity.getImagen());
		return new ResponseEntity<>("Imagen insertada correctamente", HttpStatus.OK);
	}
	
	@PutMapping("/imagenes")
	public ResponseEntity actualizarImagenes(@RequestBody ImagenEntity imagenEntity) {
		imagenRepository.save(imagenEntity);
		
		return new ResponseEntity<>("Imagen actualizada correctamente", HttpStatus.OK);
	}
}
