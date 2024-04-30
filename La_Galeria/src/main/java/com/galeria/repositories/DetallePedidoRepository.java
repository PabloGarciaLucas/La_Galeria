package com.galeria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.galeria.dtos.DetallePedidoDTO;
import com.galeria.dtos.PedidosDTO;
import com.galeria.entities.DetallePedidoEntity;

public interface DetallePedidoRepository extends CrudRepository<DetallePedidoEntity, String>{

	@Query("select new com.galeria.dtos.DetallePedidoDTO (d.id, d.idProducto, d.idPedido, d.cantidad, d.precio) " +
		       "from com.galeria.entities.DetallePedidoEntity d " +
		       "where d.id like CONCAT ('%',:id,'%') " +
		       "AND d.idProducto like CONCAT ('%',:idProducto,'%') " +
		       "AND d.idPedido like CONCAT ('%',:idPedido,'%') " +
		       "AND d.cantidad like CONCAT ('%',:cantidad,'%') " +
		       "AND d.precio like CONCAT ('%',:precio,'%')")

	List<DetallePedidoDTO>buscarDetallePedidos(
			@Param("id") String id,
			@Param("idProducto") String idProducto,
			@Param("idPedido") String idPedido,
			@Param("cantidad") String cantidad,
			@Param("precio") String stock);


}
