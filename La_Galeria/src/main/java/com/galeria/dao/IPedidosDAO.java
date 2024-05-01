package com.galeria.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import com.galeria.dtos.PedidosDTO;
import com.galeria.entities.User;

public interface IPedidosDAO {
	public List<PedidosDTO> buscarPedidos(String id, User usuario, String fechapedido)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarPedidos(User usuario, String fechapedido) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarPedidos(String id, User usuario, String fechapedido) throws ClassNotFoundException, SQLException, NamingException;
	
	

}
