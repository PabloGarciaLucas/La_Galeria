package com.galeria.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.IPedidosDAO;
import com.galeria.dtos.PedidosDTO;
import com.galeria.entities.CategoriaEntity;
import com.galeria.entities.PedidoEntity;
import com.galeria.entities.User;
import com.galeria.repositories.CategoriasRepository;
import com.galeria.repositories.PedidoRepository;

@Component("PedidosDAO")
public class PedidosDAO implements IPedidosDAO{
	
	@Autowired
	PedidoRepository pedidoRepository;

	@Override
	public List<PedidosDTO> buscarPedidos(String id, User usuario, String fechapedido)
			throws ClassNotFoundException, SQLException, NamingException {
		
		return pedidoRepository.buscarPedidos(id, usuario, fechapedido);
	}

	@Override
	public Integer insertarPedidos(User usuario, String fechapedido)
			throws ClassNotFoundException, SQLException, NamingException {
		
		PedidoEntity pedidoEntity = new PedidoEntity(usuario, fechapedido);
		pedidoRepository.save(pedidoEntity);
		
		return Integer.parseInt(pedidoEntity.getId());
	}

	@Override
	public Integer actualizarPedidos(String id, User usuario, String fechapedido)
			throws ClassNotFoundException, SQLException, NamingException {
		
		//Mirar en la entidad de pedido el User
		PedidoEntity pedidoEntity = new PedidoEntity(id, fechapedido);
		pedidoRepository.save(pedidoEntity);
		
		return Integer.parseInt(pedidoEntity.getId()) ;
	}

	

}
