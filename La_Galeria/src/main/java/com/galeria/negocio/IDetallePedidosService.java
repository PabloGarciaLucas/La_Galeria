package com.galeria.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.galeria.dtos.DetallePedidoDTO;
import com.galeria.entities.PedidoEntity;
import com.galeria.entities.ProductoEntity;

public interface IDetallePedidosService {
	public List<DetallePedidoDTO> buscarDetallePedidos(String id, ProductoEntity idProducto, PedidoEntity idPedido, Integer cantidad, Double precio)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarDetallePedidos(ProductoEntity idProducto, PedidoEntity idPedido, Integer cantidad, Double precio) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarDetallePedidos(String id, ProductoEntity idProducto, PedidoEntity idPedido, Integer cantidad, Double precio) throws ClassNotFoundException, SQLException, NamingException;
}
