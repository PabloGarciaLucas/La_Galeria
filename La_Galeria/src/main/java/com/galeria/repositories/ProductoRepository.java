package com.galeria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.galeria.dtos.CategoriasDTO;
import com.galeria.dtos.ProductosDTO;
import com.galeria.entities.CategoriaEntity;
import com.galeria.entities.ProductoEntity;


@Repository
public interface ProductoRepository extends CrudRepository<ProductoEntity, Integer>{

	@Query(value= "select new com.galeria.dtos.ProductosDTO (p.id, p.nombre, p.descripcion, p.precio, p.cantidadEnStock, p.categoria) "
			+ " from com.galeria.entities.ProductoEntity p "
			+ " where  p.id = :id "
			+ " AND p.nombre like CONCAT ('%',:nombre,'%') "
			+ " AND p.descripcion like CONCAT ('%',:descripcion,'%') "
			+ " AND p.precio = :precio "
			+ " AND p.cantidadEnStock = :cantidadEnStock "
			+ " AND p.categoria = :categoria ")
	List<ProductosDTO>buscarProductos(@Param("id") Integer id,
			@Param("nombre") String nombre,
			@Param("descripcion") String descripcion,
			@Param("precio") Double precio,
			@Param("cantidadEnStock") Integer cantidadEnStock,
			@Param("categoria") CategoriaEntity categoria);
	
	@Query(value="select new com.galeria.dtos.ProductosDTO (p.id, p.nombre) "
			+ " from com.galeria.entities.ProductoEntity p ")
	List<ProductosDTO>buscarProductosParaCombo(@Param("id") Integer id,
			@Param("nombre") String nombre);
			
}
