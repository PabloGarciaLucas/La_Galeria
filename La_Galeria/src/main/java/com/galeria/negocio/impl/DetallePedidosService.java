package com.galeria.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.IDetallePedidosDAO;
import com.galeria.dtos.DetallePedidoDTO;
import com.galeria.entities.PedidoEntity;
import com.galeria.entities.ProductoEntity;
import com.galeria.negocio.IDetallePedidosService;

@Component
public class DetallePedidosService implements IDetallePedidosService{
	
	@Autowired
	IDetallePedidosDAO detallePedidosDAO;


	@Override
	public List<DetallePedidoDTO> buscarDetallePedidos(String id, ProductoEntity idProducto, PedidoEntity idPedido, Integer cantidad,
			Double precio) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return detallePedidosDAO.buscarDetallePedidos(id, idProducto, idPedido, cantidad, precio);
	}

	@Override
	public Integer insertarDetallePedidos(ProductoEntity idProducto, PedidoEntity idPedido, Integer cantidad, Double precio)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return detallePedidosDAO.insertarDetallePedidos(idProducto, idPedido, cantidad, precio);
	}

	@Override
	public Integer actualizarDetallePedidos(String id, ProductoEntity idProducto, PedidoEntity idPedido, Integer cantidad,
			Double precio) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return detallePedidosDAO.actualizarDetallePedidos(id, idProducto, idPedido, cantidad, precio);
	}

}
