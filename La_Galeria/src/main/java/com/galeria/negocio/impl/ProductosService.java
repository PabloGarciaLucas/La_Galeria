package com.galeria.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.IProductosDAO;
import com.galeria.dtos.ProductosDTO;
import com.galeria.negocio.IProductosService;

@Component
public class ProductosService implements IProductosService{
	
	@Autowired
	IProductosDAO productosDAO;

	@Override
	public List<ProductosDTO> buscarProductos(String id, String nombre, String descripcion, String precio,
			String cantidadEnStock) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return productosDAO.buscarProductos(id, nombre, descripcion, precio, cantidadEnStock);
	}

	@Override
	public Integer insertarProductos(String nombre, String descripcion, String precio, String cantidadEnStock)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return productosDAO.insertarProductos(nombre, descripcion, precio, cantidadEnStock);
	}

	@Override
	public Integer actualizarProductos(String id, String nombre, String descripcion, String precio,
			String cantidadEnStock) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return productosDAO.actualizarProductos(id, nombre, descripcion, precio, cantidadEnStock);
	}

}
