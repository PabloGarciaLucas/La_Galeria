package com.galeria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.galeria.dtos.PedidosDTO;
import com.galeria.dtos.ProductosDTO;
import com.galeria.entities.ProductoEntity;



public interface ProductoRepository extends CrudRepository<ProductoEntity, String>{

	@Query(value = "select new com.galeria.dtos.ProductosDTO (p.id, p.nombre, p.descripcion, p.precio, p.cantidadEnStock, c.id, c.nombre, p.nombre) "
			+ " from com.galeria.entities.ProductoEntity p "
			+ " inner join com.galeria.entities.CategoriaEntity c on p.categoria.id = c.id "
			+ " where p.id like CONCAT ('%',:id,'%') "
			+ " and p.nombre like CONCAT ('%',:nombre,'%') "
			+ " and p.descripcion like CONCAT ('%',:descripcion,'%') "
			+ " and p.precio >= :precio "
			+ " and p.cantidadEnStock >= :cantidadEnStock "
			+ " and c.id like CONCAT ('%',:categoria,'%') ")
	
	List<ProductosDTO>buscarProductos(@Param("id") String id,
			@Param("nombre") String nombre,
			@Param("descripcion") String descripcion,
			@Param("precio") String precio,
			@Param("cantidadEnStock") String cantidadEnStock);
	
		
	List<ProductosDTO>buscarProductosporIdyNombre(@Param("id") String id,
			@Param("nombre") String nombre,
			@Param("descripcion") String descripcion,
			@Param("precio") Double precio,
			@Param("cantidadEnStock") Integer cantidadEnStock,
			@Param("categoria") String categoria);
			
}
