package com.galeria.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.galeria.dtos.DetallePedidoDTO;

public interface IDetallePedidosDAO {
	
	public List<DetallePedidoDTO> buscarDetallePedidos(String id, String idProducto, String idPedido, String cantidad, String stock)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarDetallePedidos(String idProducto, String idPedido, String cantidad, String stock) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarDetallePedidos(String id, String idProducto, String idPedido, String cantidad, String stock) throws ClassNotFoundException, SQLException, NamingException;

}
