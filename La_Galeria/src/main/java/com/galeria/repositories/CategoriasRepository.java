package com.galeria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.galeria.dtos.CategoriasDTO;
import com.galeria.entities.CategoriaEntity;



public interface CategoriasRepository extends CrudRepository<CategoriaEntity, String>{

	
	
}
