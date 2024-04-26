package com.galeria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.galeria.dtos.CategoriasDTO;
import com.galeria.dtos.PedidosDTO;
import com.galeria.entities.PedidoEntity;



public interface PedidoRepository extends CrudRepository<PedidoEntity, String>{
	
	@Query(value= "select new com.galeria.dtos.PedidosDTO (p.id, p.usuario, p.fechaPedido) "
			+ " from com.galeria.entities.PedidoEntity p "
			+ " where  p.id like CONCAT ('%',:id,'%') "
			+ " and p.usuario like CONCAT ('%',:usuario,'%') "
			+ " and p.fechaPedido like CONCAT ('%',:fechaPedido,'%') ")
	List<PedidosDTO>buscarPedidos(@Param("id") String id,
			@Param("usuario") String usuario,
			@Param("fechaPedido") String fechaPedido);
	
	@Query(value="select new com.galeria.dtos.PedidosDTO (p.id, p.usuario) "
			+ " from com.galeria.entities.PedidoEntity p ")
	List<PedidosDTO>buscarPedidosParaCombo(@Param("id") Integer id,
			@Param("usuario") String usuario);

}
