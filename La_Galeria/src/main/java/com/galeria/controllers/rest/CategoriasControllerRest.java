package com.galeria.controllers.rest;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

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

}
