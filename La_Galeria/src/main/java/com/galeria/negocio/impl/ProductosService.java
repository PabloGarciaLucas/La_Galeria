package com.galeria.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.galeria.dao.IProductosDAO;
import com.galeria.dtos.ProductosDTO;
import com.galeria.entities.CategoriaEntity;
import com.galeria.negocio.IProductosService;

@Component
public class ProductosService implements IProductosService{
	
	@Autowired
	IProductosDAO productosDAO;

	@Override
	public List<ProductosDTO> buscarProductos(Integer id, String nombre, String descripcion, Double precio,
			Integer cantidadEnStock, CategoriaEntity categoria) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return productosDAO.buscarProductos(id, nombre, descripcion, precio, cantidadEnStock, categoria);
	}

	@Override
	public Integer insertarProductos(String nombre, String descripcion, Double precio, Integer cantidadEnStock, CategoriaEntity categoria)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return productosDAO.insertarProductos(nombre, descripcion, precio, cantidadEnStock, categoria);
	}

	@Override
	public Integer actualizarProductos(Integer id, String nombre, String descripcion, Double precio,
			Integer cantidadEnStock, CategoriaEntity categoria) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return productosDAO.actualizarProductos(id, nombre, descripcion, precio, cantidadEnStock, categoria);
	}

}
