package com.galeria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.galeria.dtos.DetallePedidoDTO;
import com.galeria.entities.DetallePedidoEntity;
import com.galeria.entities.PedidoEntity;
import com.galeria.entities.ProductoEntity;

public interface DetallePedidoRepository extends CrudRepository<DetallePedidoEntity, String>{

	@Query("select new com.galeria.dtos.DetallePedidoDTO (d.id, d.pedido, d.producto, d.cantidad, d.precio) " +
		       "from com.galeria.entities.DetallePedidoEntity d " +
		       " where d.id like CONCAT ('%',:id,'%') " +
		       " AND d.pedido = :idPedido " +
		       " AND d.producto = :idProducto " +
		       " AND d.cantidad = :cantidad " +
		       " AND d.precio = :precio ")

	List<DetallePedidoDTO>buscarDetallePedidos(
			@Param("id") String id,
			@Param("idPedido") ProductoEntity idProducto,
			@Param("idProducto") PedidoEntity idPedido,
			@Param("cantidad") Integer cantidad,
			@Param("precio") Double precio);


}
