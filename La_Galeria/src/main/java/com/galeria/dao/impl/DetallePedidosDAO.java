package com.galeria.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.IDetallePedidosDAO;
import com.galeria.dtos.DetallePedidoDTO;
import com.galeria.entities.DetallePedidoEntity;
import com.galeria.entities.PedidoEntity;
import com.galeria.entities.ProductoEntity;
import com.galeria.repositories.DetallePedidoRepository;
import com.galeria.repositories.ProductoRepository;

@Component("DetallePedidosDAO")
public class DetallePedidosDAO implements IDetallePedidosDAO {

	@Autowired
	DetallePedidoRepository detallePedidoRepository;

	@Override
	public List<DetallePedidoDTO> buscarDetallePedidos(String id, ProductoEntity idProducto, PedidoEntity idPedido, Integer cantidad,
			Double precio) throws ClassNotFoundException, SQLException, NamingException {

		return detallePedidoRepository.buscarDetallePedidos(id, idProducto, idPedido, cantidad, precio);
	}

	@Override
	public Integer insertarDetallePedidos(ProductoEntity idProducto, PedidoEntity idPedido, Integer cantidad, Double precio)
			throws ClassNotFoundException, SQLException, NamingException {

		// Consulat idProducto y idPedido
		DetallePedidoEntity detallePedidoEntity = new DetallePedidoEntity(idPedido, idProducto, cantidad, precio);
		detallePedidoRepository.save(detallePedidoEntity);

		return Integer.parseInt(detallePedidoEntity.getId());

	}

	@Override
	public Integer actualizarDetallePedidos(String id, ProductoEntity idProducto, PedidoEntity idPedido, Integer cantidad,
			Double precio) throws ClassNotFoundException, SQLException, NamingException {
		// Consulat idProducto y idPedido
		DetallePedidoEntity detallePedidoEntity = new DetallePedidoEntity(idPedido, idProducto, cantidad, precio);
		detallePedidoRepository.save(detallePedidoEntity);

		return Integer.parseInt(detallePedidoEntity.getId());
	}

}
