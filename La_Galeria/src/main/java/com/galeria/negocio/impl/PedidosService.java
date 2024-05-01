package com.galeria.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.ICategoriasDAO;
import com.galeria.dao.IPedidosDAO;
import com.galeria.dtos.PedidosDTO;
import com.galeria.entities.User;
import com.galeria.negocio.IPedidosService;

@Component
public class PedidosService implements IPedidosService{
	
	@Autowired
	IPedidosDAO pedidosDAO;

	@Override
	public List<PedidosDTO> buscarPedidos(String id, User usuario, String fechapedido)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return pedidosDAO.buscarPedidos(id, usuario, fechapedido);
	}

	@Override
	public Integer insertarPedidos(User usuario, String fechapedido)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return pedidosDAO.insertarPedidos(usuario, fechapedido);
	}

	@Override
	public Integer actualizarPedidos(String id, User usuario, String fechapedido)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return pedidosDAO.actualizarPedidos(id, usuario, fechapedido);
	}

}
