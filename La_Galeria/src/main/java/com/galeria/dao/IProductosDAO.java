package com.galeria.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.galeria.dtos.ProductosDTO;

public interface IProductosDAO {

	public List<ProductosDTO> buscarProductos(String id, String nombre, String descripcion, String precio, String cantidadEnStock)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarProductos(String nombre, String descripcion, String precio, String cantidadEnStock) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarProductos(String id, String nombre, String descripcion, String precio, String cantidadEnStock) throws ClassNotFoundException, SQLException, NamingException;
}
