package com.galeria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.galeria.dtos.DetallePedidoDTO;
import com.galeria.entities.DetallePedidoEntity;

public interface DetallePedidoRepository extends CrudRepository<DetallePedidoEntity, String>{

	@Query("select new com.galeria.dtos.DetallePedidoDTO (d.id, d.pedido, d.producto, d.cantidad, d.precio) " +
		       "from com.galeria.entities.DetallePedidoEntity d " +
		       " where d.id like CONCAT ('%',:id,'%') " +
		       " AND d.pedido like CONCAT ('%',:idPedido,'%') " +
		       " AND d.producto like CONCAT ('%',:idProducto,'%') " +
		       " AND d.cantidad like CONCAT ('%',:cantidad,'%') " +
		       " AND d.precio like CONCAT ('%',:precio,'%') ")

	List<DetallePedidoDTO>buscarDetallePedidos(
			@Param("id") String id,
			@Param("idPedido") String idProducto,
			@Param("idProducto") String idPedido,
			@Param("cantidad") String cantidad,
			@Param("precio") String precio);


}
