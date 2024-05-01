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

import com.galeria.dtos.ImagenesDTO;
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
	
	@GetMapping("/imagenes/{idImagen}")
	public ResponseEntity<ImagenEntity>obtenerImagenPorId(@PathVariable("idImagen") Integer idImagen){
		
		ImagenEntity imagen = imagenRepository.findById(idImagen).get();
		
		return new ResponseEntity<>(imagen, HttpStatus.OK);
	}
	
	@GetMapping(value="/imagenes", params = {"idImagen", "descripcion", "imagen"})
	public List<ImagenesDTO>buscarImagenesConFiltros(@RequestParam(value = "idImagen", required =false) Integer idImagen,
			@RequestParam(value= "descripcion", required=false) String descripcion,
			@RequestParam(value= "imagen", required=false) byte[] imagen){
		List<ImagenesDTO> i = imagenRepository.buscarImagenes(idImagen, descripcion, imagen);
		
		return i;
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
