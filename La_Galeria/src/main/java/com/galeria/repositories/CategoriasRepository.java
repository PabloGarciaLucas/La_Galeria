package com.galeria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.galeria.dtos.CategoriasDTO;
import com.galeria.entities.CategoriaEntity;


@Repository
public interface CategoriasRepository extends CrudRepository<CategoriaEntity, String>{

	@Query(value= "select new com.galeria.dtos.CategoriasDTO (c.id, c.nombre, c.descripcion, c.activo) "
			+ " from com.galeria.entities.CategoriaEntity c "
			+ " where  c.id like CONCAT ('%',:id,'%') "
			+ " and c.nombre like CONCAT ('%',:nombre,'%') "
			+ " and c.descripcion like CONCAT ('%',:descripcion,'%') "
			+ " AND c.activo = :activo ")
	List<CategoriasDTO>buscarCategorias(@Param("id") String id,
			@Param("nombre") String nombre,
			@Param("descripcion") String descripcion,
			@Param("activo") Integer activo);
	
	@Query(value="select new com.galeria.dtos.CategoriasDTO (c.id, c.nombre) "
			+ " from com.galeria.entities.CategoriaEntity c ")
	List<CategoriasDTO>buscarCategoriasParaCombo(@Param("id") Integer id,
			@Param("nombre") String nombre);
	
}
