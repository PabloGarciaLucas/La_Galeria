package com.galeria.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.galeria.dtos.ProductosDTO;
import com.galeria.entities.CategoriaEntity;

public interface IProductosDAO {

	public List<ProductosDTO> buscarProductos(Integer id, String nombre, String descripcion, Double precio, Integer cantidadEnStock, CategoriaEntity categoria)
			throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarProductos(String nombre, String descripcion, Double precio, Integer cantidadEnStock, CategoriaEntity categoria) throws ClassNotFoundException, SQLException, NamingException;

	public Integer actualizarProductos(Integer id, String nombre, String descripcion, Double precio, Integer cantidadEnStock, CategoriaEntity categoria) throws ClassNotFoundException, SQLException, NamingException;
}
