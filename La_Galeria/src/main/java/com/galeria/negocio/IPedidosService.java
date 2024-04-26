package com.galeria.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.galeria.dtos.PedidosDTO;

public interface IPedidosService {
	public List<PedidosDTO> buscarPedidos(String id, String usuario, String fechapedido)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarPedidos(String usuario, String fechapedido) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarPedidos(String id, String usuario, String fechapedido) throws ClassNotFoundException, SQLException, NamingException;

}
