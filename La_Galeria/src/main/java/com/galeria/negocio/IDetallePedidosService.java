package com.galeria.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.galeria.dtos.DetallePedidoDTO;

public interface IDetallePedidosService {
	public List<DetallePedidoDTO> buscarDetallePedidos(String id, String idProducto, String idPedido, String cantidad, String precio)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarDetallePedidos(String idProducto, String idPedido, String cantidad, String precio) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarDetallePedidos(String id, String idProducto, String idPedido, String cantidad, String precio) throws ClassNotFoundException, SQLException, NamingException;
}
