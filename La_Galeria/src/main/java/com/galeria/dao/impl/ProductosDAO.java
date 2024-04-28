package com.galeria.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.IProductosDAO;
import com.galeria.dtos.PedidosDTO;
import com.galeria.repositories.ProductoRepository;

@Component("ProductosDAO")

public class ProductosDAO implements IProductosDAO{
	
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public List<PedidosDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String cantidadEnStock) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertarProductos(String nombre, String descripcion, String precio, String cantidadEnStock)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer actualizarProductos(String id, String nombre, String descripcion, String precio,
			String cantidadEnStock) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
