package com.galeria.repositories;

import java.sql.Blob;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.galeria.dtos.ImagenesDTO;
import com.galeria.entities.ImagenEntity;

@Repository
public interface ImagenesRepository extends CrudRepository<ImagenEntity, Integer> {

	@Query(value= "select new com.galeria.dtos.ImagenesDTO (i.idImagen, i.descripcion, i.imagen) "
			+ " from com.galeria.entities.ImagenEntity i "
			+ " where i.idImagen = :idImagen "
			+ " AND i.descripcion like CONCAT ('%',:descripcion,'%') "
			+ " AND i.imagen = :imagen ")
	List<ImagenesDTO>buscarImagenes(@Param("idImagen") Integer idImagen,
			@Param("descripcion") String descripcion,
			@Param("imagen") byte[] imagen);
	
	@Query(value="select new com.galeria.dtos.ImagenesDTO (i.idImagen, i.descripcion) "
			+ " from com.galeria.entities.ImagenEntity i ")
	List<ImagenesDTO>buscarImagenesParaCombo(@Param("idImagen") Integer idImagen,
			@Param("descripcion") String descripcion);
	
}
